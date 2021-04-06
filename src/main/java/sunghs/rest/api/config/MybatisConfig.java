package sunghs.rest.api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = MybatisConfig.BASE)
@EnableTransactionManagement
public class MybatisConfig {

    public static final String BASE = "sunghs.rest.api";
}
