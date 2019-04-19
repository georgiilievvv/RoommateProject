package softuni.project.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.domain.models.view.UserAllViewModel;
import softuni.project.service.CityService;
import softuni.project.service.UserService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/moderator")
public class ModeratorController extends BaseController{

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CityService cityService;

    public ModeratorController(ModelMapper modelMapper, UserService userService, CityService cityService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.cityService = cityService;
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

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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

}
