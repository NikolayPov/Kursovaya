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
@PreAuthorize("hasAnyAuthority('DERECT')")
public class DerektirController {
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
    public DerektirController(ServiceRepository serviceRepository, ManufacturerRepository manufacturerRepository, CarModelRepository carModelRepository, CarBrendRepository carBrendRepository, TypeofCarRepository typeofCarRepository, CarCategoryRepository carcategoryRepository, ExecutionStageRepository executionStageRepository, ProductRepository productRepository, TechnicalpassportRepository technicalpassportRepository, CarRepository carRepository, OrdersRepository ordersRepository) {
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
    @GetMapping("/new")
    public String showSignUpForm(Service service) {
        return "add-service";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateService(@PathVariable("id") int id, Model model) {
        Service service = serviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid service Id:" + id));
        model.addAttribute("service", service);
        return "update-service";
    }
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") int id, Model model) {
        Service service = serviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid service Id:" + id));
        serviceRepository.delete(service);
        model.addAttribute("service", serviceRepository.findAll());
        return "redirect:/";

    }

    @PostMapping("/addservice")
    public String addService(@Valid Service service, BindingResult result, Model model) {
        try {
            serviceRepository.save(service);
            model.addAttribute("service", serviceRepository.findAll());
            return "redirect:/";
        } catch (Exception e) {
            // Обработка ошибки
            e.printStackTrace();
            model.addAttribute("errorMessage", "Ошибка добавления услуги");
            return "error-page";
        }
    }
    @PostMapping("/update/{id}")
    public String updateService(@PathVariable("id") int id, @Valid Service service, BindingResult result, Model model) {
        if (result.hasErrors()) {
            service.setId(id);
            return "update-service";
        }
        serviceRepository.save(service);
        model.addAttribute("service", serviceRepository.findAll());
        return "redirect:/";
    }
    //////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/newmanufacturer")
    public String showSignUpForm2(Manufacturer manufacturer) {
        return "add-manufacturer";
    }
    @GetMapping("/editmanufacturer/{id}")
    public String showUpdateManufacturer(@PathVariable("id") int id, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        model.addAttribute("manufacturer", manufacturer);
        return "update-manufacturer";
    }
    @GetMapping("/deletemanufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") int id, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        manufacturerRepository.delete(manufacturer);
        model.addAttribute("manufacturer", manufacturerRepository.findAll());
        return "redirect:/";
    }
    //Метод добавления записи в таблицу производитель
    @PostMapping("/addmanufacturer")
    public String addManufacturer(@Valid Manufacturer manufacturer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-manufacturer";
        }
        manufacturerRepository.save(manufacturer);
        model.addAttribute("manufacturer", manufacturerRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/updatemanufacturer/{id}")
    public String updateManufacturer(@PathVariable("id") int id, @Valid Manufacturer manufacturer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            manufacturer.setId(id);
            return "update-manufacturer";
        }
        manufacturerRepository.save(manufacturer);
        model.addAttribute("manufacturer", manufacturerRepository.findAll());
        return "redirect:/";
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/newcarmodel")
    public String showSignUpFormcarmodel(Model model) {
        model.addAttribute("carmodel",new CarModel());
        return "add-carmodel";
    }
    @GetMapping("/editcarmodel/{id}")
    public String showUpdatecarmodel(@PathVariable("id") int id, Model model) {
        CarModel carmodel = carModelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid carmodel Id:" + id));
        model.addAttribute("carmodel", carmodel);
        return "update-carmodel";
    }
    @GetMapping("/deletecarmodel/{id}")
    public String deleteCarModel(@PathVariable("id") int id, Model model) {
        CarModel carmodel = carModelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid carmodel Id:" + id));
        carModelRepository.delete(carmodel);
        model.addAttribute("carmodel", carModelRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/addcarmodel")
    public String addCarModel(@Valid CarModel carmodel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-carmodel";
        }
        carModelRepository.save(carmodel);
        model.addAttribute("carmodel", carModelRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/updatecarmodel/{id}")
    public String updateCarModel(@PathVariable("id") int id, @Valid CarModel carmodel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            carmodel.setId(id);
            return "update-carmodel";
        }
        carModelRepository.save(carmodel);
        model.addAttribute("carmodel", carModelRepository.findAll());
        return "redirect:/";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/newcarbrend")
    public String showSignUpFormcarbred(Model model) {
        model.addAttribute("carbrend",new CarBrend());
        return "add-carbrend";
    }
    @GetMapping("/editcarbrend/{id}")
    public String showUpdatecarbred(@PathVariable("id") int id, Model model) {
        CarBrend carbrend = carBrendRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        model.addAttribute("carbrend", carbrend);
        return "update-carbrend";
    }
    @GetMapping("/deletecarbrend/{id}")
    public String deletecarbrend(@PathVariable("id") int id, Model model) {
        CarBrend carbrend = carBrendRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        carBrendRepository.delete(carbrend);
        model.addAttribute("carbrend", carBrendRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/addcarbrend")
    public String addcarbrend(@Valid CarBrend carbrend, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-carbrend";
        }
        carBrendRepository.save(carbrend);
        model.addAttribute("carbrend", carBrendRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/updatecarbrend/{id}")
    public String updatecarbrend(@PathVariable("id") int id, @Valid CarBrend carbrend, BindingResult result, Model model) {
        if (result.hasErrors()) {
            carbrend.setId(id);
            return "update-carbrend";
        }
        carBrendRepository.save(carbrend);
        model.addAttribute("carbrend", carModelRepository.findAll());
        return "redirect:/";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/newtypeofcar")
    public String showSignUpFormtypeofcar(Model model) {
        model.addAttribute("typeofcar",new TypeofCar());
        return "add-typeofcar";
    }
    @GetMapping("/edittypeofcar/{id}")
    public String showUpdatetypeofcar(@PathVariable("id") int id, Model model) {
        TypeofCar typeofcar = typeofCarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid typeofcar Id:" + id));
        model.addAttribute("typeofcar", typeofcar);
        return "update-typeofcar";
    }

    @GetMapping("/deletetypeofcar/{id}")
    public String deletetypeofcar(@PathVariable("id") int id, Model model) {
        TypeofCar typeofcar = typeofCarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid typeofcar Id:" + id));
        typeofCarRepository.delete(typeofcar);
        model.addAttribute("typeofcar", carBrendRepository.findAll());
        return "redirect:/";
    }


    @PostMapping("/addtypeofcar")
    public String addtypeofcar(@Valid TypeofCar typeofcar, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-typeofcar";
        }
        typeofCarRepository.save(typeofcar);
        model.addAttribute("typeofcar", typeofCarRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/updatetypeofcar/{id}")
    public String updatetypeofcar(@PathVariable("id") int id, @Valid TypeofCar typeofcar, BindingResult result, Model model) {
        if (result.hasErrors()) {
            typeofcar.setId(id);
            return "update-typeofcar";
        }
        typeofCarRepository.save(typeofcar);
        model.addAttribute("typeofcar", typeofCarRepository.findAll());
        return "redirect:/";
    }
    ///////////////////////////////////////////////////////////////////
    @GetMapping("/newcarcategory")
    public String showSignUpFormcarcategory(Model model) {
        model.addAttribute("carcategory",new CarCategory());
        return "add-carcategory";
    }


    @GetMapping("/editcarcategory/{id}")
    public String showUpdatecarcategory(@PathVariable("id") int id, Model model) {
        CarCategory carcategory = carcategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid carcategory Id:" + id));
        model.addAttribute("carcategory", carcategory);
        return "update-carcategory";
    }

    @GetMapping("/deletecarcategory/{id}")
    public String deletecarcategory(@PathVariable("id") int id, Model model) {
        CarCategory carcategory = carcategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid carcategory Id:" + id));
        carcategoryRepository.delete(carcategory);
        model.addAttribute("carcategory", carcategoryRepository.findAll());
        return "redirect:/";
    }


    @PostMapping("/addcarcategory")
    public String addcarcategory(@Valid CarCategory carcategory, BindingResult result, Model model) {
        carcategoryRepository.save(carcategory);
        model.addAttribute("carcategory", carcategoryRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/updatecarcategory/{id}")
    public String updatecarcategory(@PathVariable("id") int id, @Valid CarCategory carcategory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            carcategory.setId(id);
            return "update-carcategory";
        }
        carcategoryRepository.save(carcategory);
        model.addAttribute("carcategory", carcategoryRepository.findAll());
        return "redirect:/";
    }
    ///////////////////////////////////////////////////////////////////
    @GetMapping("/newexecutionstage")
    public String showSignUpFormexecutionstage(Model model) {
        model.addAttribute("executionstage",new ExecutionStage());
        return "add-executionstage";
    }


    @GetMapping("/editexecutionstage/{id}")
    public String showUpdateexecutionstage(@PathVariable("id") int id, Model model) {
        ExecutionStage executionstage = executionStageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid executionstage Id:" + id));
        model.addAttribute("executionstage", executionstage);
        return "update-executionstage";
    }

    @GetMapping("/deleteexecutionstage/{id}")
    public String deleteexecutionstage(@PathVariable("id") int id, Model model) {
        ExecutionStage executionstage = executionStageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid executionstage Id:" + id));
        executionStageRepository.delete(executionstage);
        model.addAttribute("executionstage", executionStageRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/addexecutionstage")
    public String addexecutionstage(@Valid ExecutionStage executionstage, BindingResult result, Model model) {
        executionStageRepository.save(executionstage);
        model.addAttribute("executionstage", executionStageRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/updateexecutionstage/{id}")
    public String updateexecutionstage(@PathVariable("id") int id, @Valid ExecutionStage executionstage, BindingResult result, Model model) {
        if (result.hasErrors()) {
            executionstage.setId(id);
            return "update-executionstage";
        }
        executionStageRepository.save(executionstage);
        model.addAttribute("executionstage", executionStageRepository.findAll());
        return "redirect:/";
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/newproduct")
    public String showSignUpFormproduct(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("carmodels", carModelRepository.findAll());
        model.addAttribute("carbrends", carBrendRepository.findAll());
        model.addAttribute("product",new Product());
        return "add-product";
    }
    @GetMapping("/editproduct/{id}")
    public String showUpdateproduct(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("carmodels", carModelRepository.findAll());
        model.addAttribute("carbrends", carBrendRepository.findAll());
        model.addAttribute("product", product);
        return "update-product";
    }
    @GetMapping("/deleteproduct/{id}")
    public String deleteproduct(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        productRepository.delete(product);
        model.addAttribute("product", productRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/addproduct")
    public String addproduct(@Valid Product product, @ModelAttribute("manufacturer_id") int manufacturer_id, @ModelAttribute("carmodel_id") int carmodel_id, @ModelAttribute("car_brand_id") int car_brand_id, BindingResult result, Model model) {
        CarBrend carbrend = carBrendRepository.findById(car_brand_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" ));
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturer_id).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" ));
        CarModel carmodel = carModelRepository.findById(carmodel_id).orElseThrow(() -> new IllegalArgumentException("Invalid carmodel Id:" ));
        product.setCarmodel(carmodel);
        product.setManufacturer(manufacturer);
        product.setCarBrand(carbrend);
        productRepository.save(product);
        model.addAttribute("product", productRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/updateproduct/{id}")
    public String updateproduct(@PathVariable("id") int id, @ModelAttribute("manufacturer_id") int manufacturer_id, @ModelAttribute("carmodel_id") int carmodel_id, @ModelAttribute("car_brand_id") int car_brand_id, @Valid Product product, BindingResult result, Model model) {
        CarBrend carbrend = carBrendRepository.findById(car_brand_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturer_id).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        CarModel carmodel = carModelRepository.findById(carmodel_id).orElseThrow(() -> new IllegalArgumentException("Invalid carmodel Id:" + id));
        product.setCarmodel(carmodel);
        product.setManufacturer(manufacturer);
        product.setCarBrand(carbrend);
        productRepository.save(product);
        model.addAttribute("product", productRepository.findAll());
        return "redirect:/";
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/newtechnicalpassport")
    public String showSignUpFormtechnicalpassport(Model model) {
        model.addAttribute("typeofcars", typeofCarRepository.findAll());
        model.addAttribute("carcategorys", carcategoryRepository.findAll());
        model.addAttribute("carmodels", carModelRepository.findAll());
        model.addAttribute("carbrends", carBrendRepository.findAll());
        model.addAttribute("technicalpassport",new Technicalpassport());
        return "add-technicalpassport";
    }


    @GetMapping("/edittechnicalpassport/{id}")
    public String showUpdatetechnicalpassport(@PathVariable("id") int id, Model model) {
        Technicalpassport technicalpassport = technicalpassportRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid technicalpassport Id:" + id));
        model.addAttribute("typeofcars", typeofCarRepository.findAll());
        model.addAttribute("carcategorys", carcategoryRepository.findAll());
        model.addAttribute("carmodels", carModelRepository.findAll());
        model.addAttribute("carbrends", carBrendRepository.findAll());
        model.addAttribute("technicalpassport", technicalpassport);
        return "update-technicalpassport";
    }

    @GetMapping("/deletetechnicalpassport/{id}")
    public String deletetechnicalpassport(@PathVariable("id") int id, Model model) {
        Technicalpassport technicalpassport = technicalpassportRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        technicalpassportRepository.delete(technicalpassport);
        model.addAttribute("technicalpassport", technicalpassportRepository.findAll());
        return "redirect:/";
    }


    @PostMapping("/addtechnicalpassport")
    public String addtechnicalpassport(@Valid Technicalpassport technicalpassport,
                                       @ModelAttribute("typeofcar_id") int typeofcar_id,
                                       @ModelAttribute("carmodel_id") int carmodel_id,
                                       @ModelAttribute("carbrend_id") int carbrend_id,
                                       @ModelAttribute("carcategory_id") int carcategory_id,
                                       BindingResult result, Model model) {
        CarBrend carbrend = carBrendRepository.findById(carbrend_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" ));
        CarModel carmodel = carModelRepository.findById(carmodel_id).orElseThrow(() -> new IllegalArgumentException("Invalid carmodel Id:" ));
        CarCategory carcategory = carcategoryRepository.findById(carcategory_id).orElseThrow(() -> new IllegalArgumentException("Invalid carcategory Id:" ));
        TypeofCar typeofcar = typeofCarRepository.findById(typeofcar_id).orElseThrow(() -> new IllegalArgumentException("Invalid typeofcar Id:" ));
        technicalpassport.setCarcategory(carcategory);
        technicalpassport.setTypeofcar(typeofcar);
        technicalpassport.setCarmodel(carmodel);
        technicalpassport.setCarbrand(carbrend);
        technicalpassportRepository.save(technicalpassport);
        model.addAttribute("technicalpassport", technicalpassportRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/updatetechnicalpassport/{id}")
    public String updatetechnicalpassport(@PathVariable("id") int id, @ModelAttribute("carcategory_id") int carcategory_id, @ModelAttribute("typeofcar_id") int typeofcar_id, @ModelAttribute("carmodel_id") int carmodel_id, @ModelAttribute("carbrend_id") int carbrend_id, @Valid Technicalpassport technicalpassport, BindingResult result, Model model) {
        CarBrend carbrend = carBrendRepository.findById(carbrend_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        CarModel carmodel = carModelRepository.findById(carmodel_id).orElseThrow(() -> new IllegalArgumentException("Invalid carmodel Id:" + id));
        CarCategory carcategory = carcategoryRepository.findById(carcategory_id).orElseThrow(() -> new IllegalArgumentException("Invalid carcategory Id:" + id));
        TypeofCar typeofcar = typeofCarRepository.findById(typeofcar_id).orElseThrow(() -> new IllegalArgumentException("Invalid typeofcar Id:" + id));
        technicalpassport.setCarcategory(carcategory);
        technicalpassport.setTypeofcar(typeofcar);
        technicalpassport.setCarmodel(carmodel);
        technicalpassport.setCarbrand(carbrend);
        technicalpassportRepository.save(technicalpassport);
        model.addAttribute("technicalpassport", technicalpassportRepository.findAll());
        return "redirect:/";
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/newcar")
    public String showSignUpFormcar(Model model) {
        model.addAttribute("technicalpassports", technicalpassportRepository.findAll());
        model.addAttribute("car",new Car());
        return "add-car";
    }


    @GetMapping("/editcar/{id}")
    public String showUpdatecar(@PathVariable("id") int id, Model model) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        model.addAttribute("technicalpassports", technicalpassportRepository.findAll());
        model.addAttribute("car", car);
        return "update-car";
    }

    @GetMapping("/deletecar/{id}")
    public String deletecar(@PathVariable("id") int id, Model model) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        carRepository.delete(car);
        model.addAttribute("car", carRepository.findAll());
        return "redirect:/";
    }


    @PostMapping("/addcar")
    public String addcar(@Valid Car car, @ModelAttribute("technicalpassport_id") int technicalpassport_id, BindingResult result, Model model) {
        Technicalpassport technicalpassport = technicalpassportRepository.findById(technicalpassport_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" ));
        car.setTechnicalpassport(technicalpassport);
        carRepository.save(car);
        model.addAttribute("car", carRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/updatecar/{id}")
    public String updatecar(@PathVariable("id") int id, @ModelAttribute("technicalpassport_id") int technicalpassport_id, @Valid Car car, BindingResult result, Model model) {
        Technicalpassport technicalpassport = technicalpassportRepository.findById(technicalpassport_id).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        car.setTechnicalpassport(technicalpassport);
        carRepository.save(car);
        model.addAttribute("car", carRepository.findAll());
        return "redirect:/";
    }
/////////////////////////////////////////
@GetMapping("/editorders/{id}")
public String showUpdateorders(@PathVariable("id") int id, Model model) {
    Orders orders = ordersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
    model.addAttribute("executionstages", executionStageRepository.findAll());
    model.addAttribute("products", productRepository.findAll());
    model.addAttribute("services", serviceRepository.findAll());
    model.addAttribute("cars", carRepository.findAll());
    model.addAttribute("orders", orders);
    return "update-orders";
}

    @GetMapping("/deleteorders/{id}")
    public String deleteorders(@PathVariable("id") int id, Model model) {
        Orders orders = ordersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        ordersRepository.delete(orders);
        model.addAttribute("orders", ordersRepository.findAll());
        return "redirect:/";
    }
    @PostMapping("/updateorders/{id}")
    public String updateorders(@PathVariable("id") int id, @ModelAttribute("executionstage_id") int executionstage_id, @ModelAttribute("time") String time, @ModelAttribute("product_id") int product_id, @ModelAttribute("service_id") int service_id, @ModelAttribute("car_id") int car_id, @Valid Orders orders, BindingResult result, Model model) {
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
