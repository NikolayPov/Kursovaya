package com.example.springmodels.models;

import javax.persistence.*;
import java.util.Set;

public class modelAdmin {
    public modelAdmin(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Admin;
    private String adminname;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = roleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "admin_role", joinColumns = @JoinColumn(name = "admin_id"))
    @Enumerated(EnumType.STRING)
    private Set<roleEnum> roles;

    public int getID_Admin() {
        return ID_Admin;
    }

    public void setID_Admin(int ID_Admin) {
        this.ID_Admin = ID_Admin;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
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
}
