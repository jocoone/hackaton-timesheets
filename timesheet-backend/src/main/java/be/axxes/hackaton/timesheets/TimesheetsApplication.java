package be.axxes.hackaton.timesheets;

import be.axxes.hackaton.timesheets.dao.ActivityTypeDao;
import be.axxes.hackaton.timesheets.model.ActivityType;
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

        LOGGER.info("Done loading test data");
    }
}
