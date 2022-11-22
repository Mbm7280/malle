package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsAlbum;
import com.echo.mall.modules.pms.model.PmsBrand;
import com.echo.mall.modules.pms.mapper.PmsBrandMapper;
import com.echo.mall.modules.pms.service.PmsBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

    /*
     * @Author Echo
     * @Description 分页获取所有的品牌
     * @Date 12:30 2022/11/22
     * @Param [pageSize, pageNum]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsBrand>
     **/
    @Override
    public Page<PmsBrand> queryPageBrand(Integer pageSize, Integer pageNum) {
        Page<PmsBrand> page = new Page(pageNum,pageSize);
        QueryWrapper<PmsBrand> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }

}
