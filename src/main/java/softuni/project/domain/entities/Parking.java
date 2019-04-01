package softuni.project.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parking")
public class Parking extends BaseEntity{

    private Integer numberOfParkingSpots;
    private boolean isIndoor;
    private boolean isGuarded;
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
    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }

    @Column(name = "is_guarded")
    public boolean isGuarded() {
        return isGuarded;
    }

    public void setGuarded(boolean guarded) {
        isGuarded = guarded;
    }

    @Column(name = "has_cameras")
    public boolean isHasCameras() {
        return hasCameras;
    }

    public void setHasCameras(boolean hasCameras) {
        this.hasCameras = hasCameras;
    }
}
