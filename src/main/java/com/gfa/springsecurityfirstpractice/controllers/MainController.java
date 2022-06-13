package com.gfa.springsecurityfirstpractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping(path = {"/", "/main"}, method = RequestMethod.GET)
    @ResponseBody
    public String greetStranger() {
        return "<h1>Hello Stranger!</h1>";
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String greetUser() {
        return "<h1>Hello User!</h1>";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    @ResponseBody
    public String greetAdmin() {
        return "<h1>Hello Admin!</h1>";
    }
}
