package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.model.ActivityType;

public interface ActivityTypeService {

    Iterable<ActivityType> getNonBillableActivities();

}
