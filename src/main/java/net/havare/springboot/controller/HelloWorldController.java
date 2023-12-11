package net.havare.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller => to make a java class as a spring mvc controller
// @ResponseBody => tells a controller that the object returned is
// automatically serialized into json and passed back into the
// httpresponse object
// @Controller + @ResponseBody = @RestController

@RestController
public class HelloWorldController {

    // http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
