package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductFullReduction;
import com.echo.mall.modules.pms.mapper.PmsProductFullReductionMapper;
import com.echo.mall.modules.pms.service.PmsProductFullReductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品满减表(只针对同商品) 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductFullReductionServiceImpl extends ServiceImpl<PmsProductFullReductionMapper, PmsProductFullReduction> implements PmsProductFullReductionService {

    /*
     * @Author Echo
     * @Description 分页获取所有的产品满减信息
     * @Date 16:06 2022/12/5
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProductFullReduction>
     **/
    @Override
    public Page<PmsProductFullReduction> queryPageProductFullReduction(Integer pageNum, Integer pageSize) {
        Page<PmsProductFullReduction> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsProductFullReduction> queryWrapper = new QueryWrapper<>();
        return page(page,queryWrapper);
    }
}
