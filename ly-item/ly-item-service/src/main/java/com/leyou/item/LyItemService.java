package com.leyou.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author itw_liuqp
 * @date 2020/7/14 10:49
 * @describe
 */
//一定要设置scanBasePackages属性，这个属性标识springboot容器在启动时自动加载此路径下的bean对象，
// 设置成com.leyou就可以加载到common包下的bean对象了
@SpringBootApplication(scanBasePackages = {"com.leyou"})
@EnableDiscoveryClient
//@MapperScan(basePackages = {"com.leyou.item.mapper"}) //三选一
public class LyItemService {
    public static void main(String[] args) {
        SpringApplication.run(LyItemService.class,args);
    }
}
