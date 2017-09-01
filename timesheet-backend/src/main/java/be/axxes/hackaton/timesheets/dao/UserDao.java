package be.axxes.hackaton.timesheets.dao;

import be.axxes.hackaton.timesheets.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

    User findUserByUsername(String username);
}
