package softuni.project.service;

import softuni.project.domain.entities.Parking;
import softuni.project.domain.models.service.ParkingServiceModel;

import java.util.List;

public interface ParkingService {

    ParkingServiceModel addParking(ParkingServiceModel parkingServiceModel);

    List<ParkingServiceModel> findAllParkingSpots();
}
