package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "technicalpassport")
public class Technicalpassport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Name is required")
    private int number;

    @NotNull(message = "service_price is required")
    private String yearofrelease;

    @NotNull(message = "Email is required")
    private String registrationmark;


    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private TypeofCar typeofcar;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private CarBrend carbrand;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private CarModel carmodel;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private CarCategory carcategory;

    @OneToMany(mappedBy = "technicalpassport",fetch = FetchType.EAGER)
    private Collection<Car> tenants;

    public Technicalpassport() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getYearofrelease() {
        return yearofrelease;
    }

    public void setYearofrelease(String yearofrelease) {
        this.yearofrelease = yearofrelease;
    }

    public String getRegistrationmark() {
        return registrationmark;
    }

    public void setRegistrationmark(String registrationmark) {
        this.registrationmark = registrationmark;
    }

    public TypeofCar getTypeofcar() {
        return typeofcar;
    }

    public void setTypeofcar(TypeofCar typeofcar) {
        this.typeofcar = typeofcar;
    }

    public CarBrend getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(CarBrend carbrand) {
        this.carbrand = carbrand;
    }

    public CarModel getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(CarModel carmodel) {
        this.carmodel = carmodel;
    }

    public CarCategory getCarcategory() {
        return carcategory;
    }

    public void setCarcategory(CarCategory carcategory) {
        this.carcategory = carcategory;
    }

    public Collection<Car> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Car> tenants) {
        this.tenants = tenants;
    }

}
