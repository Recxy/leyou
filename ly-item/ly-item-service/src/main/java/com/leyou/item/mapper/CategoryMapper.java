package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author itw_liuqp
 * @date 2020/7/17 15:52
 * @describe
 */
public interface CategoryMapper {

    @Select("select id,name,parentId,isParent,sort from tb_category where parent_id=#{id}")
    List<Category> queryCategoryListByParentId(@Param("id") Long id);
}
