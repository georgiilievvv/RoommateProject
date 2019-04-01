package softuni.project.domain.models.service;

import softuni.project.domain.entities.Gender;

import java.util.List;
import java.util.Set;

public class GuestServiceModel extends BaseServiceModel{

    private String username;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private Integer age;
    private Gender gender;
    private CityServiceModel city;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Set<RoleServiceModel> authorities;
    private String preferences;
    private List<LandlordServiceModel> landlord_approvals;
    private List<ApartmentServiceModel> marked_Apartments;
    private List<HouseServiceModel> marked_Houses;

    public GuestServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Set<RoleServiceModel> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<RoleServiceModel> authorities) {
        this.authorities = authorities;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public List<LandlordServiceModel> getLandlord_approvals() {
        return landlord_approvals;
    }

    public void setLandlord_approvals(List<LandlordServiceModel> landlord_approvals) {
        this.landlord_approvals = landlord_approvals;
    }

    public List<ApartmentServiceModel> getMarked_Apartments() {
        return marked_Apartments;
    }

    public void setMarked_Apartments(List<ApartmentServiceModel> marked_Apartments) {
        this.marked_Apartments = marked_Apartments;
    }

    public List<HouseServiceModel> getMarked_Houses() {
        return marked_Houses;
    }

    public void setMarked_Houses(List<HouseServiceModel> marked_Houses) {
        this.marked_Houses = marked_Houses;
    }
}
