package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsAlbum;
import com.echo.mall.modules.pms.service.PmsAlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 相册表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api("PmsAlbumController")
@Tag(name = "PmsAlbumController",description = "相册表管理")
@RestController
@RequestMapping("/pms/pmsAlbum")
public class PmsAlbumController {

    @Autowired
    private PmsAlbumService pmsAlbumService;

    /*
     * @Author Echo
     * @Description 获取所有相册
     * @Date 21:12 2022/11/21
     * @Param []
     * @return com.echo.mall.common.api.CommonResult<java.util.List<com.echo.mall.modules.pms.model.PmsAlbum>>
     **/
    @ApiOperation("获取所有相册")
    @GetMapping(value = "/queryAllAlbum")
    @ResponseBody
    public ResultApi<List<PmsAlbum>> queryAllAlbum() {
        List<PmsAlbum> roleList = pmsAlbumService.list();
        if(CollectionUtil.isEmpty(roleList)){
            return ResultApi.failed();
        }
        System.out.println("This is a test");
        return ResultApi.success(roleList);
    }

    /*
     * @Author Echo
     * @Description
     * @Date 21:26 2022/11/21
     * @Param [albumName, pageSize, pageNum]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsAlbum>>
     **/
    @ApiOperation("分页获取相册列表")
    @GetMapping(value = "/queryPageAlbum")
    @ResponseBody
    public ResultApi<CommonPage<PmsAlbum>> queryPageAlbum(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<PmsAlbum> roleList = pmsAlbumService.queryPageAlbum(pageSize, pageNum);
        return ResultApi.success(CommonPage.restPage(roleList));
    }

    /*
     * @Author Echo
     * @Description 根据相册名称分页获取相册列表
     * @Date 21:26 2022/11/21
     * @Param [albumName, pageSize, pageNum]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsAlbum>>
     **/
    @ApiOperation("根据相册名称分页获取相册列表")
    @GetMapping(value = "/queryPageAlbumListByAlbumName")
    @ResponseBody
    public ResultApi<CommonPage<PmsAlbum>> queryPageAlbumListByAlbumName(@RequestParam(value = "keyword", required = false) String albumName,
                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<PmsAlbum> roleList = pmsAlbumService.queryPageAlbumListByAlbumName(albumName, pageSize, pageNum);
        return ResultApi.success(CommonPage.restPage(roleList));
    }

    /*
     * @Author Echo
     * @Description 新增一个相册
     * @Date 21:53 2022/11/21
     * @Param [pmsAlbum]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("新增一个相册")
    @PostMapping(value = "/insertAlbum")
    public ResultApi insertAlbum(@RequestBody PmsAlbum pmsAlbum) {
        return pmsAlbumService.insertAlbum(pmsAlbum) ? ResultApi.success(null):ResultApi.failed();
    }


    /*
     * @Author Echo
     * @Description 根据ID修改相册
     * @Date 22:13 2022/11/21
     * @Param [pmsAlbum]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改相册")
    @PutMapping(value = "/updateAlbumByID")
    public ResultApi updateAlbumByID(@RequestBody PmsAlbum pmsAlbum) {
        return pmsAlbumService.updateAlbumByID(pmsAlbum) ? ResultApi.success(null):ResultApi.failed();
    }


    /*
     * @Author Echo
     * @Description 根据ID删除相册
     * @Date 22:18 2022/11/21
     * @Param
     * @return
     **/
    @ApiOperation("根据ID删除相册")
    @DeleteMapping(value = "/delAlbumById")
    public ResultApi delAlbumById(@RequestParam Long id) {
        return pmsAlbumService.delAlbumById(id) ? ResultApi.success(null):ResultApi.failed();
    }

}

