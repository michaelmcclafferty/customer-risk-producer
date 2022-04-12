package com.example.customerriskproducer.configs;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.example.customerriskproducer.models.CustomerRisk;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerSerializer implements Serializer<CustomerRisk> {

	private ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public byte[] serialize(String topic, CustomerRisk data) {
		// TODO Auto-generated method stub
		try {
			CustomerRisk cust = new CustomerRisk(data.getId(),  data.isCrypto(), data.isGambling(), data.isAtRisk());
			
			return objectMapper.writeValueAsBytes(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SerializationException("Error when serialising Customer");
		}
	}
}



