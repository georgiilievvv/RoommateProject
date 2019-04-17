package softuni.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.project.domain.entities.Accommodation;
import softuni.project.domain.models.service.AccommodationServiceModel;
import softuni.project.repository.AccommodationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final ParkingService parkingService;
    private final AccommodationRepository accommodationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AccommodationServiceImpl(ParkingService parkingService, AccommodationRepository accommodationRepository, ModelMapper modelMapper) {
        this.parkingService = parkingService;
        this.accommodationRepository = accommodationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccommodationServiceModel addAccommodation(AccommodationServiceModel accommodationServiceModel) {

        this.parkingService.addParking(accommodationServiceModel.getParking());

            Accommodation accommodation = this.modelMapper.map(accommodationServiceModel, Accommodation.class);
            this.accommodationRepository.save(accommodation);

            return this.modelMapper.map(accommodation, AccommodationServiceModel.class);
    }

    @Override
    public List<AccommodationServiceModel> findAllAccommodations() {

        return this.accommodationRepository.findAll()
                .stream().map(a -> this.modelMapper.map(a, AccommodationServiceModel.class))
                .collect(Collectors.toList());

    }
}
