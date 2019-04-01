package softuni.project.domain.models.service;

public class ParkingServiceModel extends BaseServiceModel{

    private Integer numberOfParkingSpots;
    private boolean isIndoor;
    private boolean isGuarded;
    private boolean hasCameras;

    public ParkingServiceModel() {
    }

    public Integer getNumberOfParkingSpots() {
        return numberOfParkingSpots;
    }

    public void setNumberOfParkingSpots(Integer numberOfParkingSpots) {
        this.numberOfParkingSpots = numberOfParkingSpots;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }

    public boolean isGuarded() {
        return isGuarded;
    }

    public void setGuarded(boolean guarded) {
        isGuarded = guarded;
    }

    public boolean isHasCameras() {
        return hasCameras;
    }

    public void setHasCameras(boolean hasCameras) {
        this.hasCameras = hasCameras;
    }
}
