package com.echo.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsCommentReplay;
import com.echo.mall.modules.pms.mapper.PmsCommentReplayMapper;
import com.echo.mall.modules.pms.service.PmsCommentReplayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品评价回复表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsCommentReplayServiceImpl extends ServiceImpl<PmsCommentReplayMapper, PmsCommentReplay> implements PmsCommentReplayService {

    /*
     * @Author Echo
     * @Description 分页获取所有的商品评价回复
     * @Date 21:15 2022/11/28
     * @Param [pageNum, pageSize]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page
     **/
    @Override
    public Page queryPageCommentReplay(Integer pageNum, Integer pageSize) {
        Page<PmsCommentReplay> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsCommentReplay> queryWrapper = new QueryWrapper();
        return page(page,queryWrapper);
    }



}
