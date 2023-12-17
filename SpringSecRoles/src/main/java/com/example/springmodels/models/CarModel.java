package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "carmodel")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String modelname;

    @OneToMany(mappedBy = "carmodel",fetch = FetchType.EAGER)
    private Collection<Product> tenants;

    @OneToMany(mappedBy = "carmodel",fetch = FetchType.EAGER)
    private Collection<Technicalpassport> tenants2;

    public CarModel() {}

    public CarModel(String modelname) {
        this.modelname = modelname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public Collection<Product> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Product> tenants) {
        this.tenants = tenants;
    }

    public Collection<Technicalpassport> getTenants2() {
        return tenants2;
    }

    public void setTenants2(Collection<Technicalpassport> tenants2) {
        this.tenants2 = tenants2;
    }


}
