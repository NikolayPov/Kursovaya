package com.example.springmodels.controllers;

import com.example.springmodels.models.*;
import com.example.springmodels.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

@PreAuthorize("hasAnyAuthority('USER,DERECT')")
public class userController {

    private final ServiceRepository serviceRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final CarModelRepository carModelRepository;
    private final CarBrendRepository carBrendRepository;
    private final TypeofCarRepository typeofCarRepository;
    private final CarCategoryRepository carcategoryRepository;
    private final ExecutionStageRepository executionStageRepository;
    private final ProductRepository productRepository;
    private final TechnicalpassportRepository technicalpassportRepository;
    private final CarRepository carRepository;
    private final OrdersRepository ordersRepository;
    private String searchstring = "";
    @Autowired
    public userController(ServiceRepository serviceRepository, ManufacturerRepository manufacturerRepository, CarModelRepository carModelRepository, CarBrendRepository carBrendRepository, TypeofCarRepository typeofCarRepository, CarCategoryRepository carcategoryRepository, ExecutionStageRepository executionStageRepository, ProductRepository productRepository, TechnicalpassportRepository technicalpassportRepository, CarRepository carRepository, OrdersRepository ordersRepository) {
        this.serviceRepository = serviceRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.carModelRepository = carModelRepository;
        this.carBrendRepository = carBrendRepository;
        this.typeofCarRepository = typeofCarRepository;
        this.carcategoryRepository = carcategoryRepository;
        this.executionStageRepository = executionStageRepository;
        this.productRepository = productRepository;
        this.technicalpassportRepository = technicalpassportRepository;
        this.carRepository = carRepository;
        this.ordersRepository = ordersRepository;

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/neworders")
    public String showSignUpFormorders(Model model) {
        model.addAttribute("executionstages", executionStageRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("orders",new Orders());
        return "add-orders";
    }





    @PostMapping("/addorders")
    public String addorders(@Valid Orders orders, @ModelAttribute("executionstage_id") int executionstage_id, @ModelAttribute("product_id") int product_id, @ModelAttribute("service_id") int service_id, @ModelAttribute("car_id") int car_id, BindingResult result, Model model) {
        ExecutionStage executionStage = executionStageRepository.findById(executionstage_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" ));
        Product product = productRepository.findById(product_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" ));
        Service service = serviceRepository.findById(service_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" ));
        Car car = carRepository.findById(car_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" ));
        orders.setExecutionstage(executionStage);
        orders.setProduct(product);
        orders.setService(service);
        orders.setCar(car);
        ordersRepository.save(orders);
        model.addAttribute("orders", ordersRepository.findAll());
        return "redirect:/";
    }

}
