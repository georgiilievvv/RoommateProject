package softuni.project.domain.models.view;

import java.math.BigDecimal;

public class AccommodationViewModel {

    private String id;
    private String cityName;
    private BigDecimal rentPerMonth;
    private String parking;
    private String address;
    private Integer numberOfRooms;
    private Double quadrature;
    private String type;

    public AccommodationViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public BigDecimal getRentPerMonth() {
        return rentPerMonth;
    }

    public void setRentPerMonth(BigDecimal rentPerMonth) {
        this.rentPerMonth = rentPerMonth;
    }

    public String getAddress() {
        if (address.length() > 20){
            return address.substring(0,20) + "...";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Double getQuadrature() {
        return quadrature;
    }

    public void setQuadrature(Double quadrature) {
        this.quadrature = quadrature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
