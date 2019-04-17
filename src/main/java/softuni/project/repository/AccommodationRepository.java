package softuni.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.domain.entities.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, String> {
}
