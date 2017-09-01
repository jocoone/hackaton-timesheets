package be.axxes.hackaton.timesheets.controller;

import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.model.User;
import be.axxes.hackaton.timesheets.services.ProjectService;
import be.axxes.hackaton.timesheets.services.UserService;
import be.axxes.hackaton.timesheets.util.DateRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;


    @RequestMapping
    public List<Project> getProjects(@RequestParam int year, @RequestParam int weekNumber, @RequestParam String username){
        User user = userService.getUserByUsername(username);

        DateRange dateRange = DateRange.forWeek(year, weekNumber);

        System.out.println(dateRange.toString());


        return projectService.getProjectsByUserAndWeek(user, dateRange.getFromDate(), dateRange.getToDate());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createProject(final HttpServletRequest request, @RequestBody final CreateProjectDto createProjectDto){
        Project project = new Project();

        project.setUser(userService.getById(createProjectDto.getUserId()));

        project.setProjectName(createProjectDto.getProjectName());
        project.setDescription(createProjectDto.getDescription());
        project.setStartDate(createProjectDto.getStartDate());
        project.setEndDate(createProjectDto.getEndDate());
        project.setMaxHours(createProjectDto.getMaxHours());

        Project createdProject = projectService.create(project);

        URI location = ServletUriComponentsBuilder.fromContextPath(request)
                .path("/projects/{id}")
                .buildAndExpand(createdProject.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
