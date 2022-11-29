package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsMemberPrice;
import com.echo.mall.modules.pms.mapper.PmsMemberPriceMapper;
import com.echo.mall.modules.pms.service.PmsMemberPriceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品会员价格表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsMemberPriceServiceImpl extends ServiceImpl<PmsMemberPriceMapper, PmsMemberPrice> implements PmsMemberPriceService {

    /*
     * @Author Echo
     * @Description 分页获取商品会员价格
     * @Date 21:45 2022/11/29
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsMemberPrice>
     **/
    @Override
    public Page<PmsMemberPrice> queryPageMemberPrice(Integer pageNum, Integer pageSize) {
        Page<PmsMemberPrice> page = new Page<>();
        QueryWrapper<PmsMemberPrice> queryWrapper = new QueryWrapper();
        return page(page,queryWrapper);
    }
}
