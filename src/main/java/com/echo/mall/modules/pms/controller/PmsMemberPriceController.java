package com.echo.mall.modules.pms.controller;


import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsMemberPrice;
import com.echo.mall.modules.pms.service.PmsMemberPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品会员价格表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */

@Api("PmsMemberPriceController")
@Tag(name = "PmsMemberPriceController",description = "商品会员价格管理")
@RestController
@RequestMapping("/pms/pmsMemberPrice")
public class PmsMemberPriceController {

    @Autowired
    private PmsMemberPriceService pmsMemberPriceService;


    /*
     * @Author Echo
     * @Description 获取所有的商品会员价格
     * @Date 21:20 2022/11/29
     * @Param
     * @return
     **/
    @ApiOperation("获取所有的商品会员价格")
    @GetMapping("/queryAllMemberPrice")
    @ResponseBody
    public ResultApi queryAllMemberPrice() {
        return ResultApi.success(pmsMemberPriceService.list());
    }

    /*
     * @Author Echo
     * @Description 分页获取商品会员价格
     * @Date 21:46 2022/11/29
     * @Param [pageNum, pageSize]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsMemberPrice>>
     **/
    @ApiOperation("分页获取商品会员价格")
    @GetMapping("/queryPageMemberPrice")
    @ResponseBody
    public ResultApi<CommonPage<PmsMemberPrice>> queryPageMemberPrice(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        return ResultApi.success(CommonPage.restPage(pmsMemberPriceService.queryPageMemberPrice(pageNum,pageSize)));
    }


    /*
     * @Author Echo
     * @Description
     * @Date 21:23 2022/11/29
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsMemberPrice>
     **/
    @ApiOperation("根据ID查询商品会员")
    @GetMapping("/queryMemberPriceByID")
    @ResponseBody
    public ResultApi<PmsMemberPrice> queryMemberPriceByID (@RequestParam Long id) {
        PmsMemberPrice pmsMemberPrice = pmsMemberPriceService.getById(id);
        return ResultApi.success( pmsMemberPrice);
    }


    /*
     * @Author Echo
     * @Description 新增一条商品会员
     * @Date 21:40 2022/11/29
     * @Param [pmsMemberPrice]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("新增一条商品会员")
    @PostMapping("/insertMemberPrice")
    public ResultApi insertMemberPrice(@RequestBody PmsMemberPrice pmsMemberPrice) {
        return pmsMemberPriceService.save(pmsMemberPrice) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改一条商品会员
     * @Date 21:41 2022/11/29
     * @Param [pmsMemberPrice]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改一条商品会员")
    @PutMapping("/updateMemberPriceByID")
    public ResultApi updateMemberPriceByID (@RequestBody PmsMemberPrice pmsMemberPrice) {
        return pmsMemberPriceService.updateById(pmsMemberPrice) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID删除一条商品会员
     * @Date 21:42 2022/11/29
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除一条商品会员")
    @DeleteMapping("/delMemberPriceByID")
    public ResultApi delMemberPriceByID (@RequestParam Long id) {
        return pmsMemberPriceService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }

}

