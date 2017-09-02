package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.model.*;
import be.axxes.hackaton.timesheets.util.DateRange;

public interface ActivityService {
     Iterable<Activity> getActivities(User user, DateRange range);
     Activity create(Activity activity);

     void update(Activity activity);

     Iterable<NonBillableActivity> getNonBillableActivities(User user, DateRange range);

     Iterable<BillableActivity> getActivitiesByProject(User user, DateRange range, Project project);
}
