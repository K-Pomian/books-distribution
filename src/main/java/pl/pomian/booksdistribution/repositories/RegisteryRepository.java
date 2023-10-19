package pl.pomian.booksdistribution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pomian.booksdistribution.repositories.entities.Registry;

@Repository
public interface RegisteryRepository extends JpaRepository<Registry, Long> {
}
