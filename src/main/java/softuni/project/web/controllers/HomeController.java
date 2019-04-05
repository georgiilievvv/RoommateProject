package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.UserRegisterBindingModel;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.service.UserServiceModel;
import softuni.project.service.CityService;
import softuni.project.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CityService cityService;

    @Autowired
    public HomeController(ModelMapper modelMapper, UserService userService, CityService cityService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.cityService = cityService;
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(ModelAndView modelAndView, @Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel
            , BindingResult bindingResult) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            bindingResult.addError(new FieldError("userRegisterBindingModel", "password", "Passwords don't match."));
        }

        if (bindingResult.hasErrors()) {
            modelAndView.clear();
            modelAndView.addObject("cityModels", getCityNames());
            modelAndView.addObject("userRegisterBindingModel", userRegisterBindingModel);
            modelAndView.setViewName("index");
            return modelAndView;
        }

        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        if (this.userService.registerUser(userServiceModel) == null) {
            throw new UserRegisterFailureException("Registering user " + userServiceModel.getEmail() + " failed.");
        }

        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, @ModelAttribute UserRegisterBindingModel bindingModel){

        modelAndView.addObject("bindingModel", bindingModel);
        modelAndView.addObject("cityModels", getCityNames());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    private List<String>  getCityNames() {
        return cityService.findAllCities().stream()
                .map(CityServiceModel::getName)
                .collect(Collectors.toList());
    }



}