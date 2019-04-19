package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.CityBindingModel;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.view.CityViewModel;
import softuni.project.domain.models.view.UserAllViewModel;
import softuni.project.service.CityService;
import softuni.project.service.UserService;
import softuni.project.validation.city.CityValidator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAuthority('ROLE_MODERATOR')")
@RequestMapping("/moderator")
public class ModeratorController extends BaseController {

    private final ModelMapper modelMapper;
    private final CityValidator cityValidator;
    private final UserService userService;
    private final CityService cityService;

    public ModeratorController(ModelMapper modelMapper, CityValidator cityValidator, UserService userService, CityService cityService) {
        this.modelMapper = modelMapper;
        this.cityValidator = cityValidator;
        this.userService = userService;
        this.cityService = cityService;
    }

    @GetMapping("/accommodations")
    public ModelAndView moderatorAccommodations(ModelAndView modelAndView) {

        modelAndView.setViewName("moderator-accommodations");

        return modelAndView;
    }

    @GetMapping("/reports")
    public ModelAndView moderatorReports(ModelAndView modelAndView) {

        modelAndView.setViewName("moderator-accommodations");

        return modelAndView;
    }

    @GetMapping("/messages")
    public ModelAndView moderatorMessages(ModelAndView modelAndView) {

        modelAndView.setViewName("moderator-messages");

        return modelAndView;
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView allUsers(ModelAndView modelAndView) {
        List<UserAllViewModel> users = this.userService.findAllUsers()
                .stream()
                .map(u -> {
                    UserAllViewModel user = this.modelMapper.map(u, UserAllViewModel.class);
                    Set<String> authorities = u.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toSet());
                    user.setAuthorities(authorities);

                    return user;
                })
                .collect(Collectors.toList());

        modelAndView.addObject("users", users);
        modelAndView.addObject("view", "/fragments/user/all-users");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @PostMapping("/set-user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView setUser(@PathVariable String id) {
        this.userService.setUserRole(id, "user");

        return super.redirect("/moderator/users");
    }

    @PostMapping("/set-moderator/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView setModerator(@PathVariable String id) {
        this.userService.setUserRole(id, "moderator");

        return super.redirect("/moderator/users");
    }

    @GetMapping("/cities")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView allCategories(ModelAndView modelAndView) {
        List<CityViewModel> cities = this.cityService.findAllCities()
                .stream()
                .map(c -> this.modelMapper.map(c, CityViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("cities", cities);
        modelAndView.addObject("view", "/fragments/city/all-cities");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping("/add-city")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView addCategory(ModelAndView modelAndView, @ModelAttribute(name = "cityModel") CityBindingModel model) {
        modelAndView.addObject("cityModel", model);
        modelAndView.addObject("view", "/fragments/city/add-city");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @PostMapping("/add-city")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView addCategoryConfirm(ModelAndView modelAndView, @ModelAttribute(name = "cityModel") CityBindingModel model, BindingResult bindingResult) {

        this.cityValidator.validate(model, bindingResult);

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("cityModel", model);
            modelAndView.addObject("view", "/fragments/city/add-city");
            modelAndView.setViewName("home");
        }

        cityService.addCity(this.modelMapper.map(model, CityServiceModel.class));
        modelAndView.addObject("cityModel", model);
        modelAndView.addObject("view", "/fragments/city/all-cities");

        return super.redirect("/moderator/cities");
    }


    @GetMapping("/edit-city/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView editCategory(@PathVariable String id, ModelAndView modelAndView, @ModelAttribute(name = "cityModel") CityBindingModel model) {
        model = this.modelMapper.map(this.cityService.findCityById(id), CityBindingModel.class);

        modelAndView.addObject("cityModel", model);
        modelAndView.addObject("cityId", id);
        modelAndView.addObject("view", "/fragments/city/edit-city");
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @PostMapping("/edit-city/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView editCategoryConfirm(@PathVariable String id, ModelAndView modelAndView, @ModelAttribute(name = "cityModel") CityBindingModel model, BindingResult bindingResult) {

        this.cityValidator.validate(model, bindingResult);

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("cityId", id);
            modelAndView.addObject("cityModel", model);
            modelAndView.addObject("view", "/fragments/city/edit-city");
            modelAndView.setViewName("home");
            return modelAndView;
        }


        model.setId(id);
        this.cityService.addCity(this.modelMapper.map(model, CityServiceModel.class));

        return super.redirect("/moderator/cities");
    }

    @PostMapping("/delete-city/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView deleteCategoryConfirm(@PathVariable String id) {
        this.cityService.deleteCity(cityService.findCityById(id));

        return super.redirect("/moderator/cities");
    }

    @GetMapping("/fetch")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @ResponseBody
    public List<CityViewModel> fetchCategories() {
        List<CityViewModel> cities = this.cityService.findAllCities()
                .stream()
                .map(c -> this.modelMapper.map(c, CityViewModel.class))
                .collect(Collectors.toList());

        return cities;
    }
}

