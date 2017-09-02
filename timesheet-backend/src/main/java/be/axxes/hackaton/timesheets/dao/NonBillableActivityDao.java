package be.axxes.hackaton.timesheets.dao;

import be.axxes.hackaton.timesheets.model.NonBillableActivity;
import be.axxes.hackaton.timesheets.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface NonBillableActivityDao extends CrudRepository<NonBillableActivity, Long> {

    Iterable<NonBillableActivity> findByDateBetween(Date from, Date to);
}
