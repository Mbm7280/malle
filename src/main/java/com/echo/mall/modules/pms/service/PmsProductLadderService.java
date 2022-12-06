package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductLadder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductLadderService extends IService<PmsProductLadder> {
    
    
    /*
     * @Author Echo
     * @Description 分页获取所有的产品阶梯
     * @Date 19:11 2022/12/6
     * @Param 
     * @return 
     **/
    Page<PmsProductLadder> queryPageProductLadder(Integer pageNum, Integer pageSize);

}
