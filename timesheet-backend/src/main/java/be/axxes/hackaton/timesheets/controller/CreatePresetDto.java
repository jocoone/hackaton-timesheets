package be.axxes.hackaton.timesheets.controller;

import java.util.List;

public class CreatePresetDto {

    private String name;

    private List<CreatePresetActivityDto> activities;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<CreatePresetActivityDto> getActivities() {
        return activities;
    }

    public void setActivities(final List<CreatePresetActivityDto> activities) {
        this.activities = activities;
    }

}
