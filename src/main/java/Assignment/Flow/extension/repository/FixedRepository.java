package Assignment.Flow.extension.repository;

import Assignment.Flow.extension.entity.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedRepository extends JpaRepository<FixedExtension, Long> {

    FixedExtension findByExtension(String extension);
}
