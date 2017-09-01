package be.axxes.hackaton.timesheets.model;

import static javax.persistence.CascadeType.ALL;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = ALL)
    private Set<Preset> presets;

    private String username;

    public Long getId() {
        return id;
    }

    public User() {}

    public User(final String username) {
        this.username = username;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Set<Preset> getPresets() {
        return presets;
    }

    public void setPresets(final Set<Preset> presets) {
        this.presets = presets;
    }

}
