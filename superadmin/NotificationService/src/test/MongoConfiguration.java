package com.verizon.competency.notificationservice.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

public class MongoConfiguration extends AbstractMongoConfiguration {
    @Value("${mongodb.host}")
    private String mongoHost;

    public String getMongoHost(){
        return mongoHost;
    }

    public void setMongoHost(String host){
        this.mongoHost=host;
    }

    @Value("${mongodb.port}")
    private int mongoPort;

    private int getMongoPort(){
        return mongoPort;
    }

    public void setMongoPort(int port){
        this.mongoPort=port;
    }

    @Value("${mongodb.database}")
    private String databaseName;

    public void setDatabaseName(String databaseName){
        this.databaseName=databaseName;
    }

    @Override
    public MongoClient mongoClient() {
        MongoClient client = new MongoClient(mongoHost,mongoPort);
        return client;
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
}
