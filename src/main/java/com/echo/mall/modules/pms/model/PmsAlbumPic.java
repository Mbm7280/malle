package com.echo.mall.modules.pms.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 画册图片表
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Getter
@Setter
@TableName("pms_album_pic")
@ApiModel(value = "PmsAlbumPic对象", description = "画册图片表")
public class PmsAlbumPic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long albumId;

    private String pic;


}
