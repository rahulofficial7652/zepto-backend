package zepto.Zepto_backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWareHouseRequestBody {
    String WareHouseEmail;
    Long wareHouseContactNumber;
    String addressLine1;
    String addressLine2;
    String addressLine3;
    String city;
    String email;
    String country;
    boolean isPrimary;
    String state;
    int pincode;
}
