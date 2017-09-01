package be.axxes.hackaton.timesheets.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import be.axxes.hackaton.timesheets.dao.ActivityDao;
import be.axxes.hackaton.timesheets.model.Activity;
import be.axxes.hackaton.timesheets.model.User;
import be.axxes.hackaton.timesheets.util.DateRange;

@Service
public class ActivityServiceImpl implements ActivityService  {
	private ActivityDao activityDao;

	@Override
	public Iterable<Activity> getActivities(User user, DateRange range) {
		Date from = range.getFromDate();
		Date to = range.getToDate();
		return activityDao.findByDateBetween(from, to);
	}

}
