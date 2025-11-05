package zepto.Zepto_backend.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zepto.Zepto_backend.dtos.InviteAdminRequestBody;

@RestController
@RequestMapping("/api/vi/admin")
public class AdminController {

    @PostMapping("invite")
    public String inviteAdmin(@RequestBody InviteAdminRequestBody inviteAdminRequestBody) {
        return "User invited successfully";
    }
}
