package com.echo.mall.modules.pms.controller;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-21
 */
@Api("PmsProductCategoryAttributeRelationController")
@Tag(name = "PmsProductCategoryAttributeRelationController",description = "产品属性参数管理")
@RestController
@RequestMapping("/pms/pmsProductCategoryAttributeRelation")
public class PmsProductCategoryAttributeRelationController {

}

