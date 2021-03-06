package softuni.project.validation;

public class ValidationConstants {

    public final static String FIELD_IS_NULL = "Field cannot be empty";

    public final static String USERNAME_ALREADY_EXISTS = "Username %s already exists.";
    public final static String USERNAME_LENGTH = "Username must be between 3 and 10 characters long.";

    public final static String PASSWORDS_DO_NOT_MATCH = "Passwords don't match.";
    public final static String PASSWORD_IS_TOO_SHORT = "Password must be at least 3 symbols long.";
    public final static String WRONG_PASSWORD = "Wrong password.";
    public final static String NO_CURRENT_PASSWORD = "You must enter current password to save changes.";

    public final static String EMAIL_ALREADY_EXISTS = "Email %s already exists.";

    public final static String PHONE_NUMBER_IS_TOO_SHORT = "Phone number must at least 8 digits long.";

    public final static String INVALID_AGE = "You must be between 18 and 110 years old.";

    public final static String NAME_LENGTH = "Name must contain at least 3 characters.";

    public static final String EMAIL_IS_INVALID = "Email is invalid.";
    
    public static final String INVALID_FLOOR = "Number of floor must be between 1 and 100.";

    public static final String INVALID_NUMBER_OF_ROOMS = "Number of rooms must be between 1 and 10.";

    public static final String INVALID_NUMBER_OF_BATHROOMS = "Number of bathrooms must be between 1 and 5.";

    public static final String INVALID_RENT_PER_MONTH = "Rent must be between 1 and 5000.";

    public static final String DUPLICATE_CITY = "City already exists.";
    public static final String CITY_NAME_TOO_SHORT = "City name must be at least 2 symbols";
}
