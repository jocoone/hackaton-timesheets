package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.model.User;

import java.util.Date;
import java.util.List;

public interface ProjectService {

    List<Project> getProjectsByUser(User user);

    List<Project> getProjectsByUserAndWeek(User user, Date fromDate, Date toDate);
}
