package zepto.Zepto_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zepto.Zepto_backend.dtos.InviteAdminRequestBody;
import zepto.Zepto_backend.exceptions.UnAuthorizedExceprion;
import zepto.Zepto_backend.exceptions.UserNotFountException;
import zepto.Zepto_backend.service.WareHouseAdminService;

import java.util.UUID;


@RestController
@RequestMapping("api/v1/warehouse-admin")
public class WareHouseAdminController {

    @Autowired
    WareHouseAdminService wareHouseAdminService;

    @PostMapping("invite")
    public ResponseEntity inviteWareHouseAdmin(@RequestBody InviteAdminRequestBody inviteAdminRequestBody, @RequestParam UUID userId) {

        try {
            wareHouseAdminService.inviteWareHouseAdmin(inviteAdminRequestBody, userId);
            return new ResponseEntity("Mail Sent Successfully", HttpStatus.CREATED);
        } catch (UserNotFountException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (
                UnAuthorizedExceprion e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
