package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsSkuStock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * sku的库存 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsSkuStockService extends IService<PmsSkuStock> {

    /*
     * @Author Echo
     * @Description 分页获取所有的产品库存
     * @Date 17:27 2022/12/10
     * @Param
     * @return
     **/
    Page<PmsSkuStock> queryPageProductSkuStock(Integer pageNum,Integer pageSize);

}
