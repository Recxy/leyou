package com.leyou.item.pojo;

import lombok.Data;

/**
 * @author itw_liuqp
 * @date 2020/7/24 10:33
 * @describe
 */
@Data
public class Brand {
    private Long id;
    private String name;// 品牌名称
    private String image;// 品牌图片
    private Character letter;
}
