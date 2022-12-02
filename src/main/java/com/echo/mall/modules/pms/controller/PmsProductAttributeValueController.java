package com.echo.mall.modules.pms.controller;


import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProductAttributeValue;
import com.echo.mall.modules.pms.service.PmsProductAttributeValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 存储产品参数信息的表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api("PmsProductAttributeValueController")
@Tag(name = "PmsProductAttributeValueController",description = "产品属性参数管理")
@RestController
@RequestMapping("/pms/pmsProductAttributeValue")
public class PmsProductAttributeValueController {
    
    @Autowired
    private PmsProductAttributeValueService pmsProductAttributeValueService;

    /*
     * @Author Echo
     * @Description 获取所有的产品属性参数
     * @Date 21:58 2022/12/2
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsProductAttributeValue>>
     **/
    @ApiOperation("获取所有的产品属性参数")
    @GetMapping("/queryAllProductAttributeValue")
    @ResponseBody
    public ResultApi<List<PmsProductAttributeValue>> queryAllProductAttributeValue() {
        return ResultApi.success(pmsProductAttributeValueService.list());
    }

    /*
     * @Author Echo
     * @Description 分页获取产品属性参数
     * @Date 21:59 2022/12/2
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsProductAttributeValue>>
     **/
    @ApiOperation("分页获取产品属性参数")
    @GetMapping("/queryPageProductAttributeValue")
    @ResponseBody
    public ResultApi<CommonPage<PmsProductAttributeValue>> queryPageProductAttributeValue (
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        return ResultApi.success(CommonPage.restPage(pmsProductAttributeValueService.queryPageProductAttributeValue(pageNum,pageSize)));
    }


    /*
     * @Author Echo
     * @Description 根据ID查询产品属性参数
     * @Date 21:59 2022/12/2
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProductAttributeValue>
     **/
    @ApiOperation("根据ID查询产品属性参数")
    @GetMapping("/queryProductAttributeValueByID")
    @ResponseBody
    public ResultApi<PmsProductAttributeValue> queryProductAttributeValueByID (@RequestParam Long id) {
        PmsProductAttributeValue pmsProductAttribute = pmsProductAttributeValueService.getById(id);
        return ResultApi.success(pmsProductAttribute);
    }

    /*
     * @Author Echo
     * @Description 新增一个产品属性参数
     * @Date 22:00 2022/12/2
     * @Param [pmsProductAttribute]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("新增一个产品属性参数")
    @PostMapping("/insertProductAttributeValue")
    public ResultApi insertProductAttributeValue(@RequestBody PmsProductAttributeValue pmsProductAttributeValue) {
        return pmsProductAttributeValueService.save(pmsProductAttributeValue) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改产品属性参数
     * @Date 22:00 2022/12/2
     * @Param [pmsProductAttribute]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品属性参数")
    @PutMapping("/updateProductAttributeValue")
    public ResultApi updateProductAttributeValue (@RequestBody PmsProductAttributeValue pmsProductAttributeValue) {
        return pmsProductAttributeValueService.updateById(pmsProductAttributeValue) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除一个产品属性参数
     * @Date 22:01 2022/12/2
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除一个产品属性参数")
    @DeleteMapping("/delProductAttributeValue")
    public ResultApi delProductAttributeValue (@RequestParam Long id) {
        return pmsProductAttributeValueService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

