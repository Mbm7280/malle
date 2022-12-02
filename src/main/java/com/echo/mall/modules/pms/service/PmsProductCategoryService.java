package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {


    /*
     * @Author Echo
     * @Description 分页获取所有的品牌
     * @Date 03:53 2022/12/3
     * @Param
     * @return
     **/
    Page<PmsProductCategory> queryPageProductCategory(Integer pageNum, Integer pageSize);

}
