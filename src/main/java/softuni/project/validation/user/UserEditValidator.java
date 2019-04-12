package softuni.project.validation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import softuni.project.domain.entities.User;
import softuni.project.domain.models.binding.UserEditBindingModel;
import softuni.project.repository.UserRepository;
import softuni.project.validation.ValidationConstants;
import softuni.project.validation.Validator;

@Validator
public class UserEditValidator implements org.springframework.validation.Validator {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserEditValidator(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEditBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserEditBindingModel userEditBindingModel = (UserEditBindingModel) o;

        User user = this.userRepository.findByUsername(userEditBindingModel.getUsername()).orElse(null);

        if (!this.bCryptPasswordEncoder.matches(userEditBindingModel.getOldPassword(), user.getPassword())) {
            errors.rejectValue(
                    "oldPassword",
                    ValidationConstants.WRONG_PASSWORD,
                    ValidationConstants.WRONG_PASSWORD
            );
        }

        if (!user.getEmail().equals(userEditBindingModel.getEmail()) && this.userRepository.findByEmail(userEditBindingModel.getEmail()).isPresent()) {
            errors.rejectValue(
                    "email",
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userEditBindingModel.getEmail()),
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userEditBindingModel.getEmail())
            );
        }
    }
}