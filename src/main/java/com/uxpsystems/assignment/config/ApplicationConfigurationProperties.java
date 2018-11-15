package com.uxpsystems.assignment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Map;

/**
 * ApplicationConfigurationProperties
 */
@Component
@ConfigurationProperties()
public class ApplicationConfigurationProperties {

    @Valid
    private MongoDB mongoDb = new MongoDB();

    public static class MongoDB {

        private String dbName;
        private Map<String,MongoServerConfig> serverList;

        public String getDbName() {
            return dbName;
        }
        public void setDbName(String dbName) {
            this.dbName = dbName;
        }
        public Map<String, MongoServerConfig> getServerList() {
            return serverList;
        }
        public void setServerList(Map<String, MongoServerConfig> serverList) {
            this.serverList = serverList;
        }
    }

    public static class MongoServerConfig{
        private String host;
        private String port;
        public String getHost() {
            return host;
        }
        public void setHost(String host) {
            this.host = host;
        }
        public String getPort() {
            return port;
        }
        public void setPort(String port) {
            this.port = port;
        }
    }

    public MongoDB getMongoDb() {
        return mongoDb;
    }

    public void setMongoDb(MongoDB mongoDb) {
        this.mongoDb = mongoDb;
    }

}