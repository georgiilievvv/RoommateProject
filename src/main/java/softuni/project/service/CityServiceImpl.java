package softuni.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.project.domain.models.service.CityServiceModel;
import softuni.project.domain.models.view.CityViewModel;
import softuni.project.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService{

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
}
