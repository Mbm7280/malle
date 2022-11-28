package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsCommentReplay;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品评价回复表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsCommentReplayService extends IService<PmsCommentReplay> {
    
    /*
     * @Author Echo
     * @Description 分页获取所有的商品评价回复
     * @Date 21:15 2022/11/28
     * @Param 
     * @return 
     **/
    Page<PmsCommentReplay> queryPageCommentReplay(Integer pageNum, Integer pageSize);
    

}
