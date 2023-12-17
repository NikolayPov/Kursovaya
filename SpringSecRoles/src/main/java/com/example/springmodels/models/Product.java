package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Name is required")
    private int productprice;

    @NotNull(message = "service_price is required")
    private String productname;

    @NotNull(message = "Email is required")
    private int quantity;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Manufacturer manufacturer;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private CarModel carmodel;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private CarBrend carBrand;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Collection<Orders> tenants3;

    public Product() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductprice() {
        return productprice;
    }

    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public CarModel getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(CarModel carmodel) {
        this.carmodel = carmodel;
    }

    public CarBrend getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrend carBrand) {
        this.carBrand = carBrand;
    }

    public Collection<Orders> getTenants3() {
        return tenants3;
    }

    public void setTenants3(Collection<Orders> tenants3) {
        this.tenants3 = tenants3;
    }
}
