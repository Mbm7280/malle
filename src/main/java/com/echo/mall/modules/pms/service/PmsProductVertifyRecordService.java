package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductVertifyRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品审核记录 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductVertifyRecordService extends IService<PmsProductVertifyRecord> {

    /*
     * @Author Echo
     * @Description 分页获取所有的产品审核日志
     * @Date 23:14 2022/12/9
     * @Param
     * @return
     **/
    Page<PmsProductVertifyRecord> queryPageProductVertifyRecordLog (Integer pageNum,Integer pageSize);

}
