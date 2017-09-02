package be.axxes.hackaton.timesheets.services;

import be.axxes.hackaton.timesheets.dao.UserDao;
import be.axxes.hackaton.timesheets.model.Preset;
import be.axxes.hackaton.timesheets.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(final String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User getById(final long id) {
        return userDao.findOne(id);
    }

    @Override
    public void savePreset(final String username, final Preset preset) {
        User user = getUserByUsername(username);

        if (user.getPresets() == null) {
            user.setPresets(new HashSet<Preset>());
        }

        user.getPresets().add(preset);

        userDao.save(user);
    }
}
