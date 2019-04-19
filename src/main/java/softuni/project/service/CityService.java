package softuni.project.service;

import softuni.project.domain.models.service.CityServiceModel;

import java.util.List;

public interface CityService {

    CityServiceModel addCity(CityServiceModel cityServiceModel);

    boolean deleteCity(CityServiceModel cityServiceModel);

    void seedCitiesInDb();

    List<CityServiceModel> findAllCities();

    CityServiceModel findCityById(String Id);
}
