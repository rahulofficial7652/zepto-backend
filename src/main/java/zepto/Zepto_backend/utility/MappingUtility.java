package zepto.Zepto_backend.utility;

import org.springframework.stereotype.Component;
import zepto.Zepto_backend.dtos.ConsumerRequestBody;
import zepto.Zepto_backend.dtos.InviteAdminRequestBody;
import zepto.Zepto_backend.enums.UserStatues;
import zepto.Zepto_backend.enums.UserType;
import zepto.Zepto_backend.model.Location;
import zepto.Zepto_backend.model.User;

@Component
public class MappingUtility {
    public User mapToUser(ConsumerRequestBody consumerRequestBody){
        User user = new User();
        user.setUserType(UserType.CONSUMER.toString());
        user.setUserName(String.valueOf(consumerRequestBody.getUserName()));
        user.setEmail(consumerRequestBody.getEmail());
        user.setPhone((consumerRequestBody.getPhone()));
        user.setPassword(consumerRequestBody.getPassword());
        user.setStatus(UserStatues.ACTIVE.toString());
        return user;
    }
    public Location mapConsumerRBToLocation(ConsumerRequestBody consumerRequestBody, User user){
        Location location = new Location();
        location.setCity(consumerRequestBody.getCity());
        location.setCountry(consumerRequestBody.getCountry());
        location.setPrimary(consumerRequestBody.isPrimary());
        location.setUser(user);
        location.setAddressLine1(consumerRequestBody.getAddressLine1());
        location.setAddressLine2(consumerRequestBody.getAddressLine2());
        location.setAddressLine3(consumerRequestBody.getAddressLine3());
        location.setPincode(consumerRequestBody.getPincode());
        location.setState(consumerRequestBody.getState());
        return location;

    }
    public User mapInviteAdminToUser(InviteAdminRequestBody inviteAdminRequestBody, String userType){
        User user = new User();
        user.setStatus(UserStatues.INACTIVE.toString());
        if(userType.equals(UserType.WAREHOUSE_ADMIN)){
            user.setUserType(UserType.WAREHOUSE_ADMIN.toString());
        }else{
            user.setUserType(UserType.ZEPTO_APP_ADMIN.toString());
        }
        user.setUserType(UserType.ZEPTO_APP_ADMIN.toString());
        user.setUserName(inviteAdminRequestBody.getUserName());
        user.setEmail(inviteAdminRequestBody.getEmail());
        user.setPassword("TempPass123");
        user.setPhone(inviteAdminRequestBody.getPhone());
        return user;
    }
}
