package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.model.ActivityType;

public interface ActivityTypeService {

    ActivityType getById(long id);

    Iterable<ActivityType> getNonBillableActivities();

    ActivityType create(ActivityType activityType);

    void update(ActivityType activityType);

}
