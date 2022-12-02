package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductAttributeValue;
import com.echo.mall.modules.pms.mapper.PmsProductAttributeValueMapper;
import com.echo.mall.modules.pms.service.PmsProductAttributeValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储产品参数信息的表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductAttributeValueServiceImpl extends ServiceImpl<PmsProductAttributeValueMapper, PmsProductAttributeValue> implements PmsProductAttributeValueService {

    /*
     * @Author Echo
     * @Description 分页获取产品属性参数
     * @Date 22:05 2022/12/2
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProductAttributeValue>
     **/
    @Override
    public Page<PmsProductAttributeValue> queryPageProductAttributeValue(Integer pageNum, Integer pageSize) {
        Page<PmsProductAttributeValue> page = new Page(pageNum,pageSize);
        QueryWrapper<PmsProductAttributeValue> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }
}
