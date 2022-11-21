package com.echo.mall.modules.ums.controller;

import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.ums.model.UmsResourceCategory;
import com.echo.mall.modules.ums.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Api(tags = "UmsResourceCategoryController")
@Tag(name = "UmsResourceCategoryController",description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService resourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultApi<List<UmsResourceCategory>> listAll() {
        List<UmsResourceCategory> resourceList = resourceCategoryService.listAll();
        return ResultApi.success(resourceList);
    }

    @ApiOperation("添加后台资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi create(@RequestBody UmsResourceCategory umsResourceCategory) {
        boolean success = resourceCategoryService.create(umsResourceCategory);
        if (success) {
            return ResultApi.success(null);
        } else {
            return ResultApi.failed();
        }
    }

    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi update(@PathVariable Long id,
                               @RequestBody UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        boolean success = resourceCategoryService.updateById(umsResourceCategory);
        if (success) {
            return ResultApi.success(null);
        } else {
            return ResultApi.failed();
        }
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi delete(@PathVariable Long id) {
        boolean success = resourceCategoryService.removeById(id);
        if (success) {
            return ResultApi.success(null);
        } else {
            return ResultApi.failed();
        }
    }
}
