package softuni.project.domain.models.binding;

public class CityBindingModel {

    private String id;
    private String cityName;

    public CityBindingModel() {
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
}
