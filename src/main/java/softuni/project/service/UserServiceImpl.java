package softuni.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softuni.project.domain.models.service.LandlordServiceModel;
import softuni.project.domain.models.service.UserServiceModel;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final LandlordService landlordService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(LandlordService landlordService, ModelMapper modelMapper) {
        this.landlordService = landlordService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        if (userServiceModel.getPreferences() == null){

            if (userServiceModel.getRoommateGender().equals("")) {
                userServiceModel.setRoommateGender(null);
            }

            this.landlordService.registerLandlord(this.modelMapper
                    .map(userServiceModel, LandlordServiceModel.class));
        }else {
//            this.landlordService.registerLandlord(this.modelMapper
//                    .map(userServiceModel, LandlordServiceModel.class));
        }
        return null;
    }

    @Override
    public List<UserServiceModel> findAllUsers() {
        return null;
    }
}
