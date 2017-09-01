package be.axxes.hackaton.timesheets.controller;

import java.util.Date;

public class CreateProjectDto {

    private String projectName;
    private Long userId;
    private String description;
    private Date startDate;
    private Date endDate;
    private int maxHours;

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public int getMaxHours() { return maxHours; }
    public void setMaxHours(int maxHours) { this.maxHours = maxHours; }
}
