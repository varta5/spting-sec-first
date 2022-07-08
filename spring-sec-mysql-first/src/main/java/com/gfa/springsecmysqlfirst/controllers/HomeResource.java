package com.gfa.springsecmysqlfirst.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @RequestMapping(path = {"/", "/main"}, method = RequestMethod.GET)
    public String greetStranger() {
        return "Hello Stranger!";
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String greetUser() {
        return "Hello User!";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String greetAdmin() {
        return "Hello Admin!";
    }
}
