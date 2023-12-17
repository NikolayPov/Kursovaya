package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String name_service;

    @NotNull(message = "service_price is required")
    private int service_price;

    @NotBlank(message = "Email is required")
    private String description_service;

    @OneToMany(mappedBy = "service",fetch = FetchType.EAGER)
    private Collection<Orders> tenants;

    public Service() {}

    public Service(String name_service,int service_price, String description_service) {
        this.name_service = name_service;
        this.service_price = service_price;
        this.description_service = description_service;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public void setService_price(int service_price) {
        this.service_price = service_price;
    }

    public String getName_service() {
        return name_service;
    }

    public int getService_price() {
        return service_price;
    }
    public String getDescription_service() {
        return description_service;
    }

    public void setDescription_service(String description_service) {
        this.description_service = description_service;
    }

    public Collection<Orders> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Orders> tenants) {
        this.tenants = tenants;
    }

    public void setName(String testService) {
    }

    public void setDescription(String thisIsATestService) {
    }

    public void setPrice(double v) {
    }
}
