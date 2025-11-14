package zepto.Zepto_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zepto.Zepto_backend.model.WareHouseItem;

import java.util.UUID;

@Repository
public interface WareHouseItemRepository extends JpaRepository <WareHouseItem, UUID>{
}
