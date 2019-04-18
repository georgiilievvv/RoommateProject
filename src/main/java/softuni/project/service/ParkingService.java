package softuni.project.service;

import softuni.project.domain.models.service.ParkingServiceModel;

import java.util.List;

public interface ParkingService {

    ParkingServiceModel findById(String id);

    ParkingServiceModel addParking(ParkingServiceModel parkingServiceModel);

    List<ParkingServiceModel> findAllParkingSpots();
}
