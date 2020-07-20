package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author itw_liuqp
 * @date 2020/7/17 15:52
 * @describe
 */
//@Mapper //三选一
public interface CategoryMapper {

    @Results({
            @Result(column = "parent_id",property = "parentId"),
            @Result(column = "is_parent",property = "isParent")
    })
    @Select("select id,name,parent_id,is_parent,sort from tb_category where parent_id=#{id}")
    List<Category> queryCategoryListByParentId(@Param("id") Long id);
}
