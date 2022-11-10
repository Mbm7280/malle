package com.echo.mall.config;

import com.echo.mall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;


@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
