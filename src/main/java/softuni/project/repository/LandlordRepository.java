package softuni.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.domain.entities.Landlord;

import java.util.Optional;


@Repository
public interface LandlordRepository extends JpaRepository<Landlord, String> {

    Optional<Landlord> findByUsername(String username);
}
