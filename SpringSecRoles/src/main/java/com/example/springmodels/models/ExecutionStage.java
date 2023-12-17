package com.example.springmodels.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "executionstage")
public class ExecutionStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String nameexecutionstage;

    @OneToMany(mappedBy = "executionstage",fetch = FetchType.EAGER)
    private Collection<Orders> tenants;

    public ExecutionStage() {}

    public ExecutionStage(String nameexecutionstage) {
        this.nameexecutionstage = nameexecutionstage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNameexecutionstage() {
        return nameexecutionstage;
    }

    public void setNameexecutionstage(String nameexecutionstage) {
        this.nameexecutionstage = nameexecutionstage;
    }

    public Collection<Orders> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Orders> tenants) {
        this.tenants = tenants;
    }
}
