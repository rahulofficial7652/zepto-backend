package zepto.Zepto_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import zepto.Zepto_backend.dtos.InviteAdminRequestBody;
import zepto.Zepto_backend.model.User;
import zepto.Zepto_backend.utility.MappingUtility;

@Service
public class AdminService {
        @Autowired
        MappingUtility mappingUtility;

        @Autowired
        UserService userService;

        public void inviteAdmin(InviteAdminRequestBody inviteAdminRequestBody){
            User admin = mappingUtility.mapInviteAdminToUser(inviteAdminRequestBody);
            admin = userService.saveUser(admin);
    }
}
