package zepto.Zepto_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zepto.Zepto_backend.model.Location;

import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {

}
