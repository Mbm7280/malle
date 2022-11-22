package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.pms.model.PmsBrand;
import com.echo.mall.modules.pms.service.PmsBrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@RestController
@RequestMapping("/pms/pmsBrand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsAlbumService;

    /*
     * @Author Echo
     * @Description 获取所有的品牌
     * @Date 12:22 2022/11/22
     * @Param []
     * @return com.echo.mall.common.api.ResultApi<java.util.List<com.echo.mall.modules.pms.model.PmsBrand>>
     **/
    @ApiOperation("获取所有的品牌")
    @GetMapping(value = "/queryAllBrand")
    @ResponseBody
    public ResultApi<List<PmsBrand>> queryAllBrand(){
        List<PmsBrand> pmsBrandList = pmsAlbumService.list();
        return CollectionUtil.isEmpty(pmsBrandList) ? ResultApi.failed() : ResultApi.success(pmsBrandList);
    }

    /*
     * @Author Echo
     * @Description 分页获取所有的品牌
     * @Date 12:27 2022/11/22
     * @Param [pageSize, pageNum]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.common.api.CommonPage<com.echo.mall.modules.pms.model.PmsBrand>>
     **/
    @ApiOperation("分页获取所有的品牌")
    @GetMapping(value = "/queryPageBrand")
    @ResponseBody
    public ResultApi<CommonPage<PmsBrand>> queryPageBrand(@RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        Page<PmsBrand> pageBrand = pmsAlbumService.queryPageBrand(pageNum, pageSize);
        return ResultApi.success(CommonPage.restPage(pageBrand));
    }

    /*
     * @Author Echo
     * @Description 根据Id获取指定的品牌
     * @Date 12:35 2022/11/22
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi<com.echo.mall.modules.pms.model.PmsBrand>
     **/
    @ApiOperation("根据Id获取指定的品牌")
    @GetMapping(value = "/queryBrandByID")
    @ResponseBody
    public ResultApi<PmsBrand> queryBrandByID(@RequestParam(value = "id") Long id){
        PmsBrand pmsBrand = pmsAlbumService.getById(id);
        return ResultApi.success(pmsBrand);
    }

    @ApiOperation("创建一个品牌")
    @PostMapping(value = "insertBrand")
    @ResponseBody
    public ResultApi insertBrand(@RequestBody PmsBrand brand){
        return pmsAlbumService.save(brand) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改品牌
     * @Date 14:45 2022/11/22
     * @Param [pmsBrand]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID修改品牌")
    @PutMapping(value = "updateBrandByID")
    @ResponseBody
    public ResultApi updateBrandByID(@RequestBody PmsBrand pmsBrand) {
        return pmsAlbumService.updateById(pmsBrand) ? ResultApi.success(null) : ResultApi.failed();
    }

    /*
     * @Author Echo
     * @Description 根据ID修改品牌
     * @Date 14:46 2022/11/22
     * @Param [id]
     * @return com.echo.mall.common.api.ResultApi
     **/
    @ApiOperation("根据ID删除品牌")
    @PutMapping(value = "delBrandByID")
    @ResponseBody
    public ResultApi delBrandByID(@RequestParam(value = "id") Long id) {
        return pmsAlbumService.removeById(id) ? ResultApi.success(null) : ResultApi.failed();
    }
}

