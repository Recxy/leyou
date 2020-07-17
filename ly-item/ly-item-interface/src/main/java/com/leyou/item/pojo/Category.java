package com.leyou.item.pojo;

import lombok.Data;

/**
 * @author itw_liuqp
 * @date 2020/7/17 11:05
 * @describe
 */
@Data
public class Category {

    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;
}
