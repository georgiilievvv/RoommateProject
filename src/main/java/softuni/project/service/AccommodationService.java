package softuni.project.service;

import softuni.project.domain.models.service.AccommodationServiceModel;

import java.util.List;

public interface AccommodationService {

    AccommodationServiceModel addAccommodation(AccommodationServiceModel accommodationServiceModel);

    List<AccommodationServiceModel> findAllAccommodations();
}

