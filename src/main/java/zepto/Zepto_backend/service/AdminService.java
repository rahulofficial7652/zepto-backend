package zepto.Zepto_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.dtos.InviteAdminRequestBody;
import zepto.Zepto_backend.enums.UserStatues;
import zepto.Zepto_backend.enums.UserType;
import zepto.Zepto_backend.exceptions.UnAuthorizedExceprion;
import zepto.Zepto_backend.exceptions.UserNotFountException;
import zepto.Zepto_backend.model.User;
import zepto.Zepto_backend.utility.MappingUtility;
import java.util.UUID;


@Service
public class AdminService {
    @Autowired
    MappingUtility mappingUtility;

    @Autowired
    UserService userService;

    @Autowired
    MailService mailService;

    public void inviteAdmin(InviteAdminRequestBody inviteAdminRequestBody, UUID userId) {


        User maintUser = userService.getUserById(userId);
        if (maintUser == null) {
            throw new UserNotFountException(
                    String.format("User not found with id: %s", userId.toString()));
        }
        if (!userService.isMaintUser(maintUser)) {
            throw new UnAuthorizedExceprion(
                    String.format("User with id %s is not allowed to perform invite-admin open", userId)
            );
        }

        User admin = mappingUtility.mapInviteAdminToUser(inviteAdminRequestBody, UserType.ZEPTO_APP_ADMIN.toString());
        admin = userService.saveUser(admin);

        mailService.sendMailToInviteAdmin(admin, maintUser.getUserName(), UserType.ZEPTO_APP_ADMIN.toString());
    }

    public void acceptInvite(UUID userID) {
        User user = userService.getUserById(userID);
        if (user == null) {
            throw new UserNotFountException(
                    String.format("User not found with id: %s", userID.toString()));
        }
        if (!userService.isMaintUser(user)) {
            throw new UserNotFountException(
                    String.format("User with id %s is not allowed to perform invite-admin open", userID)
            );
        }
        user.setStatus(UserStatues.ACTIVE.toString());
        userService.saveUser(user);
    }
}
