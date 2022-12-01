package com.echo.mall.modules.echo.controller;


import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.echo.model.EchoTest;
import com.echo.mall.modules.echo.service.EchoTestService;
import com.echo.mall.modules.pms.model.PmsBrand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-12-01
 */
@RestController
@RequestMapping("/echo/echoTest")
@Api("EchoTestController")
@Tag(name = "EchoTestController",description = "EchoTest")
public class EchoTestController {


    @Autowired
    private EchoTestService echoTestService;

    @ApiOperation("根据Id获取指定的品牌")
    @GetMapping(value = "/queryByID")
    @ResponseBody
    public ResultApi<EchoTest> queryByID(@RequestParam(value = "id") Long id){
        EchoTest echoTest = echoTestService.getById(id);
        int i = echoTest.getCost().compareTo(BigDecimal.ZERO);
        System.out.println(i);
        if(i > 0) {
            System.out.println(1);
        }else {
            System.out.println(2);
        }
        return ResultApi.success(echoTest);
    }


}

