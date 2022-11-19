package com.echo.mall.modules.ums.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "HelloController")
@Tag(name = "HelloController",description = "测试")
@RequestMapping("/test")
public class HelloController {

    Logger LOG =  LoggerFactory.getLogger(HelloController.class);
    @ApiOperation("添加后台资源分类")
    @GetMapping("/say")
    public String sayBoot() {
        LOG.debug("debug hello");
        LOG.info("info hello");
        LOG.warn("warning hello");
        LOG.error("error hello");
        return "skywalking springboot hello!";
    }

    @ApiOperation("添加后台资源分类")
    @GetMapping("/exception")
    public String exception() {
        int i = 1/0;
        return "hello exception";
    }

}
