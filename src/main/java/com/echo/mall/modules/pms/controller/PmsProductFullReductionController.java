package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProductFullReduction;
import com.echo.mall.modules.pms.service.PmsProductFullReductionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 产品满减表(只针对同商品) 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api("PmsProductFullReductionController")
@Tag(name = "PmsProductFullReductionController",description = "产品满减信息管理")
@RestController
@RequestMapping("/pms/pmsProductFullReduction")
public class PmsProductFullReductionController {
    
    @Autowired
    private PmsProductFullReductionService pmsProductFullReductionService;


    /*
     * @Author Echo
     * @Description 获取所有的产品满减信息
     * @Date 16:01 2022/12/5
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsProductFullReduction>>
     **/
    @ApiOperation("获取所有的产品满减信息")
    @GetMapping(value = "/queryAllProductFullReduction")
    @ResponseBody
    public ResultApi<List<PmsProductFullReduction>> queryAllProductFullReduction(){
        List<PmsProductFullReduction> pmsProductFullReductionList = pmsProductFullReductionService.list();
        return CollectionUtil.isEmpty(pmsProductFullReductionList) ? ResultApi.failed() : ResultApi.success(pmsProductFullReductionList);
    }


    /*
     * @Author Echo
     * @Description 分页获取所有的产品满减信息
     * @Date 16:06 2022/12/5
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsProductFullReduction>>
     **/
    @ApiOperation("分页获取所有的产品满减信息")
    @GetMapping(value = "/queryPageProductFullReduction")
    @ResponseBody
    public ResultApi<CommonPage<PmsProductFullReduction>> queryPageProductFullReduction(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        Page<PmsProductFullReduction> pmsProductFullReductionPage = pmsProductFullReductionService.queryPageProductFullReduction(pageNum,pageSize);
        return ResultApi.success(CommonPage.restPage(pmsProductFullReductionPage));
    }

    /*
     * @Author Echo
     * @Description 根据Id获取指定的产品满减信息
     * @Date 16:07 2022/12/5
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProductFullReduction>
     **/
    @ApiOperation("根据Id获取指定的产品满减信息")
    @GetMapping(value = "/queryProductFullReductionByID")
    @ResponseBody
    public ResultApi<PmsProductFullReduction> queryProductFullReductionByID(@RequestParam(value = "id") Long id){
        PmsProductFullReduction pmsProductFullReduction = pmsProductFullReductionService.getById(id);
        return ObjectUtil.isEmpty(pmsProductFullReduction) ? ResultApi.failed() : ResultApi.success(pmsProductFullReduction);
    }

    /*
     * @Author Echo
     * @Description 创建一个产品满减信息
     * @Date 16:07 2022/12/5
     * @Param [pmsProductFullReduction]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("创建一个产品满减信息")
    @PostMapping(value = "insertProductFullReduction")
    public ResultApi insertProductFullReduction(@RequestBody PmsProductFullReduction pmsProductFullReduction){
        return pmsProductFullReductionService.save(pmsProductFullReduction) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改产品满减信息
     * @Date 16:07 2022/12/5
     * @Param [pmsProductFullReduction]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品满减信息")
    @PutMapping(value = "updateProductFullReductionByID")
    public ResultApi updateProductFullReductionByID(@RequestBody PmsProductFullReduction pmsProductFullReduction) {
        return pmsProductFullReductionService.updateById(pmsProductFullReduction) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除产品满减信息
     * @Date 16:08 2022/12/5
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除产品满减信息")
    @PutMapping(value = "delProductFullReductionByID")
    public ResultApi delProductFullReductionByID(@RequestParam(value = "id") Long id) {
        return pmsProductFullReductionService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }
    

}

