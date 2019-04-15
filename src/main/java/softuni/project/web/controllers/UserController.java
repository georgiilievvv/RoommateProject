package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.UserEditBindingModel;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.service.UserServiceModel;
import softuni.project.service.CityService;
import softuni.project.service.CloudinaryService;
import softuni.project.service.UserService;
import softuni.project.validation.user.UserEditValidator;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("isAuthenticated()")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CityService cityService;
    private final CloudinaryService cloudinaryService;
    private final UserEditValidator userEditValidator;

    public UserController(ModelMapper modelMapper, UserService userService, CityService cityService, CloudinaryService cloudinaryService, UserEditValidator userEditValidator) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.cityService = cityService;
        this.cloudinaryService = cloudinaryService;
        this.userEditValidator = userEditValidator;
    }

    @GetMapping("/edit-profile")
    public ModelAndView editProfile(ModelAndView modelAndView, Principal principal) {
        UserEditBindingModel editModel = this.modelMapper.map(this.userService.findUserByUsername(principal.getName()), UserEditBindingModel.class);
        setModelAndView(modelAndView, editModel);
        return modelAndView;
    }

    @PostMapping("/edit-profile")
    public ModelAndView editProfile(ModelAndView modelAndView, @Valid @ModelAttribute("editUserModel")
            UserEditBindingModel userEditBindingModel, BindingResult bindingResult, Principal principal) throws IOException {

        userEditBindingModel.setUsername(principal.getName());
        userEditValidator.validate(userEditBindingModel, bindingResult);

        if (bindingResult.hasErrors()) {
            return setModelAndView(modelAndView, userEditBindingModel);
        }

        UserServiceModel userServiceModel = updateEditedUser(userEditBindingModel, principal);

        modelAndView.setViewName(userServiceModel.getAuthorities().contains("ROLE_GUEST") ?
                "redirect:/users" : "redirect:/accommodations");

        return modelAndView;
    }

    private List<CityServiceModel> getCities() {
        return cityService.findAllCities().stream()
                .map(c -> modelMapper.map(c, CityServiceModel.class))
                .collect(Collectors.toList());
    }

    private ModelAndView setModelAndView(ModelAndView modelAndView, UserEditBindingModel userEditBindingModel) {
        modelAndView.addObject("cityModels", getCities());
        modelAndView.addObject("editUserModel", userEditBindingModel);
        modelAndView.addObject("view", "/fragments/user/edit-profile");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    private UserServiceModel updateEditedUser(UserEditBindingModel userEditBindingModel,Principal principal) throws IOException {
        UserServiceModel userServiceModel = this.modelMapper.map(userEditBindingModel, UserServiceModel.class);
        userServiceModel.setPassword(userEditBindingModel.getNewPassword().equals("") ?
                userEditBindingModel.getPassword() : userEditBindingModel.getNewPassword());
        userServiceModel.setId(userService.findUserByUsername(principal.getName()).getId());

        userServiceModel.setImageUrl(
                this.cloudinaryService.uploadImage(userEditBindingModel.getImage())
        );

        return this.userService.editUserProfile(userServiceModel);
    }
}
