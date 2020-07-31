package com.leyou.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.exception.BusinessException;
import com.leyou.common.result.BasePageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author itw_liuqp
 * @date 2020/7/24 11:20
 * @describe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j(topic = "itemLogger")
public class LyItemServiceTest {

    @Autowired(required = false)
    private BrandMapper brandMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BrandService brandService;

    @Test
    public void queryBrandListMapperTest(){
        Map map =new HashMap();
        map.put("sortBy","name");
        map.put("desc",true);
        map.put("name","");
        List<Brand> name = brandMapper.queryBrandList(map);
        for (Brand brand:name){
            System.out.println(brand.toString());
        }
    }
    @Test
    public void queryBrandByPageAndSort() throws BusinessException {
        String json = "{\"sortBy\":\"id\",\"desc\":\"true\",\"pageNum\":\"1\",\"pageSize\":\"5\"}";
        BasePageResult<List<Brand>> listBasePageResult = brandService.queryBrandByPageAndSort(json);
        throw new BusinessException("500");
//        System.out.println(listBasePageResult);
    }

    @Test
    public void Json2MapTest() throws IOException {
        String json = "{\"name\":\"lqp\",\"age\":18,\"body\":{\"heart\":\"心脏\",\"eyes\":\"眼睛\"},}";
        Map map = objectMapper.readValue(json, Map.class);
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        Map body = (Map) map.get("body");
        System.out.println(body.get("heart"));
    }

    @Test
    public void testLog(){
        log.trace("-----------trace------------");
        log.debug("-----------debug------------");
        log.info("------------info-------------");
        log.error("-----------error------------");
        log.warn("------------warn-------------");
    }
}
