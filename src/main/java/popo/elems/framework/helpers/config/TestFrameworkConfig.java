package popo.elems.framework.helpers.config;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Log4j2
@Configuration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:stage.properties")
public class TestFrameworkConfig {

    @Getter
    @Value("${url}")
    private String stageUrl;

    @Getter
    @Value("${stage}")
    private String stage;

    @Bean
    public String getUrl() {
        return String.format(stageUrl, stage);
    }
}
