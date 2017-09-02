package be.axxes.hackaton.timesheets.dao;

import be.axxes.hackaton.timesheets.model.BillableActivity;
import be.axxes.hackaton.timesheets.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface BillableActivityDao extends CrudRepository<BillableActivity, Long> {

    Iterable<BillableActivity> findByDateBetweenAndProjectIs(Date from, Date to, Project project);
}
