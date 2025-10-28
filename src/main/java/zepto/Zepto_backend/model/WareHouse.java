package zepto.Zepto_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="warehouse")
public class WareHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @OneToOne
    Location  location;
    @OneToOne
    User warehouseAdmin;
    String email;
    Long contactNumber;
}
