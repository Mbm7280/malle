package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductOperateLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductOperateLogService extends IService<PmsProductOperateLog> {

    /*
     * @Author Echo
     * @Description 获取所有的产品操作日志
     * @Date 22:37 2022/12/8
     * @Param
     * @return
     **/
    Page<PmsProductOperateLog> queryPageProductOperateLog(Integer pageNum,Integer pageSize);

}
