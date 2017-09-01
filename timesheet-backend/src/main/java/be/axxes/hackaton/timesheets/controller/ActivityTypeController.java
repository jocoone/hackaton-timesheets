package be.axxes.hackaton.timesheets.controller;

import be.axxes.hackaton.timesheets.model.ActivityType;
import be.axxes.hackaton.timesheets.services.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activityTypes")
public class ActivityTypeController {

    @Autowired
    private ActivityTypeService activityTypeService;

    @RequestMapping
    public Iterable<ActivityType> getNonBillableTypes() {
        return activityTypeService.getNonBillableActivities();
    }

}
