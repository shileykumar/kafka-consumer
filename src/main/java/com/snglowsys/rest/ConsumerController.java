package com.snglowsys.rest;

import com.snglowsys.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ConsumerController {

    private Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @StreamListener("input")
    @GetMapping("/consume")
    public void consumeEvent(Customer customer) {
        logger.info("Consume Payload : {}", customer);
        System.out.println(customer.getId()+" "+customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
    }
}
