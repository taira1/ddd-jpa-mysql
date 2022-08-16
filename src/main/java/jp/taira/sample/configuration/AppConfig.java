package jp.taira.sample.configuration;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import javax.servlet.SessionTrackingMode;

import jp.taira.sample.presentation.AppSessionListener;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAsync
@EnableCaching
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "jp.taira.sample.application",
        "jp.taira.sample.domain",
        "jp.taira.sample.infrastructure",
        "jp.taira.sample.presentation",
})
@Import({AppSessionListener.class})
public class AppConfig {

    @Autowired
    protected ResourceLoader resourceLoader;

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        ServletContextInitializer initializer = servletContext -> {
            servletContext.getSessionCookieConfig().setName("APPSESSIONID");
            servletContext.getSessionCookieConfig().setHttpOnly(true);
            servletContext.getSessionCookieConfig().setSecure(true);
            servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
        };
        return initializer;
    }

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setDefaultLocale(null);
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setCacheSeconds(-1);
        return messageSource;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR)
                .setAmbiguityIgnored(true);
        return modelMapper;
    }
}