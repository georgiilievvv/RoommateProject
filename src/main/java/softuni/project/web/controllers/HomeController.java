package softuni.project.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.UserRegisterBindingModel;

import javax.validation.Valid;

@Controller
public class HomeController {

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(ModelAndView modelAndView, @Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel
            , BindingResult bindingResult) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            bindingResult.addError(new FieldError("userRegisterBindingModel", "password", "Passwords don't match."));
        }

//        if (bindingResult.hasErrors()) {
//            return super.view("index", "userRegisterBindingModel", userRegisterBindingModel);
//        }

//        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
//
//        if (!this.userService.registerUser(userServiceModel)) {
//            throw new UserRegisterFailureException("Registering user " + userServiceModel.getEmail() + " failed.");
//        }
//
//        this.logAction(userServiceModel, "Registered successfully.");

        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView){

        modelAndView.setViewName("index");

        return modelAndView;
    }
}