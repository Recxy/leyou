package com.leyou.common.config.mybatis;

import com.github.pagehelper.PageInterceptor;
import com.leyou.common.config.DruidConfig;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import com.leyou.common.config.mybatis.scan.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author itw_liuqp
 * @date 2020/7/20 11:22
 * @describe
 */
@Configuration
@AutoConfigureAfter({DruidConfig.class})
//此注解可以不添加，但是却要在你的mapper接口中添加@Mapper注解或者在你的启动类中添加下面这个注解，
// 这样容器才会加载mapper Bean。这三个注解中选用一个
@MapperScan(basePackages = {"${mapper.scan}"})
public class MybatisConfig {

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager clusterTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //分页插件
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "mysql");
        //是否将参数offset作为PageNum使用
        properties.setProperty("offsetAsPageNum", "true");
        //是否进行count查询
        properties.setProperty("rowBoundsWithCount", "true");
        //是否分页合理化
        properties.setProperty("reasonable", "false");
        interceptor.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[] {interceptor});
        return sessionFactory.getObject();
    }
}
