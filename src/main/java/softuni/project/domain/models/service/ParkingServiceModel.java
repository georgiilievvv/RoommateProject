package softuni.project.domain.models.service;

public class ParkingServiceModel extends BaseServiceModel{

    private Integer numberOfParkingSpots;
    private boolean Indoor;
    private boolean Guarded;
    private boolean hasCameras;

    public ParkingServiceModel() {
    }

    public Integer getNumberOfParkingSpots() {
        return numberOfParkingSpots;
    }

    public void setNumberOfParkingSpots(Integer numberOfParkingSpots) {
        this.numberOfParkingSpots = numberOfParkingSpots;
    }

    public boolean getIndoor() {
        return Indoor;
    }

    public void setIndoor(boolean indoor) {
        Indoor = indoor;
    }

    public boolean getGuarded() {
        return Guarded;
    }

    public void setGuarded(boolean guarded) {
        Guarded = guarded;
    }

    public boolean isHasCameras() {
        return hasCameras;
    }

    public void setHasCameras(boolean hasCameras) {
        this.hasCameras = hasCameras;
    }
}
