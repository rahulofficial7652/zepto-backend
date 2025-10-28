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
@Table(name="location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    //@JoinColumn(name="user_id")
    User user;
   String addressLine1;
   String addressLine2;
   String addressLine3;
   String city;
   String country;
   String state;
   int pincode;


}
