package com.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class Config {

    @Bean
    public StreamsConfig streamConfig(KafkaProperties properties) {
        return new StreamsConfig(properties.buildStreamsProperties());
    }

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic outputTopic() {
        return TopicBuilder.name("spring.boot.kafka.stream.output.topic.name")
                .partitions(10)
                .replicas(3)
                .compact()
                .build();
    }

    @Bean
    public static Properties getAppProperties() throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream("resources/application.properties");
        prop.load(input);

        return prop;
    }
}
