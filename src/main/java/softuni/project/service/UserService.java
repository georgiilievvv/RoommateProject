package softuni.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import softuni.project.domain.models.service.UserServiceModel;
import java.util.List;

public interface UserService extends UserDetailsService {
    
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    List<UserServiceModel> findAllUsers();
}
