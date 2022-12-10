package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsSkuStock;
import com.echo.mall.modules.pms.mapper.PmsSkuStockMapper;
import com.echo.mall.modules.pms.service.PmsSkuStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockMapper, PmsSkuStock> implements PmsSkuStockService {

    /*
     * @Author Echo
     * @Description 分页获取所有的产品库存
     * @Date 17:28 2022/12/10
     * @Param [pageSum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsSkuStock>
     **/
    @Override
    public Page<PmsSkuStock> queryPageProductSkuStock(Integer pageNum, Integer pageSize) {
        Page<PmsSkuStock> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsSkuStock> queryWrapper = new QueryWrapper<>();
        return page(page,queryWrapper);
    }
}
