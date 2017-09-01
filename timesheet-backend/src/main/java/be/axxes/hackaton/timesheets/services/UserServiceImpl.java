package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.dao.UserDao;
import be.axxes.hackaton.timesheets.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User getById(long id) {
        return userDao.findOne(id);
    }
}
