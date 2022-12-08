package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsProductOperateLog;
import com.echo.mall.modules.pms.service.PmsProductOperateLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  产品操作日志前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */

@Api("PmsProductOperateLogController")
@Tag(name = "PmsProductOperateLogController",description = "产品操作日志")
@RestController
@RequestMapping("/pms/pmsProductOperateLog")
public class PmsProductOperateLogController {

    @Autowired
    private PmsProductOperateLogService pmsProductOperateLogService;

    /*
     * @Author Echo
     * @Description 获取所有的产品操作日志
     * @Date 22:34 2022/12/8
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsProductOperateLog>>
     **/
    @ApiOperation("获取所有的产品操作日志")
    @GetMapping(value = "/queryAllProductOperateLog")
    @ResponseBody
    public ResultApi<List<PmsProductOperateLog>> queryAllProductOperateLog(){
        List<PmsProductOperateLog> pmsProductOperateLogList = pmsProductOperateLogService.list();
        return CollectionUtil.isEmpty(pmsProductOperateLogList) ? ResultApi.failed() : ResultApi.success(pmsProductOperateLogList);
    }


    /*
     * @Author Echo
     * @Description 分页获取所有的产品操作日志
     * @Date 22:34 2022/12/8
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsProductOperateLog>>
     **/
    @ApiOperation("分页获取所有的产品操作日志")
    @GetMapping(value = "/queryPageProductOperateLog")
    @ResponseBody
    public ResultApi<CommonPage<PmsProductOperateLog>> queryPageProductOperateLog(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        Page<PmsProductOperateLog> pmsProductOperateLogPage = pmsProductOperateLogService.queryPageProductOperateLog(pageNum,pageSize);
        return ResultApi.success(CommonPage.restPage(pmsProductOperateLogPage));
    }

    /*
     * @Author Echo
     * @Description 根据Id获取指定的产品操作日志
     * @Date 22:38 2022/12/8
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsProductOperateLog>
     **/
    @ApiOperation("根据Id获取指定的产品操作日志")
    @GetMapping(value = "/queryProductOperateLogByID")
    @ResponseBody
    public ResultApi<PmsProductOperateLog> queryProductOperateLogByID(@RequestParam(value = "id") Long id){
        PmsProductOperateLog pmsProductOperateLog = pmsProductOperateLogService.getById(id);
        return ObjectUtil.isEmpty(pmsProductOperateLog) ? ResultApi.failed() : ResultApi.success(pmsProductOperateLog);
    }

    /*
     * @Author Echo
     * @Description 创建一个产品操作日志
     * @Date 22:38 2022/12/8
     * @Param [pmsProductOperateLog]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("创建一个产品操作日志")
    @PostMapping(value = "insertProductOperateLog")
    public ResultApi insertProductOperateLog(@RequestBody PmsProductOperateLog pmsProductOperateLog){
        return pmsProductOperateLogService.save(pmsProductOperateLog) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改产品操作日志
     * @Date 22:39 2022/12/8
     * @Param [pmsProductOperateLog]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改产品操作日志")
    @PutMapping(value = "updateProductOperateLogByID")
    public ResultApi updateProductOperateLogByID(@RequestBody PmsProductOperateLog pmsProductOperateLog) {
        return pmsProductOperateLogService.updateById(pmsProductOperateLog) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除产品操作日志
     * @Date 22:39 2022/12/8
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除产品操作日志")
    @PutMapping(value = "delProductOperateLogByID")
    public ResultApi delProductOperateLogByID(@RequestParam(value = "id") Long id) {
        return pmsProductOperateLogService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

