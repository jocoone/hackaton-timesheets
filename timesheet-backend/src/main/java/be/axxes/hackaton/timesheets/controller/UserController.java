package be.axxes.hackaton.timesheets.controller;

import be.axxes.hackaton.timesheets.model.Preset;
import be.axxes.hackaton.timesheets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{username}/presets")
    public Collection<Preset> getPresets(@PathVariable("username") final String username) {
        return userService.getUserByUsername(username).getPresets();
    }

}
