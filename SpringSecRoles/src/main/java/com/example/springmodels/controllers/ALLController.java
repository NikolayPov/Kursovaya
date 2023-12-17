package com.example.springmodels.controllers;


import com.example.springmodels.models.*;
import com.example.springmodels.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Time;
import java.text.AttributedString;
import java.util.List;
@Controller
public class ALLController {

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
    public ALLController(ServiceRepository serviceRepository, ManufacturerRepository manufacturerRepository, CarModelRepository carModelRepository, CarBrendRepository carBrendRepository, TypeofCarRepository typeofCarRepository, CarCategoryRepository carcategoryRepository, ExecutionStageRepository executionStageRepository, ProductRepository productRepository, TechnicalpassportRepository technicalpassportRepository, CarRepository carRepository, OrdersRepository ordersRepository) {
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

    @GetMapping()
    public String dan(Model model){
        if(searchstring.equals(""))
        {
            model.addAttribute("products", productRepository.findAll());
        }
        else
        {
            model.addAttribute("products", productRepository.findByProductname(searchstring));

        }
        model.addAttribute("services", serviceRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("carmodels", carModelRepository.findAll());
        model.addAttribute("carbrends", carBrendRepository.findAll());
        model.addAttribute("typeofcars", typeofCarRepository.findAll());
        model.addAttribute("carcategorys", carcategoryRepository.findAll());
        model.addAttribute("executionstages", executionStageRepository.findAll());

        model.addAttribute("technicalpassports", technicalpassportRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("orderss", ordersRepository.findAll());
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchstr") String searchstr) {
        searchstring = searchstr;
        return "redirect:/";
    }

}
