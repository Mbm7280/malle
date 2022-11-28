package com.echo.mall.modules.pms.controller;


import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsCommentReplay;
import com.echo.mall.modules.pms.service.PmsCommentReplayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 产品评价回复表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@RestController
@RequestMapping("/pms/pmsCommentReplay")
@Api("PmsCommentReplayController")
@Tag(name = "PmsCommentReplayController", description = "产品评价回复管理")
public class PmsCommentReplayController {


    @Autowired
    private PmsCommentReplayService pmsCommentReplayService;


    /*
     * @Author Echo
     * @Description 获取所有的商品评价回复
     * @Date 21:08 2022/11/28
     * @Param []
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("获取所有的商品评价回复")
    @GetMapping("/queryAllCommentReplay")
    @ResponseBody
    public ResultApi queryAllCommentReplay() {
        return ResultApi.success(pmsCommentReplayService.list());
    }

    /*
     * @Author Echo
     * @Description 分页获取所有的商品评价回复
     * @Date 21:12 2022/11/28
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsCommentReplay>>
     **/
    @ApiOperation("分页获取所有的商品评价回复")
    @GetMapping("/queryPageCommentReplay")
    @ResponseBody
    public ResultApi<CommonPage<PmsCommentReplay>> queryPageCommentReplay(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        return ResultApi.success(CommonPage.restPage(pmsCommentReplayService.queryPageCommentReplay(pageNum,pageSize)));
    }


    /*
     * @Author Echo
     * @Description 根据ID查询商品评价回复
     * @Date 21:19 2022/11/28
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsCommentReplay>
     **/
    @ApiOperation("根据ID查询商品评价回复")
    @GetMapping("/quertCommentReplayByID")
    @ResponseBody
    public ResultApi<PmsCommentReplay> quertCommentReplayByID (@RequestParam Long id) {
        PmsCommentReplay pmsCommentReplay = pmsCommentReplayService.getById(id);
        return ResultApi.success(pmsCommentReplay);
    }

    /*
     * @Author Echo
     * @Description 新增一条商品评价回复
     * @Date 21:21 2022/11/28
     * @Param [pmsCommentReplay]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("新增一条商品评价回复")
    @PostMapping("/insertCommentReplay")
    public ResultApi insertCommentReplay(@RequestBody PmsCommentReplay pmsCommentReplay) {
        return pmsCommentReplayService.save(pmsCommentReplay) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改一条商品评价回复
     * @Date 21:23 2022/11/28
     * @Param [pmsCommentReplay]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改一条商品评价回复")
    @PutMapping("/updateCommentReplay")
    public ResultApi updateCommentReplay (@RequestBody PmsCommentReplay pmsCommentReplay) {
        return pmsCommentReplayService.updateById(pmsCommentReplay) ? ResultApi.success(null) : ResultApi.failed();
    }


    /*
     * @Author Echo
     * @Description 根据ID删除一条商品评价回复
     * @Date 21:25 2022/11/28
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除一条商品评价回复")
    @DeleteMapping("/delCommentReplayByID")
    public ResultApi delCommentReplayByID (@RequestParam Long id) {
        return pmsCommentReplayService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }







}

