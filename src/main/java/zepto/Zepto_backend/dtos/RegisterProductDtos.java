package zepto.Zepto_backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterProductDtos {
    private String productName;
    private String manufacture;
    private int quantity;
    private int basePrice;
    private String productImageLink;
}
