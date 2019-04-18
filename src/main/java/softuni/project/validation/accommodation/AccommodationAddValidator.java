package softuni.project.validation.accommodation;

import org.springframework.validation.Errors;
import softuni.project.domain.models.binding.AccommodationAddBindingModel;
import softuni.project.domain.models.binding.UserRegisterBindingModel;
import softuni.project.validation.ValidationConstants;
import softuni.project.validation.Validator;

@Validator
public class AccommodationAddValidator implements org.springframework.validation.Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegisterBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AccommodationAddBindingModel accommodationAddBindingModel = (AccommodationAddBindingModel) o;

        if (accommodationAddBindingModel.getFloor() == 0 && accommodationAddBindingModel.getYardQuadrature() == 0) {
            errors.rejectValue(
                    "floor",
                    ValidationConstants.FIELD_IS_NULL,
                    ValidationConstants.FIELD_IS_NULL
            );

            errors.rejectValue(
                    "yardQuadrature",
                    ValidationConstants.FIELD_IS_NULL,
                    ValidationConstants.FIELD_IS_NULL
            );
        } else {
            if (accommodationAddBindingModel.getFloor() > 100 || accommodationAddBindingModel.getFloor() < 1) {
                errors.rejectValue(
                        "floor",
                        ValidationConstants.INVALID_FLOOR,
                        ValidationConstants.INVALID_FLOOR
                );
            }

            if (accommodationAddBindingModel.getYardQuadrature() > 300 || accommodationAddBindingModel.getYardQuadrature() < 0) {
                errors.rejectValue(
                        "yardQuadrature",
                        ValidationConstants.INVALID_FLOOR,
                        ValidationConstants.INVALID_FLOOR
                );
            }
        }

        if (accommodationAddBindingModel.getNumberOfRooms() > 10 || accommodationAddBindingModel.getNumberOfRooms() < 1) {
            errors.rejectValue(
                    "numberOfRooms",
                    ValidationConstants.INVALID_NUMBER_OF_ROOMS,
                    ValidationConstants.INVALID_NUMBER_OF_ROOMS
            );
        }

        if (accommodationAddBindingModel.getNumberOfBathrooms() > 5 || accommodationAddBindingModel.getNumberOfBathrooms() < 1) {
            errors.rejectValue(
                    "numberOfBathrooms",
                    ValidationConstants.INVALID_NUMBER_OF_BATHROOMS,
                    ValidationConstants.INVALID_NUMBER_OF_BATHROOMS
            );
        }

        if (Double.parseDouble(accommodationAddBindingModel.getRentPerMonth().toString()) > 5000 || Double.parseDouble(accommodationAddBindingModel.getRentPerMonth().toString()) < 1) {
            errors.rejectValue(
                    "rentPerMonth",
                    ValidationConstants.INVALID_RENT_PER_MONTH,
                    ValidationConstants.INVALID_RENT_PER_MONTH
            );
        }

        if (accommodationAddBindingModel.getAddress().length() < 1) {
            errors.rejectValue(
                    "address",
                    ValidationConstants.FIELD_IS_NULL,
                    ValidationConstants.FIELD_IS_NULL
            );
        }
    }
}
