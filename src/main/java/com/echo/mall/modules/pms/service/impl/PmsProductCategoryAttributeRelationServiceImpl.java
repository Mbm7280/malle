package com.echo.mall.modules.pms.service.impl;

import com.echo.mall.modules.pms.model.PmsProductCategoryAttributeRelation;
import com.echo.mall.modules.pms.mapper.PmsProductCategoryAttributeRelationMapper;
import com.echo.mall.modules.pms.service.PmsProductCategoryAttributeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Service
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation> implements PmsProductCategoryAttributeRelationService {

}
