package com.sylleryum.producer;

import com.sylleryum.producer.entity.Entity;
import com.sylleryum.producer.entity.Entity2;
import com.sylleryum.producer.entity.EntityTest;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class FixedRateProducer {

	@Autowired
	private KafkaTemplate<String, Entity> kafkaTemplate;

//	@Autowired
//	private KafkaTemplate<String, Entity2> kafkaTemplate;

	private int i = 0;

	private Logger log = LoggerFactory.getLogger(FixedRateProducer.class);

	@Bean
	public NewTopic paymentTopic() {
		return TopicBuilder.name("teste")
				.partitions(3)
				.compact()
				.build();
	}

	@Scheduled(fixedRate = 500000)
	public void sendMessage() {
		i++;
		log.info(LocalDate.now().toString()+i);

		var entityTest = new Entity(LocalTime.now().toString(),"world");
//		var entityTest2 = new Entity2("anickname!");

		kafkaTemplate.send(
//				MessageBuilder.withPayload(entityTest)
//						.setHeader(KafkaHeaders.TOPIC, "teste")
//						.build()
				MessageBuilder.withPayload(entityTest)
						.setHeader("hash", entityTest.hashCode())
						.setHeader("version", "1.0.0")
						.setHeader("endOfLife", LocalDate.now().plusDays(1L))
						.setHeader("type", "fct")
						.setHeader("cid", i)
						.setHeader(KafkaHeaders.TOPIC, "teste")
//						.setHeader(KafkaHeaders.MESSAGE_KEY, String.valueOf(i))
						.setHeader(KafkaHeaders.MESSAGE_KEY, LocalDate.now().toString())
						.build()
		);

//		kafkaTemplate.send("teste2", String.valueOf(i), entityTest2);

//		kafkaTemplate.send("t1", String.valueOf(i), i+" - "+
//		LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
	}

}
