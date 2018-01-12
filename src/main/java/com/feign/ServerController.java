package com.feign;


import org.springframework.web.bind.annotation.*;

@RestController
public class ServerController {

    @RequestMapping(value = "/user",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public User getServerUser(){

        User  user =new User();

        user.setAge(50);
        user.setName("Fabio");

        return user;
    }

}
