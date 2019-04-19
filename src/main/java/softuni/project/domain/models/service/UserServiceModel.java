package softuni.project.domain.models.service;

import softuni.project.domain.entities.Gender;

import java.util.Set;

public class UserServiceModel extends BaseServiceModel {

    private String username;
    private String firstName;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private String imageUrl;
    private Integer age;
    private Gender gender;
    private CityServiceModel city;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private AccommodationServiceModel accommodation;
    private Set<RoleServiceModel> authorities;

    public Set<RoleServiceModel> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<RoleServiceModel> authorities) {
        this.authorities = authorities;
    }

    private String preferences;
    private String roommateGender;
    private String conditions;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CityServiceModel getCity() {
        return city;
    }

    public void setCity(CityServiceModel city) {
        this.city = city;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getRoommateGender() {
        return roommateGender;
    }

    public void setRoommateGender(String roommateGender) {
        this.roommateGender = roommateGender;
    }

    public AccommodationServiceModel getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(AccommodationServiceModel accommodation) {
        this.accommodation = accommodation;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
