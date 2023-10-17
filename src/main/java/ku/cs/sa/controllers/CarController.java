package ku.cs.sa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ku.cs.sa.models.CarRequest;
import ku.cs.sa.services.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public String getAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car/car-all";
    }

    @GetMapping("/add")
    public String getCarForm(Model model) {
        return "car/car-add";
    }

    @PostMapping("/add")
    public String createCar(@ModelAttribute CarRequest car, Model model) {
        carService.createCar(car);
        return "redirect:/cars";
    }
}
