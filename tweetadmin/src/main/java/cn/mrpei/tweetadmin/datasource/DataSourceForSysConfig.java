package cn.mrpei.tweetadmin.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Create by 裴周宇
 * Date:2017/10/11
 * Time:10:10
 */
@Configuration
@MapperScan(basePackages = "cn.mrpei.tweetadmin.dao.sys",sqlSessionTemplateRef = "sysSqlSessionTemplate")
public class DataSourceForSysConfig {

    @Bean(name = "sysDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sys")
    @Primary
    public DataSource sysDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "sysSqlSessionFactory")
    @Primary
    public SqlSessionFactory sysSqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/sys/*.xml"));
        return bean.getObject();
    }


    @Bean(name = "sysTransactionManager")
    @Primary
    public DataSourceTransactionManager sysTransactionManager(@Qualifier("sysDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sysSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sysSqlSessionTemplate(@Qualifier("sysSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
