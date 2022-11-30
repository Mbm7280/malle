package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductAttributeCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategory> {
    
    /*
     * @Author Echo
     * @Description 分页获取产品属性分类
     * @Date 20:53 2022/11/30
     * @Param 
     * @return 
     **/
    Page<PmsProductAttributeCategory> queryPageProductAttributeCategory(Integer pageNum,Integer pageSize);

}
