package zepto.Zepto_backend.dtos;


import lombok.Data;

import java.util.UUID;

@Data
public class WareHouseRequestBody {
    UUID wid;
    UUID pid;
    double basePrice;
    double discount;
    int totalQuantity;

}
