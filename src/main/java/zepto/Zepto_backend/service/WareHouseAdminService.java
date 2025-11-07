package zepto.Zepto_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.dtos.InviteAdminRequestBody;
import zepto.Zepto_backend.enums.UserType;
import zepto.Zepto_backend.exceptions.UnAuthorizedExceprion;
import zepto.Zepto_backend.exceptions.UserNotFountException;
import zepto.Zepto_backend.model.User;
import zepto.Zepto_backend.utility.MappingUtility;

import java.util.UUID;

@Service
public class WareHouseAdminService {

    @Autowired
    MappingUtility mappingUtility;
    @Autowired
    UserService userService;
    public void inviteWareHouseAdmin(InviteAdminRequestBody adminRequestBody, UUID userId){
        User user = userService.getUserById(userId);
        if(user == null){
            throw new UserNotFountException(
                    String.format("User not found with id: %s", userId.toString()));
        }
        if(userService.isMaintUser(user) == false && userService.isAppAdmin(user) == false){
            throw new UnAuthorizedExceprion(
                    String.format("User with id %s is not allowed to perform invite-admin open", userId)
            );
        }
        User warehouseAdmin = mappingUtility.mapInviteAdminToUser(adminRequestBody, UserType.WAREHOUSE_ADMIN.toString());
        userService.saveUser(warehouseAdmin);

    }
}
