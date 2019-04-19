package softuni.project.service;

import softuni.project.domain.models.service.AccommodationServiceModel;

import java.util.List;

public interface AccommodationService {

    AccommodationServiceModel addAccommodation(AccommodationServiceModel accommodationServiceModel);

    AccommodationServiceModel findAccommodationById(String id);

    List<AccommodationServiceModel> findAllAccommodations();
}

