package zepto.Zepto_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(unique = true, nullable = false)
    String productName;

    @Column(nullable = false)
    String manufacture;
    int quantity;
    int basePrice;
    String productImageLink;
}
