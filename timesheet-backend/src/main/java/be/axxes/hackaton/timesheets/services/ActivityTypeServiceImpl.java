package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.dao.ActivityTypeDao;
import be.axxes.hackaton.timesheets.model.ActivityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    @Autowired
    private ActivityTypeDao activityTypeDao;

    @Override
    public Iterable<ActivityType> getNonBillableActivities() {
        return activityTypeDao.findAll();
    }

    @Override
    public ActivityType create(final ActivityType activityType) {
        return activityTypeDao.save(activityType);
    }

    @Override
    public void update(final ActivityType activityType) {
        activityTypeDao.save(activityType);
    }

}
