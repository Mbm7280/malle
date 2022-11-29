package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsMemberPrice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品会员价格表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsMemberPriceService extends IService<PmsMemberPrice> {
    
    /*
     * @Author Echo
     * @Description 分页获取商品会员价格
     * @Date 21:44 2022/11/29
     * @Param 
     * @return 
     **/
    Page<PmsMemberPrice> queryPageMemberPrice (Integer pageNum, Integer pageSize);

}
