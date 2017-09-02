package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.dao.ProjectDao;
import be.axxes.hackaton.timesheets.model.Project;
import be.axxes.hackaton.timesheets.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public Project getById(final long id) {
        return projectDao.findOne(id);
    }

    @Override
    public List<Project> getProjectsByUser(final User user) {
        return projectDao.findProjectByUser(user);
    }

    @Override
    public List<Project> getProjectsByUserAndWeek(final User user, final Date fromDate, final Date toDate) {
        return projectDao.findProjectByUserAndStartDateLessThanEqualAndEndDateGreaterThanEqual(user, toDate, fromDate);
    }

    @Override
    public Project create(Project project) {
        return projectDao.save(project);
    }

    @Override
    public Project getByName(String projectName) {
        return projectDao.findProjectByProjectName(projectName);
    }


}
