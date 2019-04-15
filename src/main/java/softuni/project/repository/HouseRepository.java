package softuni.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.domain.entities.House;

@Repository
public interface HouseRepository extends JpaRepository<House, String> {
}
