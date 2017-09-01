package be.axxes.hackaton.timesheets.controller;

import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.model.User;
import be.axxes.hackaton.timesheets.services.ProjectService;
import be.axxes.hackaton.timesheets.services.UserService;
import be.axxes.hackaton.timesheets.util.DateRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
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


}
