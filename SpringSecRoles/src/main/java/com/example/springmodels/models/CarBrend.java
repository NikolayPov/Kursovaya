package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "carbrand")
public class CarBrend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String brandname;

    @OneToMany(mappedBy = "carBrand",fetch = FetchType.EAGER)
    private Collection <Product> tenants;

    @OneToMany(mappedBy = "carbrand",fetch = FetchType.EAGER)
    private Collection <Technicalpassport> tenants2;

    public CarBrend() {}

    public CarBrend(String brandname) {
        this.brandname = brandname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
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
