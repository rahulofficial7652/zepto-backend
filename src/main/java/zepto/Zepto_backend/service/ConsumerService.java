package zepto.Zepto_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.dtos.ConsumerRequestBody;
import zepto.Zepto_backend.model.User;
import zepto.Zepto_backend.repository.UserRepository;
import zepto.Zepto_backend.utility.MappingUtility;

@Service
public class ConsumerService {
    @Autowired
    MappingUtility mappingUtility;

    @Autowired
    UserRepository userRepository;

    public void createController(ConsumerRequestBody consumerRequestBody) {
        //from this consumer request body we should consumer model object
        // after creating consumer model object we will be saving it in user table
        // utility classes: these classes are the helper classes which is help for mapping the data
        User consumer = mappingUtility.mapToUser(consumerRequestBody);
        consumer = this.saveUser(consumer);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
