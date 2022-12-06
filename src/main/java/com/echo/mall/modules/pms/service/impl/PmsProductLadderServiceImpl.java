package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductLadder;
import com.echo.mall.modules.pms.mapper.PmsProductLadderMapper;
import com.echo.mall.modules.pms.service.PmsProductLadderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductLadderServiceImpl extends ServiceImpl<PmsProductLadderMapper, PmsProductLadder> implements PmsProductLadderService {
    /*
     * @Author Echo
     * @Description 分页获取所有的产品阶梯
     * @Date 19:13 2022/12/6
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProductLadder>
     **/
    @Override
    public Page<PmsProductLadder> queryPageProductLadder(Integer pageNum, Integer pageSize) {
        Page<PmsProductLadder> page = new Page<>(pageNum,pageSize);
        QueryWrapper queryWrapper = new QueryWrapper();
        return page(page,queryWrapper);
    }
}
