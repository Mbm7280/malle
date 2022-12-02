package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProductCategory;
import com.echo.mall.modules.pms.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 产品分类 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api("PmsProductCategoryController")
@Tag(name = "PmsProductCategoryController",description = "产品属性参数管理")
@RestController
@RequestMapping("/pms/pmsProductCategory")
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    /*
     * @Author Echo
     * @Description 获取所有的产品分类
     * @Date 03:50 2022/12/3
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsProductCategory>>
     **/
    @ApiOperation("获取所有的产品分类")
    @GetMapping(value = "/queryAllProductCategory")
    @ResponseBody
    public ResultApi<List<PmsProductCategory>> queryAllProductCategory(){
        List<PmsProductCategory> pmsProductCategoryList = pmsProductCategoryService.list();
        return CollectionUtil.isEmpty(pmsProductCategoryList) ? ResultApi.failed() : ResultApi.success(pmsProductCategoryList);
    }

    /*
     * @Author Echo
     * @Description 分页获取所有的产品分类
     * @Date 03:51 2022/12/3
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsProductCategory>>
     **/
    @ApiOperation("分页获取所有的产品分类")
    @GetMapping(value = "/queryPageProductCategory")
    @ResponseBody
    public ResultApi<CommonPage<PmsProductCategory>> queryPageProductCategory(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        Page<PmsProductCategory> pmsProductCategoryPage = pmsProductCategoryService.queryPageProductCategory(pageNum,pageSize);
        return ResultApi.success(CommonPage.restPage(pmsProductCategoryPage));
    }



    /*
     * @Author Echo
     * @Description 根据Id获取指定的产品分类
     * @Date 03:55 2022/12/3
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProductCategory>
     **/
    @ApiOperation("根据Id获取指定的产品分类")
    @GetMapping(value = "/queryProductCategoryByID")
    @ResponseBody
    public ResultApi<PmsProductCategory> queryProductCategoryByID(@RequestParam(value = "id") Long id){
        PmsProductCategory pmsProductCategory = pmsProductCategoryService.getById(id);
        return ObjectUtil.isEmpty(pmsProductCategory) ? ResultApi.failed() : ResultApi.success(pmsProductCategory);
    }

    /*
     * @Author Echo
     * @Description 创建一个产品分类
     * @Date 03:56 2022/12/3
     * @Param [pmsProductCategory]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("创建一个产品分类")
    @PostMapping(value = "insertProductCategory")
    public ResultApi insertProductCategory(@RequestBody PmsProductCategory pmsProductCategory){
        return pmsProductCategoryService.save(pmsProductCategory) ? ResultApi.success(null) : ResultApi.failed();
    }


    /*
     * @Author Echo
     * @Description 根据ID修改产品分类
     * @Date 03:58 2022/12/3
     * @Param [pmsProductCategory]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品分类")
    @PutMapping(value = "updateProductCategoryByID")
    public ResultApi updateProductCategoryByID(@RequestBody PmsProductCategory pmsProductCategory) {
        return pmsProductCategoryService.updateById(pmsProductCategory) ? ResultApi.success(null) : ResultApi.failed();
    }


    /*
     * @Author Echo
     * @Description 根据ID删除产品分类
     * @Date 03:59 2022/12/3
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除产品分类")
    @PutMapping(value = "delProductCategoryByID")
    public ResultApi delProductCategoryByID(@RequestParam(value = "id") Long id) {
        return pmsProductCategoryService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

