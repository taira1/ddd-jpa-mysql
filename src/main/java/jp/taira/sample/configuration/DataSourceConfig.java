package jp.taira.sample.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "jp.taira.sample.infrastructure.repository")
@EntityScan(basePackages = "jp.taira.sample.infrastructure.entity")
public class DataSourceConfig {

}
