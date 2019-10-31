package com.sid.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.sid.mapper.lee", sqlSessionFactoryRef = "twoSqlSessionFactory")
public class TwoDataSourceConfiguration {
    @Autowired
    public TwoDataSourceProperties twoDataSourceProperties;
 
    @Bean(name = "twoDataSource")
    public DataSource twoDataSource() {
        DruidXADataSource datasource = new DruidXADataSource();
        BeanUtils.copyProperties(twoDataSourceProperties,datasource);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(datasource);
        xaDataSource.setUniqueResourceName("twoDataSource");
        return xaDataSource;
    }
 
    @Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(@Qualifier("twoDataSource") DataSource twoDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(twoDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:mapper/lee/*.xml"));
        return bean.getObject();
    }
}