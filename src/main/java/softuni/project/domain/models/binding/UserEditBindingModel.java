package softuni.project.domain.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserEditBindingModel {

    private String username;
    private String firstName;
    private String email;
    private String oldPassword;
    private String newPassword;
    private String phoneNumber;
    private Integer age;
    private String gender;
    private String cityId;
    private String conditions;
    private String roommateGender;
    private String preferences;


    public UserEditBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "Username cannot be null.")
    @NotEmpty(message = "Username cannot be empty.")
    @Length(min = 2, message = "Username must be at least 2 symbols long.")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull(message = "Email cannot be null.")
    @NotEmpty(message = "Email cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Please enter a valid email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Password cannot be null.")
    @NotEmpty(message = "Password cannot be empty.")
    @Length(min = 4, max = 20, message = "Password must be between 4 and 20 symbols long.")
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @NotNull(message = "Password cannot be null.")
    @NotEmpty(message = "Password cannot be empty.")
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @NotNull(message = "Phone number cannot be null.")
    @NotEmpty(message = "Phone number cannot be empty.")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getRoommateGender() {
        return roommateGender;
    }

    public void setRoommateGender(String roommateGender) {
        this.roommateGender = roommateGender;
    }

    public String getPreferences() {

        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
