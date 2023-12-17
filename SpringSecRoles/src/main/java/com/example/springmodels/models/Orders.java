package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date registrationdate;

    private Time ordertime;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Product product;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Car car;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Service service;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private ExecutionStage executionstage;

    public Orders() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Time getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Time ordertime) {
        this.ordertime = ordertime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ExecutionStage getExecutionstage() {
        return executionstage;
    }

    public void setExecutionstage(ExecutionStage executionstage) {
        this.executionstage = executionstage;
    }
}
