package sunghs.rest.api.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserInitializer implements InitializingBean {

    @PostConstruct
    public void broadcast() {
        log.info("InitializingService created, PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet call");
    }
}
