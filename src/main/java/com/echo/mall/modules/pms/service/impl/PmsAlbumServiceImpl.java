package com.echo.mall.modules.pms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsAlbum;
import com.echo.mall.modules.pms.mapper.PmsAlbumMapper;
import com.echo.mall.modules.pms.service.PmsAlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 相册表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsAlbumServiceImpl extends ServiceImpl<PmsAlbumMapper, PmsAlbum> implements PmsAlbumService {

    /*
     * @Author Echo
     * @Description 根据相册名称分页获取相册列表
     * @Date 21:56 2022/11/21
     * @Param 
     * @return 
     **/
    @Override
    public Page<PmsAlbum> queryPageAlbumListByAlbumName(String albumName, Integer pageSize, Integer pageNum) {
        Page<PmsAlbum> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsAlbum> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsAlbum> lambda = wrapper.lambda();
        if(StrUtil.isNotEmpty(albumName)){
            lambda.like(PmsAlbum::getName,albumName);
        }
        return page(page,wrapper);
    }

    /*
     * @Author Echo
     * @Description 分页获取相册列表
     * @Date 21:56 2022/11/21
     * @Param 
     * @return 
     **/
    @Override
    public Page<PmsAlbum> queryPageAlbum(Integer pageSize, Integer pageNum) {
        Page<PmsAlbum> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsAlbum> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }

    /*
     * @Author Echo
     * @Description 新增一个相册
     * @Date 21:58 2022/11/21
     * @Param 
     * @return 
     **/
    @Override
    public boolean insertAlbum(PmsAlbum pmsAlbum) {
        return save(pmsAlbum);
    }


    /*
     * @Author Echo
     * @Description 根据ID修改相册
     * @Date 22:20 2022/11/21
     * @Param
     * @return
     **/
    @Override
    public boolean updateAlbumByID(PmsAlbum pmsAlbum) {
        return updateById(pmsAlbum);
    }

    /*
     * @Author Echo
     * @Description 根据ID删除相册
     * @Date 22:22 2022/11/21
     * @Param
     * @return
     **/
    @Override
    public boolean delAlbumById(Long id) {
        return removeById(id);
    }
}
