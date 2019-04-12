package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.UserEditBindingModel;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.service.UserServiceModel;
import softuni.project.service.CityService;
import softuni.project.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("isAuthenticated()")
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
    public ModelAndView editProfile(ModelAndView modelAndView, Principal principal) {

        UserEditBindingModel editModel = this.modelMapper.map(this.userService.findUserByUsername(principal.getName()), UserEditBindingModel.class);

        modelAndView.addObject("editUserModel", editModel);
        modelAndView.addObject("cityModels", getCities());
        modelAndView.addObject("view", "/fragments/user/edit-profile");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PostMapping("/edit-profile")
    public ModelAndView editProfile(ModelAndView modelAndView, @Valid @ModelAttribute("editModel") UserEditBindingModel userEditBindingModel
            , BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("cityModels", getCities());
            modelAndView.addObject("editUserModel", userEditBindingModel);
            modelAndView.setViewName("fragments/user/edit-profile");
            return modelAndView;
        }

        UserServiceModel userServiceModel = this.modelMapper.map(userEditBindingModel, UserServiceModel.class);
        userServiceModel.setPassword(userEditBindingModel.getNewPassword());

        this.userService.registerUser(userServiceModel);

        modelAndView.setViewName(userServiceModel.getAuthorities().contains("ROLE_GUEST") ?
                "redirect:/users" : "redirect:/accommodations");

        return modelAndView;
    }

    private List<CityServiceModel> getCities() {
        return cityService.findAllCities().stream()
                .map(c -> modelMapper.map(c, CityServiceModel.class))
                .collect(Collectors.toList());
    }
}
