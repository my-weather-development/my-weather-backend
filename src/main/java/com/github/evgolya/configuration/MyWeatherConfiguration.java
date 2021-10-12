package com.github.evgolya.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@EnableCaching
public class MyWeatherConfiguration {

    @Bean
    public ObjectMapper createObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public Caffeine<Object, Object> caffeineConfiguration() {
        return Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofDays(1));
    }

    @Bean
    public CacheManager cacheManager(Caffeine<Object, Object> caffeine) {
        final CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("localities");
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }
}
