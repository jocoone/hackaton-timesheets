package be.axxes.hackaton.timesheets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private double defaultDuration;
    private boolean dateRange;
    private boolean descriptionRequired;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public double getDefaultDuration() {
        return defaultDuration;
    }

    public void setDefaultDuration(final double defaultDuration) {
        this.defaultDuration = defaultDuration;
    }

    public boolean isDateRange() {
        return dateRange;
    }

    public void setDateRange(final boolean dateRange) {
        this.dateRange = dateRange;
    }

    public boolean isDescriptionRequired() {
        return descriptionRequired;
    }

    public void setDescriptionRequired(final boolean descriptionRequired) {
        this.descriptionRequired = descriptionRequired;
    }

}
