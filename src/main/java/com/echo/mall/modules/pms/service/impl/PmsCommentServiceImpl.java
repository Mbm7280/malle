package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsComment;
import com.echo.mall.modules.pms.mapper.PmsCommentMapper;
import com.echo.mall.modules.pms.service.PmsCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsCommentServiceImpl extends ServiceImpl<PmsCommentMapper, PmsComment> implements PmsCommentService {

    /*
     * @Author Echo
     * @Description 分页获取所有的评价
     * @Date 21:56 2022/11/24
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.echo.mall.modules.pms.model.PmsComment>
     **/
    @Override
    public Page<PmsComment> queryPageComment(Integer pageNum, Integer pageSize) {
        Page<PmsComment> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsComment> queryWrapper = new QueryWrapper();
        return  page(page,queryWrapper);
    }
}
