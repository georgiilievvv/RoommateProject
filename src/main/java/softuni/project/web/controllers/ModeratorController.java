package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.service.CityService;
import softuni.project.service.UserService;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/moderator")
public class ModeratorController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CityService cityService;

    public ModeratorController(ModelMapper modelMapper, UserService userService, CityService cityService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.cityService = cityService;
    }

    @GetMapping("/users")
    public ModelAndView moderatorUsers(ModelAndView modelAndView){

        modelAndView.setViewName("moderator-users");

        return modelAndView;
    }

    @GetMapping("/accommodations")
    public ModelAndView moderatorAccommodations(ModelAndView modelAndView){

        modelAndView.setViewName("moderator-accommodations");

        return modelAndView;
    }

    @GetMapping("/cities")
    public ModelAndView moderatorCities(ModelAndView modelAndView){

        modelAndView.setViewName("moderator-accommodations");

        return modelAndView;
    }

    @GetMapping("/reports")
    public ModelAndView moderatorReports(ModelAndView modelAndView){

        modelAndView.setViewName("moderator-accommodations");

        return modelAndView;
    }

    @GetMapping("/messages")
    public ModelAndView moderatorMessages(ModelAndView modelAndView){

        modelAndView.setViewName("moderator-messages");

        return modelAndView;
    }
}
