package softuni.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.project.domain.entities.Apartment;
import softuni.project.domain.entities.House;
import softuni.project.domain.models.service.AccommodationServiceModel;
import softuni.project.repository.ApartmentRepository;
import softuni.project.repository.HouseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final ParkingService parkingService;
    private final HouseRepository houseRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AccommodationServiceImpl(ParkingService parkingService, HouseRepository houseRepository, ApartmentRepository apartmentRepository, ModelMapper modelMapper) {
        this.parkingService = parkingService;
        this.houseRepository = houseRepository;
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccommodationServiceModel addAccommodation(AccommodationServiceModel accommodationServiceModel) {

        this.parkingService.addParking(accommodationServiceModel.getParking());

        if (accommodationServiceModel.getYardQuadrature() == null){
            Apartment apartment = this.modelMapper.map(accommodationServiceModel, Apartment.class);
            this.apartmentRepository.save(apartment);

            return this.modelMapper.map(apartment, AccommodationServiceModel.class);
        }else {
            House house = this.modelMapper.map(accommodationServiceModel, House.class);
            this.houseRepository.save(house);

            return this.modelMapper.map(house, AccommodationServiceModel.class);
        }
    }

    @Override
    public List<AccommodationServiceModel> findAllAccommodations() {

        List<AccommodationServiceModel> accommodations = this.apartmentRepository.findAll()
                .stream().map(a -> this.modelMapper.map(a, AccommodationServiceModel.class))
                .collect(Collectors.toList());

        accommodations.addAll(this.houseRepository.findAll()
                .stream().map(h -> this.modelMapper.map(h, AccommodationServiceModel.class))
                .collect(Collectors.toList()));

        return accommodations;
    }
}
