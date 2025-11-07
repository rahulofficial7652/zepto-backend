package zepto.Zepto_backend.configration;


import org.springframework.web.bind.annotation.*;
import zepto.Zepto_backend.dtos.InviteAdminRequestBody;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/warehouse-admin")
public class WareHouseAdminController {

    @PostMapping ("invite")
    public void inviteWareHouseAdmin(@RequestBody InviteAdminRequestBody inviteAdminRequestBody, @RequestParam UUID userId){


        }
}
