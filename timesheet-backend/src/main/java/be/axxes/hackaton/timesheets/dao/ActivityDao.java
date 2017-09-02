package be.axxes.hackaton.timesheets.dao;

import java.util.Date;

import be.axxes.hackaton.timesheets.model.BillableActivity;
import be.axxes.hackaton.timesheets.model.NonBillableActivity;
import be.axxes.hackaton.timesheets.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.axxes.hackaton.timesheets.model.Activity;

import javax.validation.constraints.Null;

@Repository
public interface ActivityDao extends CrudRepository<Activity, Long> {

	Iterable<Activity> findByDateBetween(Date from, Date to);

}
