package be.axxes.hackaton.timesheets.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import be.axxes.hackaton.timesheets.model.Activity;
import be.axxes.hackaton.timesheets.model.ActivityType;
import be.axxes.hackaton.timesheets.model.BillableActivity;
import be.axxes.hackaton.timesheets.model.NonBillableActivity;
import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.services.ActivityService;
import be.axxes.hackaton.timesheets.services.ActivityTypeService;
import be.axxes.hackaton.timesheets.services.ProjectService;
import be.axxes.hackaton.timesheets.services.UserService;
import be.axxes.hackaton.timesheets.util.DateRange;

@RestController
@RequestMapping("/activities")
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ActivityTypeService activityTypeService;
	
	@Autowired
	private ProjectService projectService;
	
	
	@RequestMapping
    public Iterable<Activity> getActivities(@RequestParam String username, @RequestParam int year, @RequestParam int weekNr){
		return activityService.getActivities(userService.getUserByUsername(username), DateRange.forWeek(year, weekNr));
    }
	
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createActivity(final HttpServletRequest request, @RequestBody final CreateActivityDto createActivityDto) {
        Activity activity ;
        if(createActivityDto.getProjectId()==null){
        	activity = new NonBillableActivity();
        } else{
        	activity = new BillableActivity();
        	BillableActivity billable = (BillableActivity)  activity;
        	billable.setProject(projectService.getById(createActivityDto.getProjectId()));
        }
        activity.setDate(createActivityDto.getDate());
        activity.setDuration(createActivityDto.getDuration());
        activity.setUser(userService.getUserByUsername(createActivityDto.getUsername()));
        activity.setType(activityTypeService.getById(createActivityDto.getActivityTypeId()));
        
    	Activity createdActivity = activityService.create(activity);

        URI location = ServletUriComponentsBuilder.fromContextPath(request) //
                        .path("/activityTypes/{id}") //
                        .buildAndExpand(createdActivity.getId()) //
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateActivity(final HttpServletRequest request, @RequestBody final Activity activity) {
        activityService.update(activity);

        return ResponseEntity.ok().build();
    }
	

}
