package be.axxes.hackaton.timesheets.model;

import static javax.persistence.CascadeType.ALL;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Preset {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(cascade = ALL)
    private Set<PresetActivity> activities;

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

    public Set<PresetActivity> getActivities() {
        return activities;
    }

    public void setActivities(final Set<PresetActivity> activities) {
        this.activities = activities;
    }

}
