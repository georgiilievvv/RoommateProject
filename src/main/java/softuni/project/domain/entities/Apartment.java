package softuni.project.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "apartments")
public class Apartment extends Accommodation {

    private boolean hasDoorman;
    private boolean hasElevator;
    private int floor;

    public Apartment() {
    }

    @Column(name = "has_doorman", nullable = false)
    public boolean hasDoorman() {
        return hasDoorman;
    }

    public void setHasDoorman(boolean hasDoorman) {
        this.hasDoorman = hasDoorman;
    }

    @Column(name = "has_elevator", nullable = false)
    public boolean hasElevator() {
        return hasElevator;
    }

    public void setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    @Column(name = "floor", nullable = false)
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
