package softuni.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.domain.entities.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {
}
