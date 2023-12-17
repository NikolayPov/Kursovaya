package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String company_name;

    @OneToMany(mappedBy = "manufacturer",fetch = FetchType.EAGER)
    private Collection<Product> tenants;


    public Manufacturer() {}

    public Manufacturer(String company_name) {
        this.company_name = company_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Collection<Product> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Product> tenants) {
        this.tenants = tenants;
    }


}
