package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.binding.AccommodationAddBindingModel;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.service.AccommodationService;
import softuni.project.service.CityService;
import softuni.project.service.UserService;
import softuni.project.validation.accommodation.AccommodationAddValidator;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/landlord")
@PreAuthorize("hasRole('ROLE_LANDLORD')")
public class LandlordController {

    private final AccommodationService accommodationService;
    private final AccommodationAddValidator accommodationAddValidator;
    private final UserService userService;
    private final CityService cityService;
    private final ModelMapper modelMapper;

    @Autowired
    public LandlordController(AccommodationService accommodationService, AccommodationAddValidator accommodationAddValidator, UserService userService, CityService cityService, ModelMapper modelMapper) {
        this.accommodationService = accommodationService;
        this.accommodationAddValidator = accommodationAddValidator;
        this.userService = userService;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/my-home")
    public ModelAndView myHome(ModelAndView modelAndView, Principal principal) {

        if (this.userService.findUserByUsername(principal.getName()).getAccommodation() == null) {
            modelAndView.setViewName("redirect:/landlord/add-accommodation");
            return modelAndView;
        }

        return modelAndView;
    }

    @GetMapping("add-accommodation")
    public ModelAndView myHome(ModelAndView modelAndView, @ModelAttribute(name = "accommodationModel")
            AccommodationAddBindingModel accommodationAddBindingModel, Principal principal) {

        if (this.userService.findUserByUsername(principal.getName()).getAccommodation() != null) {
            modelAndView.setViewName("redirect:/landlord/add-accommodation");
            return modelAndView;
        }

        return setModelAndView(modelAndView, accommodationAddBindingModel);
    }


    @PostMapping("/add-accommodation")
    public ModelAndView myHome(ModelAndView modelAndView, @Valid @ModelAttribute()
            AccommodationAddBindingModel accommodationAddBindingModel, BindingResult bindingResult, Principal principal) {

        accommodationAddBindingModel.setOwner(principal.getName());
        accommodationAddValidator.validate(accommodationAddBindingModel, bindingResult);

        if (bindingResult.hasErrors()) {
            return setModelAndView(modelAndView, accommodationAddBindingModel);
        }

        return modelAndView;
    }

    private List<CityServiceModel> getCities() {
        return cityService.findAllCities().stream()
                .map(c -> modelMapper.map(c, CityServiceModel.class))
                .collect(Collectors.toList());
    }

    private ModelAndView setModelAndView(ModelAndView modelAndView, AccommodationAddBindingModel accommodationAddBindingModel) {
        modelAndView.addObject("cityModels", getCities());
        modelAndView.addObject("accommodationModel", accommodationAddBindingModel);
        modelAndView.addObject("view", "/fragments/accommodation/add-accommodation");
        modelAndView.setViewName("home");

        return modelAndView;
    }
}
