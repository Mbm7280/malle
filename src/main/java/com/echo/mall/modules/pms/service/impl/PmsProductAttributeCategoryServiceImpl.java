package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductAttributeCategory;
import com.echo.mall.modules.pms.mapper.PmsProductAttributeCategoryMapper;
import com.echo.mall.modules.pms.service.PmsProductAttributeCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryMapper, PmsProductAttributeCategory> implements PmsProductAttributeCategoryService {

    /*
     * @Author Echo
     * @Description 分页获取产品属性分类
     * @Date 20:55 2022/11/30
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProductAttributeCategory>
     **/
    @Override
    public Page<PmsProductAttributeCategory> queryPageProductAttributeCategory(Integer pageNum, Integer pageSize) {
        Page<PmsProductAttributeCategory> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsProductAttributeCategory> queryWrapper = new QueryWrapper<>();
        return page(page,queryWrapper);
    }
}
