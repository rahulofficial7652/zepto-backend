package zepto.Zepto_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zepto.Zepto_backend.model.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
