package zepto.Zepto_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.model.User;
import zepto.Zepto_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User saveUser(User user){
        return this.userRepository.save(user);

    }
}
