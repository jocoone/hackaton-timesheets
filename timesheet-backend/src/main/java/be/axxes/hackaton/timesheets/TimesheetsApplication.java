package be.axxes.hackaton.timesheets;

import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import be.axxes.hackaton.timesheets.dao.ActivityDao;

import be.axxes.hackaton.timesheets.dao.ActivityTypeDao;
import be.axxes.hackaton.timesheets.dao.ProjectDao;
import be.axxes.hackaton.timesheets.dao.UserDao;
import be.axxes.hackaton.timesheets.model.Activity;
import be.axxes.hackaton.timesheets.model.ActivityType;
import be.axxes.hackaton.timesheets.model.BillableActivity;
import be.axxes.hackaton.timesheets.model.NonBillableActivity;
import be.axxes.hackaton.timesheets.model.Preset;
import be.axxes.hackaton.timesheets.model.PresetActivity;
import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.model.User;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TimesheetsApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimesheetsApplication.class);

    public static void main(final String[] args) {
        SpringApplication.run(TimesheetsApplication.class, args);
    }

    @EventListener
    public void insertTestData(final ContextRefreshedEvent event) {
        LOGGER.info("Loading test data");

        ActivityTypeDao activityTypeDao = event.getApplicationContext().getBean(ActivityTypeDao.class);

        activityTypeDao.save(new ActivityType());
        activityTypeDao.save(new ActivityType());

        UserDao userDao = event.getApplicationContext().getBean(UserDao.class);
        ActivityDao activityDao = event.getApplicationContext().getBean(ActivityDao.class);


        ActivityType billable100 = new ActivityType();
        billable100.setBillable(true);
        billable100.setName("Billable 100%");
        activityTypeDao.save(billable100);


        User user = createUser(event, billable100);

        ProjectDao projectDao = event.getApplicationContext().getBean(ProjectDao.class);

        Project project = new Project();
        project.setUser(user);
        project.setProjectName("Project 1");
        project.setStartDate(DateTime.parse("2017-6-10").toDate());
        project.setEndDate(DateTime.parse("2017-9-15").toDate());
        projectDao.save(project);

        project = new Project();
        project.setProjectName("Project 2");
        project.setUser(user);
        project.setStartDate(DateTime.parse("2017-9-2").toDate());
        project.setEndDate(DateTime.parse("2018-2-5").toDate());
        projectDao.save(project);

        BillableActivity billableActivity = new BillableActivity();
        billableActivity.setDate(new Date());
        billableActivity.setDuration(100);
        billableActivity.setUser(user);
        billableActivity.setProject(project);
        ActivityType activityTypeBillable = new ActivityType();
        activityTypeBillable.setBillable(true);
        activityTypeDao.save(activityTypeBillable);
        billableActivity.setType(activityTypeBillable);
        billableActivity.setFactor(100);
        activityDao.save(billableActivity);


        Activity nonBillableActivity = new NonBillableActivity();
        ActivityType activityType = new ActivityType();
        activityType.setBillable(false);
        activityType.setName("Axxes Beach");
        activityType.setDefaultDuration(700);
        activityType.setDescription("Hacking on the beach");
        activityTypeDao.save(activityType);
        nonBillableActivity.setType(activityType);
        nonBillableActivity.setUser(user);
        nonBillableActivity.setDate(new Date());
        nonBillableActivity.setDuration(200);
        activityDao.save(nonBillableActivity);

        LOGGER.info("Done loading test data");
    }

    private User createUser(final ContextRefreshedEvent event, final ActivityType billable100) {
        UserDao userDao = event.getApplicationContext().getBean(UserDao.class);

        User user = new User("samvda");
        Set<Preset> presets = new HashSet<>();
        Preset preset = new Preset();
        preset.setName("standaard");
        Set<PresetActivity> presetActivities = new HashSet<>();

        for (int dayOfweek = Calendar.MONDAY; dayOfweek < Calendar.FRIDAY; dayOfweek++) {
            PresetActivity presetActivity = new PresetActivity();
            presetActivities.add(presetActivity);
            presetActivity.setDayOfWeek(dayOfweek - 1);
            presetActivity.setDuration(60 * 8);
            presetActivity.setActivityType(billable100);
        }

        preset.setActivities(presetActivities);
        presets.add(preset);

        user.setPresets(presets);

        userDao.save(user);
        return user;
    }
}
