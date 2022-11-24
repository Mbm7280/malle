package com.echo.mall.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsComment;
import com.echo.mall.modules.pms.service.PmsCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品评价表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */

/*
 * @Author Echo
 * @Description 商品评价管理
 * @Date 21:47 2022/11/24
 * @Param
 * @return
 **/
@Api(value = "PmsCommentController")
@Tag(name = "PmsCommentController",description = "商品评价管理")
@RestController
@RequestMapping("/pms/pmsComment")
public class PmsCommentController {

    @Autowired
    private PmsCommentService pmsCommentService;/*
     * @Author Echo
     * @Description 获取所有的评价
     * @Date 21:47 2022/11/24
     * @Param []
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("获取所有的评价")
    @GetMapping(value = "/quertAllComment")
    @ResponseBody
    public ResultApi quertAllComment () {
        List<PmsComment> pmsCommentList = pmsCommentService.list();
        return ResultApi.success(pmsCommentList);
    }

    /*
     * @Author Echo
     * @Description 分页获取所有的评价
     * @Date 21:51 2022/11/24
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<java.util.List<com.echo.mall.modules.pms.model.PmsComment>>>
     **/
    @ApiOperation("分页获取所有的评价")
    @GetMapping(value = "/queryPageComment")
    @ResponseBody
    public ResultApi<CommonPage<PmsComment>> queryPageComment (@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        Page<PmsComment> pmsCommentPage = pmsCommentService.queryPageComment(pageNum, pageSize);
        return ResultApi.success(CommonPage.restPage(pmsCommentPage));
    }

    /*
     * @Author Echo
     * @Description 根据指定的ID获取评论
     * @Date 22:00 2022/11/24
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据指定的ID获取评论")
    @GetMapping(value = "/queryCommentByID")
    @ResponseBody
    public ResultApi queryCommentByID (@RequestParam(value = "id") Long id) {
        PmsComment pmsComment = pmsCommentService.getById(id);
        return ResultApi.success(pmsComment);
    }

    /*
     * @Author Echo
     * @Description 新增一条评论
     * @Date 22:03 2022/11/24
     * @Param [pmsComment]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("新增一条评论")
    @PostMapping(value = "/insertComment")
    public ResultApi insertComment (@RequestBody PmsComment pmsComment) {
        return pmsCommentService.save(pmsComment) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改一条评论
     * @Date 22:05 2022/11/24
     * @Param [pmsComment]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改一条评论")
    @PutMapping(value = "updateCommentByID")
    public ResultApi updateCommentByID(@RequestBody PmsComment pmsComment) {
        return pmsCommentService.updateById(pmsComment) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除一条评论
     * @Date 22:07 2022/11/24
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除一条评论")
    @DeleteMapping(value = "/delCommentByID")
    public ResultApi delCommentByID(@RequestParam(value = "id") Long id) {
        return pmsCommentService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }





















}

