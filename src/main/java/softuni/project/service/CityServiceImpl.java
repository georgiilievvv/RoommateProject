package softuni.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.project.domain.entities.City;
import softuni.project.domain.models.service.AccommodationServiceModel;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.service.UserServiceModel;
import softuni.project.repository.CityRepository;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final AccommodationService accommodationService;
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(ModelMapper modelMapper, UserService userService, AccommodationService accommodationService, CityRepository cityRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.accommodationService = accommodationService;
        this.cityRepository = cityRepository;
    }

    @Override
    public void seedCitiesInDb() {
        this.cityRepository.saveAndFlush(new City("Sofia"));
        this.cityRepository.saveAndFlush(new City("Plovdiv"));
        this.cityRepository.saveAndFlush(new City("Burgas"));
        this.cityRepository.saveAndFlush(new City("Varna"));
    }

    @Override
    public CityServiceModel addCity(CityServiceModel cityServiceModel) {
        City city = this.cityRepository.save(this.modelMapper.map(cityServiceModel, City.class));

        return this.modelMapper.map(city, CityServiceModel.class);
    }

    @Override
    public boolean deleteCity(CityServiceModel cityServiceModel) {

        Set<String> usedCities = new HashSet<>();
        usedCities.addAll(userService.findAllUsers().stream().map(UserServiceModel::getCity)
                .map(CityServiceModel::getCityName).collect(Collectors.toSet()));

        usedCities.addAll(accommodationService.findAllAccommodations().stream().map(AccommodationServiceModel::getCity)
                .map(CityServiceModel::getCityName).collect(Collectors.toSet()));

        if (!usedCities.contains(cityServiceModel.getCityName())) {
            this.cityRepository.delete(this.modelMapper.map(cityServiceModel, City.class));
            return true;
        }

        return false;
    }

    @Override
    public List<CityServiceModel> findAllCities() {
        if (this.cityRepository.count() == 0) {
            seedCitiesInDb();
        }
        return this.cityRepository.findAll().stream()
                .map(c -> modelMapper.map(c, CityServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CityServiceModel findCityById(String Id) {
        City city = this.cityRepository.findById(Id).orElse(null);

        if (city == null) {
            throw new EntityNotFoundException();
        } else {
            return this.modelMapper.map(city, CityServiceModel.class);
        }
    }
}
