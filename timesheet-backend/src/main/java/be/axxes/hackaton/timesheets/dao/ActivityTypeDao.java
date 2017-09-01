package be.axxes.hackaton.timesheets.dao;

import be.axxes.hackaton.timesheets.model.ActivityType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTypeDao extends CrudRepository<ActivityType, Long> {

    // spring data

}
