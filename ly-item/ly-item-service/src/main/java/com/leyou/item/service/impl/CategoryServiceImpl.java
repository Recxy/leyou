package com.leyou.item.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.exception.BusinessException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itw_liuqp
 * @date 2020/7/17 15:57
 * @describe
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    private CategoryMapper categoryMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public String queryCategoryListByParentId(Long id) throws BusinessException {
         String data = "";
        try{
            List<Category> categoryList = categoryMapper.queryCategoryListByParentId(id);
            data = objectMapper.writeValueAsString(categoryList);
        }catch (Exception e){
            log.error("queryCategoryListByParentId is error",e);
            throw new BusinessException("500");
        }
        return data;
    }
}
