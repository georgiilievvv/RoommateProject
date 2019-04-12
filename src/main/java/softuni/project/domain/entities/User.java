package softuni.project.domain.entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    private String username;
    private String password;
    private String firstName;
    private String email;
    private String phoneNumber;
    private Integer age;
    private Gender gender;
    private City city;
    private Set<Role> authorities;
    private String roommateGender;
    private String conditions;
    private List<User> approvedRoommates;
    private String preferences;
    private List<User> landlord_approvals;
    private List<Apartment> marked_Apartments;
    private List<House> marked_Houses;

    public User() {
    }

    @Override
    @Column(name = "username", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "full_name", nullable = false, unique = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "age", nullable = false)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @ManyToOne()
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }

    @Override
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    @Column(name = "roommate_gender")
    public String getRoommateGender() {
        return roommateGender;
    }

    public void setRoommateGender(String roommateGender) {
        this.roommateGender = roommateGender;
    }

    @Column(name = "conditions")
    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "approved_roommates_landlord_approvals",
            joinColumns = @JoinColumn(name = "landlord_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roommates_id", referencedColumnName = "id")
    )
    public List<User> getApprovedRoommates() {
        return approvedRoommates;
    }

    public void setApprovedRoommates(List<User> approvedRoommates) {
        this.approvedRoommates = approvedRoommates;
    }

    @Column(name = "preferences")
    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    @ManyToMany(targetEntity = User.class, mappedBy = "approvedRoommates")
    public List<User> getLandlord_approvals() {
        return landlord_approvals;
    }

    public void setLandlord_approvals(List<User> landlord_approvals) {
        this.landlord_approvals = landlord_approvals;
    }

    @OneToMany(targetEntity = Apartment.class)
    @JoinColumn(name = "apartments_id", referencedColumnName = "id")
    public List<Apartment> getMarked_Apartments() {
        return marked_Apartments;
    }

    public void setMarked_Apartments(List<Apartment> marked_Apartments) {
        this.marked_Apartments = marked_Apartments;
    }

    @OneToMany(targetEntity = House.class)
    @JoinColumn(name = "houses_id", referencedColumnName = "id")
    public List<House> getMarked_Houses() {
        return marked_Houses;
    }

    public void setMarked_Houses(List<House> marked_Houses) {
        this.marked_Houses = marked_Houses;
    }

}
