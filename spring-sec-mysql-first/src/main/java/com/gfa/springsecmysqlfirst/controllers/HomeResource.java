package com.gfa.springsecmysqlfirst.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @RequestMapping(path = {"/", "/main"}, method = RequestMethod.GET)
    public String greetStranger() {
        return "<h1>Hello Stranger!</h2>";
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String greetUser() {
        return "<h1>Hello User!</h2>";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String greetAdmin() {
        return "<h1>Hello Admin!</h2>";
    }
}
