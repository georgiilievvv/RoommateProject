package softuni.project.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    private String name;

    public City() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
