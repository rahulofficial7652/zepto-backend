package zepto.Zepto_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String userType;
    private String status;



}
