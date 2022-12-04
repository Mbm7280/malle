package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductService extends IService<PmsProduct> {

    /*
     * @Author Echo
     * @Description 分页获取所有的产品
     * @Date 20:50 2022/12/4
     * @Param
     * @return
     **/
    Page<PmsProduct> queryPageProduct(Integer pageNum, Integer pageSize);

}
