package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProductLadder;
import com.echo.mall.modules.pms.service.PmsProductLadderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */

@Api("PmsProductLadderController")
@Tag(name = "PmsProductLadderController",description = "产品阶梯价格管理")
@RestController
@RequestMapping("/pms/pmsProductLadder")
public class PmsProductLadderController {

    @Autowired
    private PmsProductLadderService pmsProductLadderService;


    /*
     * @Author Echo
     * @Description 获取所有的产品阶梯
     * @Date 19:09 2022/12/6
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsProductLadder>>
     **/
    @ApiOperation("获取所有的产品阶梯")
    @GetMapping(value = "/queryAllProductLadder")
    @ResponseBody
    public ResultApi<List<PmsProductLadder>> queryAllProductLadder(){
        List<PmsProductLadder> pmsProductLadderList = pmsProductLadderService.list();
        return CollectionUtil.isEmpty(pmsProductLadderList) ? ResultApi.failed() : ResultApi.success(pmsProductLadderList);
    }

    /*
     * @Author Echo
     * @Description 分页获取所有的产品阶梯
     * @Date 19:12 2022/12/6
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsProductLadder>>
     **/
    @ApiOperation("分页获取所有的产品阶梯")
    @GetMapping(value = "/queryPageProductLadder")
    @ResponseBody
    public ResultApi<CommonPage<PmsProductLadder>> queryPageProductLadder(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        Page<PmsProductLadder> pmsProductLadderPage = pmsProductLadderService.queryPageProductLadder(pageNum,pageSize);
        return ResultApi.success(CommonPage.restPage(pmsProductLadderPage));
    }

    /*
     * @Author Echo
     * @Description 根据Id获取指定的产品阶梯
     * @Date 19:14 2022/12/6
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProductLadder>
     **/
    @ApiOperation("根据Id获取指定的产品阶梯")
    @GetMapping(value = "/queryProductLadderByID")
    @ResponseBody
    public ResultApi<PmsProductLadder> queryProductLadderByID(@RequestParam(value = "id") Long id){
        PmsProductLadder pmsProductLadder = pmsProductLadderService.getById(id);
        return ObjectUtil.isEmpty(pmsProductLadder) ? ResultApi.failed() : ResultApi.success(pmsProductLadder);
    }

    /*
     * @Author Echo
     * @Description 创建一个产品阶梯
     * @Date 19:15 2022/12/6
     * @Param [pmsProductLadder]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("创建一个产品阶梯")
    @PostMapping(value = "insertProductLadder")
    public ResultApi insertProduct(@RequestBody PmsProductLadder pmsProductLadder){
        return pmsProductLadderService.save(pmsProductLadder) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改产品阶梯
     * @Date 19:15 2022/12/6
     * @Param [pmsProductLadder]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品阶梯")
    @PutMapping(value = "updateProductLadderByID")
    public ResultApi updateProductByID(@RequestBody PmsProductLadder pmsProductLadder) {
        return pmsProductLadderService.updateById(pmsProductLadder) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除产品阶梯
     * @Date 19:16 2022/12/6
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除产品阶梯")
    @PutMapping(value = "delProductLadderByID")
    public ResultApi delProductByID(@RequestParam(value = "id") Long id) {
        return pmsProductLadderService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

