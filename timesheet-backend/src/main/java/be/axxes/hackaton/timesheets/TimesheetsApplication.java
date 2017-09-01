package be.axxes.hackaton.timesheets;

import be.axxes.hackaton.timesheets.dao.ActivityTypeDao;
import be.axxes.hackaton.timesheets.dao.ProjectDao;
import be.axxes.hackaton.timesheets.dao.UserDao;
import be.axxes.hackaton.timesheets.model.ActivityType;
import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.model.User;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

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
        activityTypeDao.save(new ActivityType());

        UserDao userDao = event.getApplicationContext().getBean(UserDao.class);

        User user = new User("samvda");
        userDao.save(user);

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


        LOGGER.info("Done loading test data");
    }
}
