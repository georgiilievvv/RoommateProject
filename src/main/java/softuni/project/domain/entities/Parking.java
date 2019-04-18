package softuni.project.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parking")
public class Parking extends BaseEntity{

    private Integer numberOfParkingSpots;
    private boolean indoor;
    private boolean guarded;
    private boolean hasCameras;

    public Parking() {
    }

    @Column(name = "number_of_parking_spots")
    public Integer getNumberOfParkingSpots() {
        return numberOfParkingSpots;
    }

    public void setNumberOfParkingSpots(Integer numberOfParkingSpots) {
        this.numberOfParkingSpots = numberOfParkingSpots;
    }

    @Column(name = "is_indoor")
    public boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    @Column(name = "is_guarded")
    public boolean getGuarded() {
        return guarded;
    }

    public void setGuarded(boolean guarded) {
        this.guarded = guarded;
    }

    @Column(name = "has_cameras")
    public boolean isHasCameras() {
        return hasCameras;
    }

    public void setHasCameras(boolean hasCameras) {
        this.hasCameras = hasCameras;
    }
}
