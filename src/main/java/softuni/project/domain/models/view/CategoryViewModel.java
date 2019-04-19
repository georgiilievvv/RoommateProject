package softuni.project.domain.models.view;

public class CategoryViewModel {

    private String id;
    private String cityName;

    public CategoryViewModel() {
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
