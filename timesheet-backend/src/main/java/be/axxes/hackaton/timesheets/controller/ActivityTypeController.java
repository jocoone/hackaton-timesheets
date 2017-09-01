package be.axxes.hackaton.timesheets.controller;

import be.axxes.hackaton.timesheets.model.ActivityType;
import be.axxes.hackaton.timesheets.services.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/activityTypes")
public class ActivityTypeController {

    @Autowired
    private ActivityTypeService activityTypeService;

    @RequestMapping
    public Iterable<ActivityType> getNonBillableTypes() {
        return activityTypeService.getNonBillableActivities();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createActivityType(final HttpServletRequest request, @RequestBody final ActivityType activityType) {
        ActivityType createdActivityType = activityTypeService.create(activityType);

        URI location = ServletUriComponentsBuilder.fromContextPath(request) //
                        .path("/activityTypes/{id}") //
                        .buildAndExpand(createdActivityType.getId()) //
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateActivityType(final HttpServletRequest request, @RequestBody final ActivityType activityType) {
        activityTypeService.update(activityType);

        return ResponseEntity.ok().build();
    }

}
