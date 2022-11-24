package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品评价表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsCommentService extends IService<PmsComment> {

    /*
     * @Author Echo
     * @Description 分页获取所有的评价
     * @Date 21:57 2022/11/24
     * @Param
     * @return
     **/
    Page<PmsComment> queryPageComment(Integer pageNum, Integer pageSize);

}
