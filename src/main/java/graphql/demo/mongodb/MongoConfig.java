package graphql.demo.mongodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = { "graphql.demo", "graphql.demo.repository"  })
public class MongoConfig  {

    @Value("${db.host}")
    private String databaseHost;

    @Value("${db.port}")
    private int databasePort;

    @Value("${db.name}")
    private String databaseName;

    @Bean(name="mongoTemplate")
    public MongoDbTemplate createTemplate(){
        return new MongoDbTemplate(databaseHost,databasePort,databaseName);
    }

}