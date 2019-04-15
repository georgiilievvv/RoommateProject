package softuni.project.validation.accommodation;

import org.springframework.validation.Errors;
import softuni.project.domain.models.binding.AccommodationAddBindingModel;
import softuni.project.domain.models.binding.UserRegisterBindingModel;
import softuni.project.validation.ValidationConstants;
import softuni.project.validation.Validator;

@Validator
public class AccommodationAddValidator implements org.springframework.validation.Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegisterBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AccommodationAddBindingModel accommodationAddBindingModel = (AccommodationAddBindingModel) o;

        if (accommodationAddBindingModel.getFloor() > 100 || accommodationAddBindingModel.getFloor() < 1 ) {
            errors.rejectValue(
                    "floor",
                   ValidationConstants.INVALID_FLOOR,
                   ValidationConstants.INVALID_FLOOR
            );
        }
    }
}
