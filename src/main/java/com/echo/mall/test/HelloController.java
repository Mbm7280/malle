package com.echo.mall.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/say")
    public String sayBoot() {
        return "skywalking springboot hello!";
    }

    @GetMapping("/exception")
    public String exception() {
        int i = 1/0;
        return "hello exception";
    }

}
