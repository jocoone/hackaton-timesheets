package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.model.User;

import java.util.Date;
import java.util.List;

public interface ProjectService {

    Project getById(long id);

    List<Project> getProjectsByUser(User user);

    List<Project> getProjectsByUserAndWeek(User user, Date fromDate, Date toDate);

    Project create(Project project);

    Project getByName(String projectName);
}
