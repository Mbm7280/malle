package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductOperateLog;
import com.echo.mall.modules.pms.mapper.PmsProductOperateLogMapper;
import com.echo.mall.modules.pms.service.PmsProductOperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductOperateLogServiceImpl extends ServiceImpl<PmsProductOperateLogMapper, PmsProductOperateLog> implements PmsProductOperateLogService {


    /*
     * @Author Echo
     * @Description 获取所有的产品操作日志
     * @Date 22:37 2022/12/8
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsProductOperateLog>
     **/
    @Override
    public Page<PmsProductOperateLog> queryPageProductOperateLog(Integer pageNum, Integer pageSize) {
        Page<PmsProductOperateLog> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsProductOperateLog> queryWrapper = new QueryWrapper<>();
        return page(page,queryWrapper);
    }
}
