package com.feign;


import feign.Feign;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @RequestMapping(value = "/clientUser",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public User getUser(){

        RemoteService service = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(RemoteService.class, "http://127.0.0.1:5188");


        User user = service.getUser();

        return user;

    }

}
