package softuni.project.validation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import softuni.project.domain.entities.User;
import softuni.project.domain.models.binding.UserEditBindingModel;
import softuni.project.domain.models.service.UserServiceModel;
import softuni.project.repository.UserRepository;
import softuni.project.service.UserService;
import softuni.project.validation.ValidationConstants;
import softuni.project.validation.Validator;

@Validator
public class UserEditValidator implements org.springframework.validation.Validator {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserEditValidator(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEditBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserEditBindingModel userEditBindingModel = (UserEditBindingModel) o;

        UserServiceModel user = this.userService.findUserByUsername(userEditBindingModel.getUsername());

        if (!user.getEmail().equals(userEditBindingModel.getEmail()) && this.userService.findUserByEmail(userEditBindingModel.getEmail()) == null) {
            errors.rejectValue(
                    "email",
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userEditBindingModel.getEmail()),
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userEditBindingModel.getEmail())
            );
        }

        if (!userEditBindingModel.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            errors.rejectValue(
                    "email",
                    ValidationConstants.EMAIL_IS_INVALID,
                    ValidationConstants.EMAIL_IS_INVALID
            );
        }

        if (userEditBindingModel.getUsername().length() < 3) {
            errors.rejectValue(
                    "firstName",
                    ValidationConstants.NAME_LENGTH,
                    ValidationConstants.NAME_LENGTH
            );
        }

        if (userEditBindingModel.getPhoneNumber().length() < 8) {
            errors.rejectValue(
                    "phoneNumber",
                    ValidationConstants.PHONE_NUMBER_IS_TOO_SHORT,
                    ValidationConstants.PHONE_NUMBER_IS_TOO_SHORT
            );
        }

        if (userEditBindingModel.getAge() < 18 || userEditBindingModel.getAge() > 110) {
            errors.rejectValue(
                    "age",
                    ValidationConstants.INVALID_AGE,
                    ValidationConstants.INVALID_AGE
            );
        }

        if (!errors.hasErrors() && userEditBindingModel.getPassword().isEmpty()){
            errors.rejectValue(
                    "password",
                    ValidationConstants.NO_CURRENT_PASSWORD,
                    ValidationConstants.NO_CURRENT_PASSWORD
            );
        }

        if (errors.getFieldErrors("password").size() == 0 && !this.bCryptPasswordEncoder.matches(userEditBindingModel.getPassword(), user.getPassword())) {
            errors.rejectValue(
                    "password",
                    ValidationConstants.WRONG_PASSWORD,
                    ValidationConstants.WRONG_PASSWORD
            );
        }

        if (errors.getFieldErrors("password").size() == 0 && userEditBindingModel.getNewPassword().length() != 0 && userEditBindingModel.getNewPassword().length() < 3) {
            errors.rejectValue(
                    "newPassword",
                    ValidationConstants.PASSWORD_IS_TOO_SHORT,
                    ValidationConstants.PASSWORD_IS_TOO_SHORT
            );
        }
    }
}