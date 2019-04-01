package softuni.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService<E> extends UserDetailsService {
    
    E registerUser(E model);

    E findUserByUserName(String username);

    E editUserProfile(E userServiceModel, String oldPassword);

    List<E> findAllUsers();

    void setUserRole(String id, String role);
}
