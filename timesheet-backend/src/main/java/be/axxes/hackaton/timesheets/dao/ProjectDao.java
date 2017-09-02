package be.axxes.hackaton.timesheets.dao;

import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ProjectDao extends CrudRepository<Project, Long>{

    List<Project> findProjectByUser(User user);

    List<Project> findProjectByUserAndStartDateLessThanEqualAndEndDateGreaterThanEqual(User user, Date dateEndWeek, Date dateStartWeek);

    Project findProjectByProjectName(String projectName);
}
