package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.model.Activity;
import be.axxes.hackaton.timesheets.model.User;
import be.axxes.hackaton.timesheets.util.DateRange;

public interface ActivityService {
     Iterable<Activity> getActivities(User user, DateRange range);
}
