package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductAttribute;
import com.echo.mall.modules.pms.mapper.PmsProductAttributeMapper;
import com.echo.mall.modules.pms.service.PmsProductAttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductAttributeServiceImpl extends ServiceImpl<PmsProductAttributeMapper, PmsProductAttribute> implements PmsProductAttributeService {

    /*
     * @Author Echo
     * @Description 分页获取产品属性
     * @Date 22:32 2022/12/1
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProductAttribute>
     **/
    @Override
    public Page<PmsProductAttribute> queryPageProductAttribute(Integer pageNum, Integer pageSize) {
        Page<PmsProductAttribute> page = new Page<>();
        QueryWrapper<PmsProductAttribute> queryWrapper = new QueryWrapper<>();
        return page(page,queryWrapper);
    }
}
