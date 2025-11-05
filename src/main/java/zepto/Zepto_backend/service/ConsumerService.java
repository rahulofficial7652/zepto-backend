package zepto.Zepto_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zepto.Zepto_backend.dtos.ConsumerRequestBody;
import zepto.Zepto_backend.model.Location;
import zepto.Zepto_backend.model.User;
import zepto.Zepto_backend.repository.UserRepository;
import zepto.Zepto_backend.utility.MappingUtility;

import java.time.LocalDate;

@Service
public class ConsumerService {
    @Autowired
    MappingUtility mappingUtility;

    @Autowired
    UserService userService;
    @Autowired
    LocationService locationService;

    public void createController(ConsumerRequestBody consumerRequestBody) {
        //from this consumer request body we should consumer model object
        // after creating consumer model object we will be saving it in user table
        // utility classes: these classes are the helper classes which is help for mapping the data
        User consumer = mappingUtility.mapToUser(consumerRequestBody);
        consumer = userService.saveUser(consumer);

        Location location = mappingUtility.mapConsumerRBToLocation(consumerRequestBody, consumer);
        locationService.saveLocation(location);
    }

}
