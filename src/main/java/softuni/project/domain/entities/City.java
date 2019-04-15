package softuni.project.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    private String cityName;

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    @Column(name = "city_name", nullable = false)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
