package zepto.Zepto_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zepto.Zepto_backend.dtos.ConsumerRequestBody;

@RestController
@RequestMapping("api/v1/consumer")
public class ConsumerController {

    @PostMapping("/create-account")
    public void registerConsumer(@RequestBody ConsumerRequestBody consumerRequestBody) {

    }
}
