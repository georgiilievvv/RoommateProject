package softuni.project.domain.models.service;

public class CityServiceModel extends BaseServiceModel{

    private String cityName;

    public CityServiceModel() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
