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
    private boolean billable;
    // @NotNull
    private String name;
    // @NotNull
    private String description;
    // @NotNull
    private int defaultDuration;
    private Integer maxDuration;
    // @NotNull
    private boolean dateRange;
    // @NotNull
    private boolean descriptionRequired;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(final boolean billable) {
        this.billable = billable;
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

    public int getDefaultDuration() {
        return defaultDuration;
    }

    public void setDefaultDuration(final int defaultDuration) {
        this.defaultDuration = defaultDuration;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(final Integer maxDuration) {
        this.maxDuration = maxDuration;
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
