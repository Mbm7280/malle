package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProduct;
import com.echo.mall.modules.pms.mapper.PmsProductMapper;
import com.echo.mall.modules.pms.service.PmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {


    /*
     * @Author Echo
     * @Description 分页获取所有的产品
     * @Date 20:49 2022/12/4
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProduct>
     **/
    @Override
    public Page<PmsProduct> queryPageProduct(Integer pageNum, Integer pageSize) {
        Page<PmsProduct> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper();
        return page(page,queryWrapper);
    }
}
