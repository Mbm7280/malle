package com.echo.mall.modules.pms.controller;


import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProductAttribute;
import com.echo.mall.modules.pms.service.PmsProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api(value = "PmsProductAttributeController")
@Tag(name = "PmsProductAttributeController",description = "商品属性管理")
@RestController
@RequestMapping("/pms/pmsProductAttribute")
public class PmsProductAttributeController {

    @Autowired
    private PmsProductAttributeService pmsProductAttributeService;

    /*
     * @Author Echo
     * @Description 获取所有的产品属性
     * @Date 22:22 2022/12/1
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsProductAttribute>>
     **/
    @ApiOperation("获取所有的产品属性")
    @GetMapping("/queryAllProductAttribute")
    @ResponseBody
    public ResultApi<List<PmsProductAttribute>> queryAllProductAttribute() {
        return ResultApi.success(pmsProductAttributeService.list());
    }

    /*
     * @Author Echo
     * @Description 分页获取产品属性
     * @Date 22:24 2022/12/1
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsProductAttribute>>
     **/
    @ApiOperation("分页获取产品属性")
    @GetMapping("/queryPageProductAttribute")
    @ResponseBody
    public ResultApi<CommonPage<PmsProductAttribute>> queryPageProductAttribute (
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        return ResultApi.success(CommonPage.restPage(pmsProductAttributeService.queryPageProductAttribute(pageNum,pageSize)));
    }


    /*
     * @Author Echo
     * @Description 根据ID查询产品属性
     * @Date 22:27 2022/12/1
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProductAttribute>
     **/
    @ApiOperation("根据ID查询产品属性")
    @GetMapping("/queryProductAttributeByID")
    @ResponseBody
    public ResultApi<PmsProductAttribute> queryProductAttributeByID (@RequestParam Long id) {
        PmsProductAttribute pmsProductAttribute = pmsProductAttributeService.getById(id);
        return ResultApi.success(pmsProductAttribute);
    }

    /*
     * @Author Echo
     * @Description 新增一个产品属性
     * @Date 22:28 2022/12/1
     * @Param [pmsProductAttribute]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("新增一个产品属性")
    @PostMapping("/insertProductAttribute")
    public ResultApi insertProductAttribute(@RequestBody PmsProductAttribute pmsProductAttribute) {
        return pmsProductAttributeService.save(pmsProductAttribute) ? ResultApi.success(null) : ResultApi.failed();
    }


    /*
     * @Author Echo
     * @Description 根据ID修改产品属性
     * @Date 22:29 2022/12/1
     * @Param [pmsProductAttribute]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品属性")
    @PutMapping("/updateProductAttribute")
    public ResultApi updateProductAttribute (@RequestBody PmsProductAttribute pmsProductAttribute) {
        return pmsProductAttributeService.updateById(pmsProductAttribute) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除一个产品属性
     * @Date 22:30 2022/12/1
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除一个产品属性")
    @DeleteMapping("/delProductAttribute")
    public ResultApi delProductAttribute (@RequestParam Long id) {
        return pmsProductAttributeService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

