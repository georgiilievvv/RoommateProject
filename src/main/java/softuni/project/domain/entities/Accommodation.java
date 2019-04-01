package softuni.project.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
public class Accommodation extends BaseEntity{

    private BaseUser owner;
    private City city;
    private	String address;
    private	Double quadrature;
    private BigDecimal rentPerMonth;
    private	Parking parking;
    private	Integer numberOfRooms;
    private	Integer numberOfBathrooms;
    private	boolean hasTV;
    private	boolean hasWifi;
    private	boolean Furnished;
    private	boolean hasRefrigerator;
    private	boolean hasWashingMachine;
    private String imageUrl;
    private	String moreInfo;


    protected Accommodation() {
    }

    @OneToOne(targetEntity = Landlord.class)
    @JoinColumn(
            name = "landlord_id", referencedColumnName = "id",
            nullable = false
    )
    public BaseUser getOwner() {
        return owner;
    }

    public void setOwner(BaseUser owner) {
        this.owner = owner;
    }

    @ManyToOne()
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "quadrature", nullable = false)
    public Double getQuadrature() {
        return quadrature;
    }

    public void setQuadrature(Double quadrature) {
        this.quadrature = quadrature;
    }

    @Column(name = "rent_per_month", nullable = false)
    public BigDecimal getRentPerMonth() {
        return rentPerMonth;
    }

    public void setRentPerMonth(BigDecimal rentPerMonth) {
        this.rentPerMonth = rentPerMonth;
    }

    @OneToOne(targetEntity = Parking.class)
    @JoinColumn(
            name = "parking_id", referencedColumnName = "id",
            nullable = false
    )
    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @Column(name = "number_of_rooms", nullable = false)
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Column(name = "number_of_bathrooms", nullable = false)
    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    @Column(name = "has_tv", nullable = false)
    public boolean isHasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    @Column(name = "has_wifi", nullable = false)
    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    @Column(name = "is_furnished", nullable = false)
    public boolean isFurnished() {
        return Furnished;
    }

    public void setFurnished(boolean furnished) {
        Furnished = furnished;
    }

    @Column(name = "has_refrigerator", nullable = false)
    public boolean isHasRefrigerator() {
        return hasRefrigerator;
    }

    public void setHasRefrigerator(boolean hasRefrigerator) {
        this.hasRefrigerator = hasRefrigerator;
    }

    @Column(name = "has_washing_machine", nullable = false)
    public boolean isHasWashingMachine() {
        return hasWashingMachine;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setHasWashingMachine(boolean hasWashingMachine) {
        this.hasWashingMachine = hasWashingMachine;
    }

    @Column(name = "more_info", columnDefinition = "text", nullable = false)
    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
