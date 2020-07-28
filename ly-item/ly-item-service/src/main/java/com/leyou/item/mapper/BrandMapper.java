package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author itw_liuqp
 * @date 2020/7/24 11:06
 * @describe
 */
public interface BrandMapper {

    @Select({"select id,name,image,letter from tb_brand where name like concat('%',#{name},'%') order by #{sortBy} ",
    "<if test = 'desc'> desc</if>"})
    List<Brand> queryBrandList(@Param("name") String name,@Param("sortBy") String sortBy,@Param("desc") boolean desc);
}
