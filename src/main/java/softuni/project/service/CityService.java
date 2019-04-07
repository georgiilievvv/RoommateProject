package softuni.project.service;

import softuni.project.domain.models.service.CityServiceModel;

import java.util.List;

public interface CityService {

    List<CityServiceModel> findAllCities();

    CityServiceModel findCityById(String Id);
}
