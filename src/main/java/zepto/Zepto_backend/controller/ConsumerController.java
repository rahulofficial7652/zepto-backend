package zepto.Zepto_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zepto.Zepto_backend.dtos.ConsumerRequestBody;
import zepto.Zepto_backend.service.ConsumerService;

@RestController
@RequestMapping("api/v1/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping("/create-account")
    public String registerConsumer(@RequestBody ConsumerRequestBody consumerRequestBody) {
        consumerService.createController(consumerRequestBody);
        return "Consumer created successfully";
    }
}
