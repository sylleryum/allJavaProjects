package com.sylleryum.joinstream;

import com.sylleryum.producer.entity.Entity;
import com.sylleryum.producer.entity.Entity2;
import com.sylleryum.producer.entity.EntityJoin;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.time.Duration;

import static org.apache.kafka.streams.kstream.Suppressed.BufferConfig.unbounded;
import static org.apache.kafka.streams.kstream.Suppressed.untilWindowCloses;


@EnableKafkaStreams
@Configuration
public class JoinStream {

//    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//    public KafkaStreamsConfiguration kafkaStreamConfig() {
//        var props = new HashMap<String, Object>();
//
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream-consumer-join");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "3000");
//        props.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);
//        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
//
//        return new KafkaStreamsConfiguration(props);
//    }

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("teste")
                .partitions(3)
                .compact()
                .build();
    }

    @Bean
    public NewTopic newTopic2() {
        return TopicBuilder.name("teste2")
                .partitions(3)
                .compact()
                .build();
    }

    @Bean
    public KStream<String, Entity> kstreamEntities(StreamsBuilder builder) {
        Serde<String> stringSerde = Serdes.String();
        JsonSerde<Entity> entityJsonSerde = new JsonSerde<>(Entity.class);
        JsonSerde<Entity2> entity2JsonSerde = new JsonSerde<>(Entity2.class);
        JsonSerde<EntityJoin> entityJoinJsonSerde = new JsonSerde<>(EntityJoin.class);

        KStream<String, Entity> entityKStream = builder.stream("teste",
                Consumed.with(stringSerde, entityJsonSerde));
        KStream<String, Entity2> entity2KStream = builder.stream("teste2",
                Consumed.with(stringSerde, entity2JsonSerde));


        entityKStream.join(entity2KStream, this::joiner, JoinWindows.of(Duration.ofHours(1)),
                StreamJoined.with(stringSerde, entityJsonSerde, entity2JsonSerde))
                .peek((s, entityJoin) -> System.out.println("***result: "+s+" - "+entityJoin))
                .to("testejoined");

        return entityKStream;
    }

    public EntityJoin joiner(Entity entity, Entity2 entity2) {
        return new EntityJoin(entity.getName(), entity.getSurname(), entity2.getNickname());
    }
}
