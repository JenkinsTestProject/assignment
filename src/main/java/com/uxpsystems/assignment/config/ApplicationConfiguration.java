package com.uxpsystems.assignment.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * ApplicationConfiguration
 */
@Configuration
@EnableMongoRepositories(mongoTemplateRef = "customTemplate",basePackages = {"com.uxpsystems.assignment.dao"})
public class ApplicationConfiguration {

    @Autowired
    ApplicationConfigurationProperties properties;

    @Bean(name="customTemplate")
    public MongoTemplate getCustomTemplate() throws Exception{

        ApplicationConfigurationProperties.MongoDB mongoDb = properties.getMongoDb();

        MongoClientOptions.Builder builder = MongoClientOptions.builder();

        List<ServerAddress> serverList = new ArrayList<>();

        for (ApplicationConfigurationProperties.MongoServerConfig server: mongoDb.getServerList().values()){
            serverList.add(new ServerAddress(server.getHost(),Integer.parseInt(server.getPort())));
        }

        MongoClient mongo = new MongoClient(serverList,builder.build());
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, mongoDb.getDbName());

        return new MongoTemplate(mongoDbFactory);
    }
}
