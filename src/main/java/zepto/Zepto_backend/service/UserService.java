package zepto.Zepto_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.enums.UserType;
import zepto.Zepto_backend.model.User;
import zepto.Zepto_backend.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User saveUser(User user){
        return this.userRepository.save(user);

    }
    public User getUserById(UUID userId){
        return this.userRepository.findById(userId).orElse(null);
    }
    public boolean isMaintUser(User user){
        return user.getUserType().equals(UserType.MAINT.toString());
    }
    public void updateUser(User user){userRepository.save(user);}
    public boolean isAppAdmin(User user){
        return user.getUserType().equals((UserType.ZEPTO_APP_ADMIN).toString());

    }
}
