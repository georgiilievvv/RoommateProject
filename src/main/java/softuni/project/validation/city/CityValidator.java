package softuni.project.validation.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import softuni.project.domain.entities.City;
import softuni.project.domain.models.binding.CityBindingModel;
import softuni.project.domain.models.binding.UserRegisterBindingModel;
import softuni.project.repository.CityRepository;
import softuni.project.validation.ValidationConstants;
import softuni.project.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

@Validator
public class CityValidator implements org.springframework.validation.Validator {

    private final CityRepository cityRepository;

    @Autowired
    public CityValidator(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegisterBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CityBindingModel cityBindingModel = (CityBindingModel) o;

        List<String> cityNamesInRepo = cityRepository.findAll().stream().map(City::getCityName)
                .collect(Collectors.toList());

        if (cityNamesInRepo.contains(cityBindingModel.getCityName())){
            errors.rejectValue(
                    "cityName",
                    ValidationConstants.DUPLICATE_CITY,
                    ValidationConstants.DUPLICATE_CITY
            );
        }

        if (cityBindingModel.getCityName().length() < 2){
            errors.rejectValue(
                    "cityName",
                   ValidationConstants.CITY_NAME_TOO_SHORT,
                   ValidationConstants.CITY_NAME_TOO_SHORT
            );
        }
    }
}