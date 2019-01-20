package com.qad.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "hello-bean")
    public HelloBean HelloWorldBean() {
        return new HelloBean("Hello World Bean");
    }


    @GetMapping(path = "hello-world/{name}")
    public HelloBean HelloWorldPath(@PathVariable String name) {
        return new HelloBean(String.format("Hello, %s", name));
    }
}
