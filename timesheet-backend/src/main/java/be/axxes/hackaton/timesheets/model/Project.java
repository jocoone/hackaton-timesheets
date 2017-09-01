package be.axxes.hackaton.timesheets.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String projectName;
    @ManyToOne
    private User user;
    private String description;
    private Date startDate;
    private Date endDate;
    private int maxHours;

    public String getProjectName() { return projectName; }

    public void setProjectName(String projectName) { this.projectName = projectName; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public int getMaxHours() { return maxHours; }

    public void setMaxHours(int maxHours) { this.maxHours = maxHours; }


}
