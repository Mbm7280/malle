package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductAttribute;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductAttributeService extends IService<PmsProductAttribute> {
    
    
    /*
     * @Author Echo
     * @Description 分页获取产品属性
     * @Date 00:08 2022/12/2
     * @Param 
     * @return 
     **/
    Page<PmsProductAttribute> queryPageProductAttribute(Integer pageNum,Integer pageSize);
    

}
