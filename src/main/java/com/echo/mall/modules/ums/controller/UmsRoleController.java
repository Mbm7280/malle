package com.echo.mall.modules.ums.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.common.api.CommonPage;
import com.echo.mall.common.api.ResultApi;
import com.echo.mall.modules.ums.model.UmsMenu;
import com.echo.mall.modules.ums.model.UmsResource;
import com.echo.mall.modules.ums.model.UmsRole;
import com.echo.mall.modules.ums.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Api(tags = "UmsRoleController")
@Tag(name = "UmsRoleController",description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi create(@RequestBody UmsRole role) {
        boolean success = roleService.create(role);
        if (success) {
            return ResultApi.success(null);
        }
        return ResultApi.failed();
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi update(@PathVariable Long id, @RequestBody UmsRole role) {
        role.setId(id);
        boolean success = roleService.updateById(role);
        if (success) {
            return ResultApi.success(null);
        }
        return ResultApi.failed();
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi delete(@RequestParam("ids") List<Long> ids) {
        boolean success = roleService.delete(ids);
        if (success) {
            return ResultApi.success(null);
        }
        return ResultApi.failed();
    }


    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultApi<List<UmsRole>> listAll() {
        List<UmsRole> roleList = roleService.list();
        return ResultApi.success(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultApi<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsRole> roleList = roleService.list(keyword, pageSize, pageNum);
        return ResultApi.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("修改角色状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setId(id);
        umsRole.setStatus(status);
        boolean success = roleService.updateById(umsRole);
        if (success) {
            return ResultApi.success(null);
        }
        return ResultApi.failed();
    }

    @ApiOperation("获取角色相关菜单")
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultApi<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
        List<UmsMenu> roleList = roleService.listMenu(roleId);
        return ResultApi.success(roleList);
    }

    @ApiOperation("获取角色相关资源")
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultApi<List<UmsResource>> listResource(@PathVariable Long roleId) {
        List<UmsResource> roleList = roleService.listResource(roleId);
        return ResultApi.success(roleList);
    }

    @ApiOperation("给角色分配菜单")
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return ResultApi.success(count);
    }

    @ApiOperation("给角色分配资源")
    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
    @ResponseBody
    public ResultApi allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        return ResultApi.success(count);
    }

}
