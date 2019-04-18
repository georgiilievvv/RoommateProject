package softuni.project.service;

import javassist.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.project.domain.entities.Parking;
import softuni.project.domain.models.service.ParkingServiceModel;
import softuni.project.repository.ParkingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ParkingServiceImpl(ParkingRepository parkingRepository, ModelMapper modelMapper) {
        this.parkingRepository = parkingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingServiceModel findById(String id) {
        return this.parkingRepository.findById(id).map(p -> modelMapper.map(p, ParkingServiceModel.class))
                .orElse(null);
    }

    @Override
    public ParkingServiceModel addParking(ParkingServiceModel parkingServiceModel) {

        parkingServiceModel.setId("");

        Parking parking = this.parkingRepository
               .save(modelMapper.map(parkingServiceModel, Parking.class));

       return this.modelMapper.map(parking, ParkingServiceModel.class);
    }

    @Override
    public List<ParkingServiceModel> findAllParkingSpots() {
        return this.parkingRepository.findAll().stream()
                .map(p -> modelMapper.map(p, ParkingServiceModel.class))
                .collect(Collectors.toList());
    }
}
