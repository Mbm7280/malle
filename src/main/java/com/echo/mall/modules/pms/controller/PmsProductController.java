package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProduct;
import com.echo.mall.modules.pms.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api("PmsProductController")
@Tag(name = "PmsProductController",description = "商品信息管理")
@RestController
@RequestMapping("/pms/pmsProduct")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;

    /*
     * @Author Echo
     * @Description 获取所有的产品
     * @Date 20:42 2022/12/4
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsProduct>>
     **/
    @ApiOperation("获取所有的产品")
    @GetMapping(value = "/queryAllProduct")
    @ResponseBody
    public ResultApi<List<PmsProduct>> queryAllProductCategory(){
        List<PmsProduct> pmsProductList = pmsProductService.list();
        return CollectionUtil.isEmpty(pmsProductList) ? ResultApi.failed() : ResultApi.success(pmsProductList);
    }

    /*
     * @Author Echo
     * @Description 分页获取所有的产品
     * @Date 20:44 2022/12/4
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsProduct>>
     **/
    @ApiOperation("分页获取所有的产品")
    @GetMapping(value = "/queryPageProduct")
    @ResponseBody
    public ResultApi<CommonPage<PmsProduct>> queryPageProduct(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        Page<PmsProduct> pmsProductPage = pmsProductService.queryPageProduct(pageNum,pageSize);
        return ResultApi.success(CommonPage.restPage(pmsProductPage));
    }

    /*
     * @Author Echo
     * @Description 根据Id获取指定的产品
     * @Date 20:45 2022/12/4
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProduct>
     **/
    @ApiOperation("根据Id获取指定的产品")
    @GetMapping(value = "/queryProductByID")
    @ResponseBody
    public ResultApi<PmsProduct> queryProductByID(@RequestParam(value = "id") Long id){
        PmsProduct pmsProduct = pmsProductService.getById(id);
        return ObjectUtil.isEmpty(pmsProduct) ? ResultApi.failed() : ResultApi.success(pmsProduct);
    }

    /*
     * @Author Echo
     * @Description 创建一个产品
     * @Date 20:46 2022/12/4
     * @Param [pmsProduct]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("创建一个产品")
    @PostMapping(value = "insertProduct")
    public ResultApi insertProduct(@RequestBody PmsProduct pmsProduct){
        return pmsProductService.save(pmsProduct) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改产品
     * @Date 20:46 2022/12/4
     * @Param [pmsProduct]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品")
    @PutMapping(value = "updateProductByID")
    public ResultApi updateProductByID(@RequestBody PmsProduct pmsProduct) {
        return pmsProductService.updateById(pmsProduct) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除产品
     * @Date 20:47 2022/12/4
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除产品")
    @PutMapping(value = "delProductByID")
    public ResultApi delProductByID(@RequestParam(value = "id") Long id) {
        return pmsProductService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

