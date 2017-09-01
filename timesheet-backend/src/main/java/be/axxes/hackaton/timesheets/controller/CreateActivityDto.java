package be.axxes.hackaton.timesheets.controller;

import java.util.Date;

public class CreateActivityDto {
	private String username;
	private Long projectId;
	private Long activityTypeId;
	private int duration;
	private Date date;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getActivityTypeId() {
		return activityTypeId;
	}
	public void setActivityTypeId(Long activityTypeId) {
		this.activityTypeId = activityTypeId;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	

}
