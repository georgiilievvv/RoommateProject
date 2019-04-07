package softuni.project.service;

import softuni.project.domain.models.service.UserServiceModel;
import java.util.List;

public interface UserService{
    
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    List<UserServiceModel> findAllUsers();
}
