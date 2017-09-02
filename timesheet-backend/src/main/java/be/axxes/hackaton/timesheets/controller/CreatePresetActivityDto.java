package be.axxes.hackaton.timesheets.controller;

public class CreatePresetActivityDto {

    private int dayOfWeek;
    private long activityTypeId;
    private int duration;
    private String description;

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(final int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(final long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
