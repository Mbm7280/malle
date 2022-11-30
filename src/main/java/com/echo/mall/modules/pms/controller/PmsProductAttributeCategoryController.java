package com.echo.mall.modules.pms.controller;


import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProductAttributeCategory;
import com.echo.mall.modules.pms.service.PmsProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api(value = "PmsProductAttributeCategoryController")
@Tag(name = "PmsProductAttributeCategoryController",description = "产品属性分类管理")
@RestController
@RequestMapping("/pms/pmsProductAttributeCategory")
public class PmsProductAttributeCategoryController {


    @Autowired
    private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;


    /*
     * @Author Echo
     * @Description 获取所有的产品属性分类
     * @Date 20:41 2022/11/30
     * @Param []
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("获取所有的产品属性分类")
    @GetMapping("/queryAllProductAttributeCategory")
    @ResponseBody
    public ResultApi<List<PmsProductAttributeCategory>> queryAllProductAttributeCategory() {
        return ResultApi.success(pmsProductAttributeCategoryService.list());
    }


    /*
     * @Author Echo
     * @Description 分页获取产品属性分类
     * @Date 20:42 2022/11/30
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsMemberPrice>>
     **/
    @ApiOperation("分页获取产品属性分类")
    @GetMapping("/queryPageProductAttributeCategory")
    @ResponseBody
    public ResultApi<CommonPage<PmsProductAttributeCategory>> queryPageProductAttributeCategory(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        return ResultApi.success(CommonPage.restPage(pmsProductAttributeCategoryService.queryPageProductAttributeCategory(pageNum,pageSize)));
    }

    /*
     * @Author Echo
     * @Description 根据ID查询产品属性分类
     * @Date 20:44 2022/11/30
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProductAttributeCategory>
     **/
    @ApiOperation("根据ID查询产品属性分类")
    @GetMapping("/queryProductAttributeCategoryByID")
    @ResponseBody
    public ResultApi<PmsProductAttributeCategory> queryProductAttributeCategoryByID (@RequestParam Long id) {
        PmsProductAttributeCategory pmsProductAttributeCategory = pmsProductAttributeCategoryService.getById(id);
        return ResultApi.success(pmsProductAttributeCategory);
    }

    /*
     * @Author Echo
     * @Description 新增一个产品属性分类
     * @Date 20:47 2022/11/30
     * @Param [pmsProductAttributeCategory]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("新增一个产品属性分类")
    @PostMapping("/insertProductAttributeCategory")
    public ResultApi insertProductAttributeCategory(@RequestBody PmsProductAttributeCategory pmsProductAttributeCategory) {
        return pmsProductAttributeCategoryService.save(pmsProductAttributeCategory) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改产品属性分类
     * @Date 20:49 2022/11/30
     * @Param [pmsProductAttributeCategory]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品属性分类")
    @PutMapping("/updateProductAttributeCategory")
    public ResultApi updateProductAttributeCategory (@RequestBody PmsProductAttributeCategory pmsProductAttributeCategory) {
        return pmsProductAttributeCategoryService.updateById(pmsProductAttributeCategory) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除一个产品属性分类
     * @Date 20:51 2022/11/30
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除一个产品属性分类")
    @DeleteMapping("/delProductAttributeCategory")
    public ResultApi delProductAttributeCategory (@RequestParam Long id) {
        return pmsProductAttributeCategoryService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }
}

