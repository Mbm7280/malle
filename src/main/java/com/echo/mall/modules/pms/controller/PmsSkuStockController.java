package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsSkuStock;
import com.echo.mall.modules.pms.service.PmsSkuStockService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * sku的库存 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@RestController
@RequestMapping("/pms/pmsSkuStock")
public class PmsSkuStockController {
    
    @Autowired
    private PmsSkuStockService pmsSkuStockService;


    /*
     * @Author Echo
     * @Description 获取所有的产品库存
     * @Date 17:25 2022/12/10
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsSkuStock>>
     **/
    @ApiOperation("获取所有的产品库存")
    @GetMapping(value = "/queryAllProductSkuStock")
    @ResponseBody
    public ResultApi<List<PmsSkuStock>> queryAllProductSkuStock(){
        List<PmsSkuStock> pmsProductSkuStockList = pmsSkuStockService.list();
        return CollectionUtil.isEmpty(pmsProductSkuStockList) ? ResultApi.failed() : ResultApi.success(pmsProductSkuStockList);
    }


    @ApiOperation("分页获取所有的产品库存")
    @GetMapping(value = "/queryPageProductSkuStock")
    @ResponseBody
    public ResultApi<CommonPage<PmsSkuStock>> queryPageProductSkuStock(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        Page<PmsSkuStock> pmsProductSkuStockPage = pmsSkuStockService.queryPageProductSkuStock(pageNum,pageSize);
        return ResultApi.success(CommonPage.restPage(pmsProductSkuStockPage));
    }

    /*
     * @Author Echo
     * @Description 根据Id获取指定的产品库存
     * @Date 17:25 2022/12/10
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsSkuStock>
     **/
    @ApiOperation("根据Id获取指定的产品库存")
    @GetMapping(value = "/queryProductSkuStockByID")
    @ResponseBody
    public ResultApi<PmsSkuStock> queryProductSkuStockByID(@RequestParam(value = "id") Long id){
        PmsSkuStock pmsProductSkuStock = pmsSkuStockService.getById(id);
        return ObjectUtil.isEmpty(pmsProductSkuStock) ? ResultApi.failed() : ResultApi.success(pmsProductSkuStock);
    }

    /*
     * @Author Echo
     * @Description 创建一个产品库存
     * @Date 17:26 2022/12/10
     * @Param [pmsProductSkuStock]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("创建一个产品库存")
    @PostMapping(value = "insertProductSkuStock")
    public ResultApi insertProductSkuStock(@RequestBody PmsSkuStock pmsProductSkuStock){
        return pmsSkuStockService.save(pmsProductSkuStock) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改产品库存
     * @Date 17:26 2022/12/10
     * @Param [pmsProductSkuStock]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品库存")
    @PutMapping(value = "updateProductSkuStockByID")
    public ResultApi updateProductSkuStockByID(@RequestBody PmsSkuStock pmsProductSkuStock) {
        return pmsSkuStockService.updateById(pmsProductSkuStock) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除产品库存
     * @Date 17:26 2022/12/10
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除产品库存")
    @PutMapping(value = "delProductSkuStockByID")
    public ResultApi delProductSkuStockByID(@RequestParam(value = "id") Long id) {
        return pmsSkuStockService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

