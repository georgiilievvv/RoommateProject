package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.UserRegisterBindingModel;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.service.UserServiceModel;
import softuni.project.service.AccommodationService;
import softuni.project.service.CityService;
import softuni.project.service.UserService;
import softuni.project.validation.user.UserRegisterValidator;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final ModelMapper modelMapper;
    private final UserRegisterValidator userRegisterValidator;
    private final AccommodationService accommodationService;
    private final UserService userService;
    private final CityService cityService;

    @Autowired
    public HomeController(ModelMapper modelMapper, UserRegisterValidator userRegisterValidator, AccommodationService accommodationService, UserService userService, CityService cityService) {
        this.modelMapper = modelMapper;
        this.userRegisterValidator = userRegisterValidator;
        this.accommodationService = accommodationService;
        this.userService = userService;
        this.cityService = cityService;
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(ModelAndView modelAndView, @Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel
            , BindingResult bindingResult) {

        this.userRegisterValidator.validate(userRegisterBindingModel, bindingResult);

        if (bindingResult.hasErrors()) {
            modelAndView.clear();
            modelAndView.addObject("cityModels", getCities());
            modelAndView.addObject("userRegisterBindingModel", userRegisterBindingModel);
            modelAndView.setViewName("index");
            return modelAndView;
        }

        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        this.userService.registerUser(userServiceModel);

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    public ModelAndView index(ModelAndView modelAndView, @ModelAttribute UserRegisterBindingModel bindingModel){

        modelAndView.addObject("cityModels", getCities());
        modelAndView.addObject("bindingModel", bindingModel);
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView home(ModelAndView modelAndView, Principal principal){

        modelAndView.addObject("user", this.userService.findUserByUsername(principal.getName()));
        modelAndView.addObject("accommodationModels", this.accommodationService.findAllAccommodations());
        modelAndView.addObject("view", "fragments/product");

        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping("/about-us")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView aboutUs(ModelAndView modelAndView, Principal principal) {

        modelAndView.addObject("user", this.userService.findUserByUsername(principal.getName()));
        modelAndView.addObject("view", "about-us");

        modelAndView.setViewName("home");

        return modelAndView;
    }

        private List<CityServiceModel> getCities() {
        return cityService.findAllCities().stream()
                .map(c -> modelMapper.map(c, CityServiceModel.class))
                .collect(Collectors.toList());
    }


}