package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.model.User;

public interface UserService {

    User getUserByUsername(String username);

    User getById(long id);
}
