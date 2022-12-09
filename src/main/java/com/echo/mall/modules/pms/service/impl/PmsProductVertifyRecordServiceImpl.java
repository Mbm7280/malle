package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductVertifyRecord;
import com.echo.mall.modules.pms.mapper.PmsProductVertifyRecordMapper;
import com.echo.mall.modules.pms.service.PmsProductVertifyRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品审核记录 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductVertifyRecordServiceImpl extends ServiceImpl<PmsProductVertifyRecordMapper, PmsProductVertifyRecord> implements PmsProductVertifyRecordService {

    /*
     * @Author Echo
     * @Description 分页获取所有的产品审核日志
     * @Date 23:13 2022/12/9
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProductVertifyRecord>
     **/
    @Override
    public Page<PmsProductVertifyRecord> queryPageProductVertifyRecordLog(Integer pageNum, Integer pageSize) {
        Page<PmsProductVertifyRecord> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsProductVertifyRecord> queryWrapper = new QueryWrapper<>();
        return page(page,queryWrapper);
    }
}
