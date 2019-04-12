package softuni.project.validation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import softuni.project.domain.models.binding.UserRegisterBindingModel;
import softuni.project.repository.UserRepository;
import softuni.project.validation.ValidationConstants;
import softuni.project.validation.Validator;

@Validator
public class UserRegisterValidator implements org.springframework.validation.Validator {

    private final UserRepository userRepository;

    @Autowired
    public UserRegisterValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegisterBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegisterBindingModel userRegisterBindingModel = (UserRegisterBindingModel) o;

        if (this.userRepository.findByUsername(userRegisterBindingModel.getUsername()).isPresent()) {
            errors.rejectValue(
                    "username",
                    String.format(ValidationConstants.USERNAME_ALREADY_EXISTS, userRegisterBindingModel.getUsername()),
                    String.format(ValidationConstants.USERNAME_ALREADY_EXISTS, userRegisterBindingModel.getUsername())
            );
        }

        if (userRegisterBindingModel.getUsername().length() < 3 || userRegisterBindingModel.getUsername().length() > 10) {
            errors.rejectValue(
                    "username",
                    ValidationConstants.USERNAME_LENGTH,
                    ValidationConstants.USERNAME_LENGTH
            );
        }

        if (!userRegisterBindingModel.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            errors.rejectValue(
                    "email",
                    ValidationConstants.EMAIL_IS_INVALID,
                    ValidationConstants.EMAIL_IS_INVALID
            );
        }

        if (userRegisterBindingModel.getUsername().length() < 3) {
            errors.rejectValue(
                    "firstName",
                    ValidationConstants.USERNAME_LENGTH,
                    ValidationConstants.USERNAME_LENGTH
            );
        }

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            errors.rejectValue(
                    "password",
                    ValidationConstants.PASSWORDS_DO_NOT_MATCH,
                    ValidationConstants.PASSWORDS_DO_NOT_MATCH
            );
        }

        if (userRegisterBindingModel.getPassword().length() < 3) {
            errors.rejectValue(
                    "password",
                    ValidationConstants.PASSWORD_IS_TOO_SHORT,
                    ValidationConstants.PASSWORD_IS_TOO_SHORT
            );
        }

        if (this.userRepository.findByEmail(userRegisterBindingModel.getEmail()).isPresent()) {
            errors.rejectValue(
                    "email",
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userRegisterBindingModel.getEmail()),
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userRegisterBindingModel.getEmail())
            );
        }

        if (userRegisterBindingModel.getPhoneNumber().length() < 8) {
            errors.rejectValue(
                    "phoneNumber",
                    ValidationConstants.PHONE_NUMBER_IS_TOO_SHORT,
                    ValidationConstants.PHONE_NUMBER_IS_TOO_SHORT
            );
        }

        if (userRegisterBindingModel.getAge() < 18 || userRegisterBindingModel.getAge() > 110) {
            errors.rejectValue(
                    "age",
                    ValidationConstants.INVALID_AGE,
                    ValidationConstants.INVALID_AGE
            );
        }
    }
}
