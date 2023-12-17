package com.example.springmodels.models;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name is required")
    private String sorh;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Technicalpassport technicalpassport;

    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER)
    private Collection<Orders> tenants;

    public Car() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSorh() {
        return sorh;
    }

    public void setSorh(String sorh) {
        this.sorh = sorh;
    }

    public Technicalpassport getTechnicalpassport() {
        return technicalpassport;
    }

    public void setTechnicalpassport(Technicalpassport technicalpassport) {
        this.technicalpassport = technicalpassport;
    }

    public Collection<Orders> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Orders> tenants) {
        this.tenants = tenants;
    }
}
