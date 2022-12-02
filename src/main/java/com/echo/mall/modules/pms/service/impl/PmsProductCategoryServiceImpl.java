package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductCategory;
import com.echo.mall.modules.pms.mapper.PmsProductCategoryMapper;
import com.echo.mall.modules.pms.service.PmsProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService {

    /*
     * @Author Echo
     * @Description 分页获取所有的品牌
     * @Date 03:52 2022/12/3
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProductCategory>
     **/
    @Override
    public Page<PmsProductCategory> queryPageProductCategory(Integer pageNum, Integer pageSize) {
        Page<PmsProductCategory> page = new Page<>();
        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper<>();
        return page(page,queryWrapper);
    }
}
