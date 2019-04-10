package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.UserRegisterBindingModel;
import softuni.project.domain.models.service.UserServiceModel;
import softuni.project.service.CityService;
import softuni.project.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CityService cityService;

    public UserController(ModelMapper modelMapper, UserService userService, CityService cityService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.cityService = cityService;
    }

    @GetMapping("/edit-profile")
    public ModelAndView editProfile(ModelAndView modelAndView, Principal principal){

        modelAndView.addObject("user", this.userService.findUserByUserName(principal.getName()));
        modelAndView.addObject("view", "/fragments/user/edit-profile");
        modelAndView.setViewName("home");
        return modelAndView;
    }


    @PostMapping("/edit-profile")
    public ModelAndView editProfile(ModelAndView modelAndView, @Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel
            , BindingResult bindingResult, Principal principal) {

        if (userRegisterBindingModel.getPassword().matches("\\s+")) {
            System.out.println( );
        }

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("userRegisterBindingModel", userRegisterBindingModel);
            modelAndView.setViewName("index");
            return modelAndView;
        }

        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        this.userService.registerUser(userServiceModel);

        modelAndView.setViewName("redirect:/test");

        return modelAndView;
    }
}
