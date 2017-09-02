package be.axxes.hackaton.timesheets.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import be.axxes.hackaton.timesheets.model.Preset;
import be.axxes.hackaton.timesheets.model.PresetActivity;
import be.axxes.hackaton.timesheets.services.ActivityTypeService;
import be.axxes.hackaton.timesheets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityTypeService activityTypeService;

    @RequestMapping("/{username}/presets")
    public Collection<Preset> getPresets(@PathVariable("username") final String username) {
        return userService.getUserByUsername(username).getPresets();
    }

    @RequestMapping(path = "/{username}/presets", method = POST)
    public void savePresets(@PathVariable("username") final String username, @RequestBody final CreatePresetDto createPresetDto) {
        Preset preset = new Preset();
        preset.setName(createPresetDto.getName());

        preset.setActivities(new HashSet<PresetActivity>());
        for (CreatePresetActivityDto createPresetActivityDto : createPresetDto.getActivities()) {
            PresetActivity presetActivity = new PresetActivity();

            presetActivity.setActivityType(activityTypeService.getById(createPresetActivityDto.getActivityTypeId()));
            presetActivity.setDayOfWeek(createPresetActivityDto.getDayOfWeek());
            presetActivity.setDuration(createPresetActivityDto.getDuration());
            presetActivity.setDescription(createPresetActivityDto.getDescription());

            preset.getActivities().add(presetActivity);
        }

        userService.savePreset(username, preset);
    }

}
