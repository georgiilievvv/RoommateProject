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
    private boolean hasCameras;
    private	Integer numberOfRooms;
    private	Integer numberOfBathrooms;
    private	boolean hasTV;
    private	boolean hasPet;
    private	boolean hasWifi;
    private	boolean isFurnished;
    private	boolean hasRefrigerator;
    private	boolean hasWashingMachine;
    private String imageUrl;
    private	String moreInfo;
    private boolean hasDoorman;
    private boolean hasElevator;
    private int floor;
    private boolean hasYard;
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

    public boolean getHasCameras() {
        return hasCameras;
    }

    public void setHasCameras(boolean hasCameras) {
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

    public boolean getHasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public boolean getHasPet() {
        return hasPet;
    }

    public void setHasPet(boolean hasPet) {
        this.hasPet = hasPet;
    }

    public boolean getHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean getIsFurnished() {
        return isFurnished;
    }

    public void setIsFurnished(boolean furnished) {
        isFurnished = furnished;
    }

    public boolean getHasRefrigerator() {
        return hasRefrigerator;
    }

    public void setHasRefrigerator(boolean hasRefrigerator) {
        this.hasRefrigerator = hasRefrigerator;
    }

    public boolean getHasWashingMachine() {
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

    public boolean getHasElevator() {
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

    public boolean getHasYard() {
        return hasYard;
    }

    public void setHasYard(boolean hasYard) {
        this.hasYard = hasYard;
    }

    public double getYardQuadrature() {
        return yardQuadrature;
    }

    public void setYardQuadrature(double yardQuadrature) {
        this.yardQuadrature = yardQuadrature;
    }
}
