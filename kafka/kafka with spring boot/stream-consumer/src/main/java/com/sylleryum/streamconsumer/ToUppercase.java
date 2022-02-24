package com.sylleryum.streamconsumer;

import com.sylleryum.producer.entity.Entity;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.support.serializer.JsonSerde;

@Configuration
@EnableKafkaStreams
public class ToUppercase {

    @Bean
    public KStream<String, Entity> toUppercaseStream(StreamsBuilder builder){
        Serde<String> stringSerde = Serdes.String();
        JsonSerde<Entity> jsonSerde = new JsonSerde<>(Entity.class);

        KStream<String, Entity> sourceStream = builder.stream("teste", Consumed.with(stringSerde, jsonSerde));
        KStream<String, Entity> uppercaseStream = sourceStream.mapValues(this::toUppercase);

        uppercaseStream.to("teste-uppercase", Produced.with(stringSerde, jsonSerde));

        sourceStream.print(Printed.<String,Entity>toSysOut().withLabel("===original"));
        uppercaseStream.print(Printed.<String,Entity>toSysOut().withLabel("===Stream modified"));

        return sourceStream;
    }

    private Entity toUppercase(Entity entity) {
        return new Entity(entity.getName().toUpperCase(), entity.getSurname().toUpperCase());
    }
}
