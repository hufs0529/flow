package Assignment.Flow.extension.repository;

import Assignment.Flow.extension.entity.CustomExtension;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomRepository extends JpaRepository<CustomExtension, Long> {

    @Transactional
    @Modifying
    @Query("delete from CustomExtension c where c.extension = ?1")
    int deleteByExtension(String extension);

    Optional<CustomExtension> findByExtension(String extension);

    long count();
}
