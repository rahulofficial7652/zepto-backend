package zepto.Zepto_backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    LocalDateTime orderPlaceTime;
    String paymentMethod;

    @ManyToOne
    User consumer;

    @ManyToOne
    WareHouse wareHouse;

}
