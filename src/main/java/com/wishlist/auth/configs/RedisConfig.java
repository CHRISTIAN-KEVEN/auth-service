package com.wishlist.auth.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

        @Value("${spring.redis.host}")
        private String redisHost;

        @Value("${spring.redis.port}")
        private int redisPort;

        @Value("${spring.redis.password}")
        private String redisPassword;

        @Value("${spring.redis.database}")
        private int redisDatabase;

        @Value("${spring.redis.timeout}")
        private int redisTimeout;

        @Bean
        public RedisConnectionFactory redisConnectionFactory() {
//            JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//            jedisConnectionFactory.setHostName(redisHost);
//            jedisConnectionFactory.setPort(redisPort);
////            jedisConnectionFactory.setPassword(redisPassword);

            LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
            lettuceConnectionFactory.setHostName(redisHost);
            lettuceConnectionFactory.setPort(redisPort);
            lettuceConnectionFactory.setPassword(redisPassword);
            lettuceConnectionFactory.setDatabase(redisDatabase);
            lettuceConnectionFactory.setTimeout(redisTimeout);
            return lettuceConnectionFactory;
        }

        @Bean
        public RedisTemplate<String, Object> redisTemplate() {
            RedisTemplate<String, Object> template = new RedisTemplate<>();
            template.setConnectionFactory(redisConnectionFactory());
            return template;
        }

}
