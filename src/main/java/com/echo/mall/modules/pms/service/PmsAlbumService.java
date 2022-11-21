package com.echo.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.mall.modules.pms.model.PmsAlbum;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 相册表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
public interface PmsAlbumService extends IService<PmsAlbum> {

   /*
    * @Author Echo
    * @Description 根据相册名称分页获取相册列表
    * @Date 21:56 2022/11/21
    * @Param
    * @return
    **/
    Page<PmsAlbum> queryPageAlbumListByAlbumName(String albumName, Integer pageSize, Integer pageNum);

    /*
     * @Author Echo
     * @Description 分页获取相册列表
     * @Date 21:31 2022/11/21
     * @Param
     * @return
     **/
    Page<PmsAlbum> queryPageAlbum(Integer pageSize, Integer pageNum);


    /*
     * @Author Echo
     * @Description 新增一个相册
     * @Date 21:54 2022/11/21
     * @Param
     * @return
     **/
    boolean insertAlbum(PmsAlbum pmsAlbum);
    

    /*
     * @Author Echo
     * @Description 根据ID修改相册
     * @Date 22:18 2022/11/21
     * @Param 
     * @return 
     **/
    boolean updateAlbumByID(PmsAlbum pmsAlbum);


    /*
     * @Author Echo
     * @Description 根据ID删除相册
     * @Date 22:20 2022/11/21
     * @Param 
     * @return 
     **/
    boolean delAlbumById(Long id);



}
