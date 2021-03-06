package com.spring.usercenter.contact;

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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.spring.usercenter.mapper", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDatasourceConfig {

    /**
     * 配置数据数据源 master
     *
     * @return
     */
    @Bean(name = "masterDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource masterDatasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置session工厂
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:"));
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }


    /**
     * 配置事务管理器
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "masterTransactionManger")
    @Primary
    public DataSourceTransactionManager masterTransactionManger(@Qualifier("masterDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 模版
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}