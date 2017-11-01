package cn.mrpei.tweetadmin.datasource;


import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Create by 裴周宇
 * Date:2017/10/11
 * Time:10:10
 */
@Configuration
@MapperScan(basePackages = "cn.mrpei.tweetadmin.dao.client", sqlSessionTemplateRef = "clientSqlSessionTemplate")
public class DataSourceForClientConfig {
    @Bean(name = "clientDataSource")
    @ConfigurationProperties(prefix = "custom.datasource.client")

    public DataSource sysDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "clientSqlSessionFactory")
    public SqlSessionFactory sysSqlSessionFactory(@Qualifier("clientDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/client/*.xml"));
        // 分页插件  此处不做引入  配置在xml里
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("reasonable", "true");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props);
//        //添加插件
        bean.setPlugins(new Interceptor[]{pageHelper});
        return bean.getObject();
    }


    @Bean(name = "clientTransactionManager")

    public DataSourceTransactionManager sysTransactionManager(@Qualifier("clientDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "clientSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sysSqlSessionTemplate(@Qualifier("clientSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
