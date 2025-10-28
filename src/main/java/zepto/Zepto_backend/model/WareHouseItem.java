package zepto.Zepto_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="warehouseItems")
public class WareHouseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    UUID wid;
    UUID pid;
    double basePrice;
    double discount;
    int totalQuantity;

    List<WareHouseItem> wareHouseItems;

}
