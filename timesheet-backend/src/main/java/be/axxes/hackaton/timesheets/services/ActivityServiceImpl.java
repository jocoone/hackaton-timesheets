package be.axxes.hackaton.timesheets.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.axxes.hackaton.timesheets.dao.ActivityDao;
import be.axxes.hackaton.timesheets.dao.BillableActivityDao;
import be.axxes.hackaton.timesheets.dao.NonBillableActivityDao;
import be.axxes.hackaton.timesheets.model.*;
import be.axxes.hackaton.timesheets.util.DateRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private NonBillableActivityDao nonBillableActivityDao;
    @Autowired
    private BillableActivityDao billableActivityDao;

    @Override
    public Iterable<Activity> getActivities(final User user, final DateRange range) {
        Date from = range.getFromDate();
        Date to = range.getToDate();
        return activityDao.findByDateBetween(from, to);
    }

    @Override
    public Activity create(final Activity activity) {
        return activityDao.save(activity);
    }

    @Override
    public void update(final Activity activity) {
        activityDao.save(activity);
    }

    @Override
    public Iterable<NonBillableActivity> getNonBillableActivities(User user, DateRange range) {
        Date from = range.getFromDate();
        Date to = range.getToDate();
        return nonBillableActivityDao.findByDateBetween(from, to);
    }

    @Override
    public Iterable<BillableActivity> getActivitiesByProject(User user, DateRange range, Project project) {
        Date from = range.getFromDate();
        Date to = range.getToDate();
        return billableActivityDao.findByDateBetweenAndProjectIs(from, to, project);
    }

}
