package softuni.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.project.domain.entities.City;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.view.CityViewModel;
import softuni.project.repository.CityRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final ModelMapper modelMapper;
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(ModelMapper modelMapper, CityRepository cityRepository) {
        this.modelMapper = modelMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityServiceModel> findAllCities() {
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
