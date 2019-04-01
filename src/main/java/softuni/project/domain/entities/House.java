package softuni.project.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "houses")
public class House extends Accommodation {

    private boolean hasYard;
    private Double yardQuadrature;
    private List<Guest> candidates;

    public House() {
    }

    @Column(name = "has_yard")
    public boolean isHasYard() {
        return hasYard;
    }

    public void setHasYard(boolean hasYard) {
        this.hasYard = hasYard;
    }

    @Column(name = "yard_quadrature")
    public Double getYardQuadrature() {
        return yardQuadrature;
    }

    public void setYardQuadrature(Double yardQuadrature) {
        this.yardQuadrature = yardQuadrature;
    }

    @ManyToMany
    public List<Guest> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Guest> candidates) {
        this.candidates = candidates;
    }
}
