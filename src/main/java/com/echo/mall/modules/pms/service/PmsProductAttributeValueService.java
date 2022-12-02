package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsProductAttributeValue;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 存储产品参数信息的表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsProductAttributeValueService extends IService<PmsProductAttributeValue> {

    /*
     * @Author Echo
     * @Description 分页获取产品属性参数
     * @Date 22:04 2022/12/2
     * @Param
     * @return
     **/
    Page<PmsProductAttributeValue> queryPageProductAttributeValue(Integer pageNum,Integer pageSize);

}
