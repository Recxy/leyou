package com.leyou.item;

import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itw_liuqp
 * @date 2020/7/24 11:20
 * @describe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LyItemServiceTest {

    @Autowired(required = false)
    private BrandMapper brandMapper;

    @Test
    public void test(){
        List<Brand> name = brandMapper.queryBrandList("", "name", false);
        for (Brand brand:name){
            brand.toString();
        }
    }
}
