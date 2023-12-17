package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "carcategory")
public class CarCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String categoryname;

    @OneToMany(mappedBy = "carcategory",fetch = FetchType.EAGER)
    private Collection<Technicalpassport> tenants;

    public CarCategory() {}

    public CarCategory(String categoryname) {
        this.categoryname = categoryname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Collection<Technicalpassport> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Technicalpassport> tenants) {
        this.tenants = tenants;
    }

}
