package softuni.project.domain.models.binding;

import java.math.BigDecimal;

public class AccommodationAddBindingModel {

    private String owner;
    private String cityId;
    private	String address;
    private	Double quadrature;
    private BigDecimal rentPerMonth;
    private Integer numberOfParkingSpots;
    private boolean Indoor;
    private boolean Guarded;
    private Boolean hasCameras;
    private	Integer numberOfRooms;
    private	Integer numberOfBathrooms;
    private	Boolean hasTV;
    private	Boolean hasPet;
    private	Boolean hasWifi;
    private	Boolean isFurnished;
    private	Boolean hasRefrigerator;
    private	Boolean hasWashingMachine;
    private String imageUrl;
    private	String moreInfo;
    private Boolean hasDoorman;
    private Boolean hasElevator;
    private int floor;
    private Boolean hasYard;
    private double yardQuadrature;

    public AccommodationAddBindingModel() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
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

    public Integer getNumberOfParkingSpots() {
        return numberOfParkingSpots;
    }

    public void setNumberOfParkingSpots(Integer numberOfParkingSpots) {
        this.numberOfParkingSpots = numberOfParkingSpots;
    }

    public boolean getIndoor() {
        return Indoor;
    }

    public void setIndoor(boolean indoor) {
        Indoor = indoor;
    }

    public boolean getGuarded() {
        return Guarded;
    }

    public void setGuarded(boolean guarded) {
        Guarded = guarded;
    }

    public Boolean getHasCameras() {
        return hasCameras;
    }

    public void setHasCameras(Boolean hasCameras) {
        this.hasCameras = hasCameras;
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

    public Boolean getHasTV() {
        return hasTV;
    }

    public void setHasTV(Boolean hasTV) {
        this.hasTV = hasTV;
    }

    public Boolean getHasPet() {
        return hasPet;
    }

    public void setHasPet(Boolean hasPet) {
        this.hasPet = hasPet;
    }

    public Boolean getHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(Boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public Boolean getIsFurnished() {
        return isFurnished;
    }

    public void setIsFurnished(Boolean furnished) {
        isFurnished = furnished;
    }

    public Boolean getHasRefrigerator() {
        return hasRefrigerator;
    }

    public void setHasRefrigerator(Boolean hasRefrigerator) {
        this.hasRefrigerator = hasRefrigerator;
    }

    public Boolean getHasWashingMachine() {
        return hasWashingMachine;
    }

    public void setHasWashingMachine(Boolean hasWashingMachine) {
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

    public Boolean hasDoorman() {
        return hasDoorman;
    }

    public void setHasDoorman(Boolean hasDoorman) {
        this.hasDoorman = hasDoorman;
    }

    public Boolean getHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(Boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Boolean getHasYard() {
        return hasYard;
    }

    public void setHasYard(Boolean hasYard) {
        this.hasYard = hasYard;
    }

    public double getYardQuadrature() {
        return yardQuadrature;
    }

    public void setYardQuadrature(double yardQuadrature) {
        this.yardQuadrature = yardQuadrature;
    }
}
