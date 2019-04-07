package softuni.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import softuni.project.domain.models.service.GuestServiceModel;
import softuni.project.domain.models.service.LandlordServiceModel;
import softuni.project.domain.models.service.LandlordServiceModel;

import java.util.List;

public interface LandlordService extends UserDetailsService {

    List<GuestServiceModel> findAllApprovedGuests();
    
    LandlordServiceModel registerLandlord(LandlordServiceModel LandlordServiceModel);

    LandlordServiceModel findLandlordByUsername(String username);

    LandlordServiceModel editLandlordProfile(LandlordServiceModel landlordServiceModel, String oldPassword);

    List<LandlordServiceModel> findAllLandlords();

    void setLandlordRole(String id, String role);
}
