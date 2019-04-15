package softuni.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.domain.entities.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, String> {
}
