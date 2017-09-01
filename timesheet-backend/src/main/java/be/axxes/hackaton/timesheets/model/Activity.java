package be.axxes.hackaton.timesheets.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public abstract class Activity {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private ActivityType type;
	private int duration;
	private Date date;
	
	@ManyToOne
	private Project project;
	
	@ManyToOne
	private User user;
	
	public ActivityType getType() {
		return type;
	}
	public int getDuration() {
		return duration;
	}
	public Date getDate() {
		return date;
	}
	public Project getProject() {
		return project;
	}
	public User getUser(){
		return user;
	}
	public void setType(ActivityType type) {
		this.type = type;
	}
	public void setDuration(int duration) {
		this.duration = duration==0? this.getType().getDefaultDuration(): duration;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public void setUser(User user){
		this.user = user;
	}	
}
