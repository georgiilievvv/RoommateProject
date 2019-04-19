package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.UserEditBindingModel;
import softuni.project.domain.models.service.AccommodationServiceModel;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.service.UserServiceModel;
import softuni.project.domain.models.view.AccommodationViewModel;
import softuni.project.service.AccommodationService;
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
public class UserController extends BaseController{

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final AccommodationService accommodationService;
    private final CityService cityService;
    private final CloudinaryService cloudinaryService;
    private final UserEditValidator userEditValidator;

    public UserController(ModelMapper modelMapper, UserService userService, AccommodationService accommodationService, CityService cityService, CloudinaryService cloudinaryService, UserEditValidator userEditValidator) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.accommodationService = accommodationService;
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

    @GetMapping("/accommodations")
    public ModelAndView allAccommodations(ModelAndView modelAndView) {


        modelAndView.addObject("accommodationModels", getAccommodations());
        modelAndView.addObject("view", "/fragments/accommodation/all-accommodations");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping("/guest/marked-accommodations")
    public ModelAndView markedAccommodations(ModelAndView modelAndView, Principal principal) {

        UserServiceModel user = userService.findUserByUsername(principal.getName());

        modelAndView.addObject("accommodationModels", getAccommodations().retainAll(user.getMarkedAccommodations()));
        modelAndView.addObject("view", "/fragments/accommodation/all-accommodations");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @PostMapping("/mark-accommodation/{id}")
    @PreAuthorize("hasRole('ROLE_GUEST')")
    public ModelAndView deleteCategoryConfirm(@PathVariable String id, Principal principal) {
        UserServiceModel user = userService.findUserByUsername(principal.getName());
        user.getMarkedAccommodations().add(this.accommodationService.findAccommodationById(id));

        userService.registerUser(user);

        return super.redirect("/accommodations");
    }

    private ModelAndView setModelAndView(ModelAndView modelAndView, UserEditBindingModel userEditBindingModel) {
        modelAndView.addObject("cityModels", getCities());
        modelAndView.addObject("editUserModel", userEditBindingModel);
        modelAndView.addObject("view", "/fragments/user/edit-profile");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    private List<AccommodationViewModel> getAccommodations() {

        return accommodationService.findAllAccommodations()
                .stream().map(a -> {
                    AccommodationViewModel accommodation = this.modelMapper.map(a,AccommodationViewModel.class);
                    accommodation.setParking(a.getParking() == null? "Doesn't have" : "Has");
                    accommodation.setType(a.getType().name());
                    return accommodation;
                })
                .collect(Collectors.toList());
    }

    private List<CityServiceModel> getCities() {
        return cityService.findAllCities().stream()
                .map(c -> modelMapper.map(c, CityServiceModel.class))
                .collect(Collectors.toList());
    }

    private UserServiceModel updateEditedUser(UserEditBindingModel userEditBindingModel,Principal principal) throws IOException {
        UserServiceModel userServiceModel = this.modelMapper.map(userEditBindingModel, UserServiceModel.class);
        userServiceModel.setPassword(userEditBindingModel.getNewPassword().equals("") ?
                userEditBindingModel.getPassword() : userEditBindingModel.getNewPassword());
        userServiceModel.setId(userService.findUserByUsername(principal.getName()).getId());

//        userServiceModel.setImageUrl(
//                this.cloudinaryService.uploadImage(userEditBindingModel.getImage())
//        );

        return this.userService.editUserProfile(userServiceModel);
    }
}
