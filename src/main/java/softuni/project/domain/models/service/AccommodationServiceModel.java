package softuni.project.domain.models.service;

import java.math.BigDecimal;
import java.util.List;

public class AccommodationServiceModel extends BaseServiceModel{

    private UserServiceModel owner;
    private CityServiceModel city;
    private	String address;
    private	Double quadrature;
    private BigDecimal rentPerMonth;
    private ParkingServiceModel parking;
    private String gender;
    private	Integer numberOfRooms;
    private	Integer numberOfBathrooms;
    private	boolean hasTV;
    private	boolean hasWifi;
    private	boolean Furnished;
    private	boolean hasRefrigerator;
    private	boolean hasWashingMachine;
    private String imageUrl;
    private	String moreInfo;
    private boolean hasDoorman;
    private boolean hasElevator;
    private int floor;
    private boolean hasYard;
    private Double yardQuadrature;
    private List<UserServiceModel> candidates;


    public AccommodationServiceModel() {
    }

    public UserServiceModel getOwner() {
        return owner;
    }

    public void setOwner(UserServiceModel owner) {
        this.owner = owner;
    }

    public CityServiceModel getCity() {
        return city;
    }

    public void setCity(CityServiceModel city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getQuadrature() {
        return quadrature;
    }

    public void setQuadrature(Double quadrature) {
        this.quadrature = quadrature;
    }

    public BigDecimal getRentPerMonth() {
        return rentPerMonth;
    }

    public void setRentPerMonth(BigDecimal rentPerMonth) {
        this.rentPerMonth = rentPerMonth;
    }

    public ParkingServiceModel getParking() {
        return parking;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setParking(ParkingServiceModel parking) {
        this.parking = parking;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public boolean hasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public boolean hasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean isFurnished() {
        return Furnished;
    }

    public void setFurnished(boolean furnished) {
        Furnished = furnished;
    }

    public boolean hasRefrigerator() {
        return hasRefrigerator;
    }

    public void setHasRefrigerator(boolean hasRefrigerator) {
        this.hasRefrigerator = hasRefrigerator;
    }

    public boolean hasWashingMachine() {
        return hasWashingMachine;
    }

    public void setHasWashingMachine(boolean hasWashingMachine) {
        this.hasWashingMachine = hasWashingMachine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public boolean hasDoorman() {
        return hasDoorman;
    }

    public void setHasDoorman(boolean hasDoorman) {
        this.hasDoorman = hasDoorman;
    }

    public boolean hasElevator() {
        return hasElevator;
    }

    public void setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean hasYard() {
        return hasYard;
    }

    public void setHasYard(boolean hasYard) {
        this.hasYard = hasYard;
    }

    public Double getYardQuadrature() {
        return yardQuadrature;
    }

    public void setYardQuadrature(Double yardQuadrature) {
        this.yardQuadrature = yardQuadrature;
    }

    public List<UserServiceModel> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<UserServiceModel> candidates) {
        this.candidates = candidates;
    }
}
