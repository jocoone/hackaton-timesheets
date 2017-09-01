package be.axxes.hackaton.timesheets.controller;

import be.axxes.hackaton.timesheets.model.Project;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @RequestMapping
    public List<Project> getProjects(@RequestParam int weekNumber, @RequestParam String userName){
return null;
    }
}
