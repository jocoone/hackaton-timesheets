package be.axxes.hackaton.timesheets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue
    private Long id;

    // @NotNull
    private Boolean billable;
    // @NotNull
    private String name;
    // @NotNull
    private String description;

    // @NotNull
    private Integer defaultDuration;
    private Integer maxDuration;
    // @NotNull
    private Boolean dateRange;
 // @NotNull
    private Boolean descriptionRequired;
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getBillable() {
		return billable;
	}
	public void setBillable(Boolean billable) {
		this.billable = billable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDefaultDuration() {
		return defaultDuration;
	}
	public void setDefaultDuration(Integer defaultDuration) {
		this.defaultDuration = defaultDuration;
	}
	public Integer getMaxDuration() {
		return maxDuration;
	}
	public void setMaxDuration(Integer maxDuration) {
		this.maxDuration = maxDuration;
	}
	public Boolean getDateRange() {
		return dateRange;
	}
	public void setDateRange(Boolean dateRange) {
		this.dateRange = dateRange;
	}
	public Boolean getDescriptionRequired() {
		return descriptionRequired;
	}
	public void setDescriptionRequired(Boolean descriptionRequired) {
		this.descriptionRequired = descriptionRequired;
	}
	
    

}
