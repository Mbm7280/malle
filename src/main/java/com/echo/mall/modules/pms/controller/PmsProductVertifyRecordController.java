package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProductVertifyRecord;
import com.echo.mall.modules.pms.service.PmsProductVertifyRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品审核记录 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api("PmsProductVertifyRecordController")
@Tag(name = "PmsProductVertifyRecordController",description = "产品审核日志")
@RestController
@RequestMapping("/pms/pmsProductVertifyRecord")
public class PmsProductVertifyRecordController {
    
    @Autowired
    private PmsProductVertifyRecordService pmsProductVertifyRecordService;


    /*
     * @Author Echo
     * @Description 获取所有的产品审核日志
     * @Date 23:10 2022/12/9
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsProductVertifyRecord>>
     **/
    @ApiOperation("获取所有的产品审核日志")
    @GetMapping(value = "/queryAllProductVertifyRecordLog")
    @ResponseBody
    public ResultApi<List<PmsProductVertifyRecord>> queryAllProductVertifyRecordLog(){
        List<PmsProductVertifyRecord> pmsProductVertifyRecordLogList = pmsProductVertifyRecordService.list();
        return CollectionUtil.isEmpty(pmsProductVertifyRecordLogList) ? ResultApi.failed() : ResultApi.success(pmsProductVertifyRecordLogList);
    }

    /*
     * @Author Echo
     * @Description 分页获取所有的产品审核日志
     * @Date 23:10 2022/12/9
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsProductVertifyRecord>>
     **/
    @ApiOperation("分页获取所有的产品审核日志")
    @GetMapping(value = "/queryPageProductVertifyRecordLog")
    @ResponseBody
    public ResultApi<CommonPage<PmsProductVertifyRecord>> queryPageProductVertifyRecordLog(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        Page<PmsProductVertifyRecord> pmsProductVertifyRecordLogPage = pmsProductVertifyRecordService.queryPageProductVertifyRecordLog(pageNum,pageSize);
        return ResultApi.success(CommonPage.restPage(pmsProductVertifyRecordLogPage));
    }

    /*
     * @Author Echo
     * @Description 根据Id获取指定的产品审核日志
     * @Date 23:11 2022/12/9
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProductVertifyRecord>
     **/
    @ApiOperation("根据Id获取指定的产品审核日志")
    @GetMapping(value = "/queryProductVertifyRecordLogByID")
    @ResponseBody
    public ResultApi<PmsProductVertifyRecord> queryProductVertifyRecordLogByID(@RequestParam(value = "id") Long id){
        PmsProductVertifyRecord pmsProductVertifyRecordLog = pmsProductVertifyRecordService.getById(id);
        return ObjectUtil.isEmpty(pmsProductVertifyRecordLog) ? ResultApi.failed() : ResultApi.success(pmsProductVertifyRecordLog);
    }

    /*
     * @Author Echo
     * @Description 创建一个产品审核日志
     * @Date 23:11 2022/12/9
     * @Param [pmsProductVertifyRecordLog]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("创建一个产品审核日志")
    @PostMapping(value = "insertProductVertifyRecordLog")
    public ResultApi insertProductVertifyRecordLog(@RequestBody PmsProductVertifyRecord pmsProductVertifyRecordLog){
        return pmsProductVertifyRecordService.save(pmsProductVertifyRecordLog) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改产品审核日志
     * @Date 23:11 2022/12/9
     * @Param [pmsProductVertifyRecordLog]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品审核日志")
    @PutMapping(value = "updateProductVertifyRecordLogByID")
    public ResultApi updateProductVertifyRecordLogByID(@RequestBody PmsProductVertifyRecord pmsProductVertifyRecordLog) {
        return pmsProductVertifyRecordService.updateById(pmsProductVertifyRecordLog) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除产品审核日志
     * @Date 23:12 2022/12/9
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除产品审核日志")
    @PutMapping(value = "delProductVertifyRecordLogByID")
    public ResultApi delProductVertifyRecordLogByID(@RequestParam(value = "id") Long id) {
        return pmsProductVertifyRecordService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

