package sunghs.rest.api.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

@Slf4j
public class AdditionalUserBean implements InitializingBean {

    public void initialize() {
        log.info("AdditionalUserBean Initialize");
    }

    @PostConstruct
    public void broadcast() {
        log.info("AdditionalUserBean PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("AdditionalUserBean Bean Properties Set");
    }
}
