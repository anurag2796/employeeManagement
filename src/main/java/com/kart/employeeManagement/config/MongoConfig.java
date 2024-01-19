package com.kart.employeeManagement.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MongoConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://" +
                env.getProperty("spring.data.jdbc.host") + ":" + env.getProperty("spring.data.jdbc.port") + "/" + env.getProperty("spring.data.mongodb.database"));
        return MongoClients.create(connectionString);
    }
}
