package com.example.springmodels.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class modelUser {
    public modelUser(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_User;
    private String username;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = roleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<roleEnum> roles;

    public Long getID_User() {
        return ID_User;
    }

    public void setID_User(Long ID_User) {
        this.ID_User = ID_User;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<roleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<roleEnum> roles) {
        this.roles = roles;
    }

    public modelUser(String username, String password, boolean active, Set<roleEnum> roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }
}
