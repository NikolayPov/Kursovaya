package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "typeofcar")
public class TypeofCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String typename;

    public TypeofCar() {}

    public TypeofCar(String typename) {
        this.typename = typename;
    }

    @OneToMany(mappedBy = "typeofcar",fetch = FetchType.EAGER)
    private Collection<Technicalpassport> tenants;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Collection<Technicalpassport> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Technicalpassport> tenants) {
        this.tenants = tenants;
    }


}
