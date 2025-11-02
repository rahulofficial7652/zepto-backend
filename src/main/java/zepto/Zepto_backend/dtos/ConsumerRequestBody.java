package zepto.Zepto_backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zepto.Zepto_backend.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerRequestBody {
  private User userName;
  private String addressLine1;
  private String addressLine2;
  private String addressLine3;
  private String city;
  private String country;
  private String email;
  private String password;
  private String phone;
  private boolean isPrimary;
  private String state;
  private int pincode;

}
