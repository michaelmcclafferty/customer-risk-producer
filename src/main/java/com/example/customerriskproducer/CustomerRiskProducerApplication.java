package com.example.customerriskproducer;

import java.util.List;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.customerriskproducer.models.CustomerRisk;
import com.example.customerriskproducer.sqlite.ReadFromSqlite;

@EnableKafka
@SpringBootApplication
public class CustomerRiskProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRiskProducerApplication.class, args);
	}

	
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("gazelleCustomerRisk")
                .partitions(4)
                .replicas(1)
                .build();
    }
    

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, CustomerRisk> template) {
        return args -> {
        	ReadFromSqlite read = new ReadFromSqlite();
        	List<CustomerRisk> customerRiskList = read.openConnectionFromSqlLite();
        	for (CustomerRisk c : customerRiskList) {
            template.send("gazelleCustomerRisk", c );
            }
        };
    }
}
