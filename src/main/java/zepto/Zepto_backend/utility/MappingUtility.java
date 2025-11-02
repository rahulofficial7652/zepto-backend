package zepto.Zepto_backend.utility;

import org.springframework.stereotype.Component;
import zepto.Zepto_backend.dtos.ConsumerRequestBody;
import zepto.Zepto_backend.enums.UserType;
import zepto.Zepto_backend.model.User;

@Component
public class MappingUtility {
    public User mapToUser(ConsumerRequestBody consumerRequestBody){
        User user = new User();
        user.setUserType(UserType.CONSUMER.toString());
        user.setUserName(String.valueOf(consumerRequestBody.getUserName()));
        user.setEmail(consumerRequestBody.getEmail());
        user.setPhone(Long.valueOf(consumerRequestBody.getPhone()));
        user.setPassword(consumerRequestBody.getPassword());
        return user;
    }
}
