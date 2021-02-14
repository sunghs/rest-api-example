package sunghs.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sunghs.rest.api.components.AdditionalUserBean;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialize")
    public AdditionalUserBean additionalUserBean() {
        return new AdditionalUserBean();
    }
}
