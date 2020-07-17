package com.leyou.item.service;

import com.leyou.common.exception.BusinessException;
import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @author itw_liuqp
 * @date 2020/7/17 15:56
 * @describe
 */
public interface CategoryService {

    String queryCategoryListByParentId(Long id) throws BusinessException;
}
