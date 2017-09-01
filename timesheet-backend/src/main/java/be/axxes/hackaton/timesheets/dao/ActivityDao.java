package be.axxes.hackaton.timesheets.dao;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.axxes.hackaton.timesheets.model.Activity;

@Repository
public interface ActivityDao extends CrudRepository<Activity, Long> {

	public Iterable<Activity> findByDateBetween(Date from, Date to);

}
