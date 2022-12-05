package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductFullReduction;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品满减表(只针对同商品) 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductFullReductionService extends IService<PmsProductFullReduction> {
    
    /*
     * @Author Echo
     * @Description 分页获取所有的产品满减信息
     * @Date 16:09 2022/12/5
     * @Param 
     * @return 
     **/
    Page<PmsProductFullReduction> queryPageProductFullReduction(Integer pageNum, Integer pageSize);

}
