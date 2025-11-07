package zepto.Zepto_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zepto.Zepto_backend.dtos.InviteAdminRequestBody;
import zepto.Zepto_backend.exceptions.UnAuthorizedExceprion;
import zepto.Zepto_backend.exceptions.UserNotFountException;
import zepto.Zepto_backend.service.AdminService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("invite")
    public ResponseEntity inviteAdmin(@RequestBody InviteAdminRequestBody inviteAdminRequestBody, @RequestParam UUID userId) {
        try{
            adminService.inviteAdmin(inviteAdminRequestBody, userId);
            return new ResponseEntity("Mail Sent Successfully", HttpStatus.CREATED);
        }catch (UserNotFountException e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (UnAuthorizedExceprion e){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("invite/accept/{userID}")
    public ResponseEntity acceptInvite(@PathVariable UUID userID){
        // here we call the admin service to accept the
        try{
            adminService.acceptInvite(userID);
            return new ResponseEntity("Invite Accepted Successfully", HttpStatus.OK);
        }catch (UserNotFountException e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
