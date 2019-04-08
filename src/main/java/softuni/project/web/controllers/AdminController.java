package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.project.service.CityService;
import softuni.project.service.UserService;

@Controller
public class AdminController{

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CityService cityService;

    public AdminController(ModelMapper modelMapper, UserService userService, CityService cityService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.cityService = cityService;
    }
}
