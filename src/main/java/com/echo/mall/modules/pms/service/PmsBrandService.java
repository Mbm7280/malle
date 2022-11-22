package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsAlbum;
import com.echo.mall.modules.pms.model.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsBrandService extends IService<PmsBrand> {

    /*
     * @Author Echo
     * @Description 分页获取所有的品牌
     * @Date 12:28 2022/11/22
     * @Param
     * @return
     **/
    Page<PmsBrand> queryPageBrand(Integer pageSize, Integer pageNum);


}
