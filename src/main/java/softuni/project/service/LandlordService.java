package softuni.project.service;

import softuni.project.domain.models.service.GuestServiceModel;
import softuni.project.domain.models.service.LandlordServiceModel;

import java.util.List;

public interface LandlordService extends UserService<LandlordServiceModel> {

    List<GuestServiceModel> findAllApprovedGuests();
}
