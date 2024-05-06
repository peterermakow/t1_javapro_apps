package ru.paermakov.product_app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "datasource")
public class ApplicationProperties {

    private String jdbcUrl;
    private String username;
    private String password;

}
