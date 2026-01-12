package com.portal.api.message;

import com.portal.api.dto.CarPostDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}") // CONFIGURADO NO application.properties
    private String bootstrapServer;


    /*
    FÁBRICA PRODUTORA DE MENSAGENS PARA DENTRO DO KAFKA, CHAVE VALOR, COM UMA CHAVE STRING E COMO VALOR O CarPostDTO
     */
    @Bean
    public ProducerFactory<String, CarPostDTO> userProducerFactory() {

        Map<String, Object> configProps = new HashMap<>();

        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer); // VALOR DE ProducerConfig.BOOTSTRAP_SERVERS_CONFIG SERÁ bootstrapServer, OU SEJA, O VALOR DA VARIÁVEL GLOBAL
        configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false); // DIZENDO QUE NÃO (FALSE) VOU MANDAR NENHUM JSON NO HEADER DA SOLICITAÇÃO
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // SERIALIZAÇÃO NORMAL, VIA STRING
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName()); // SERIALIZAÇÃO DO CORPO (BODY) SERÁ COM JSON

        return new DefaultKafkaProducerFactory<>(configProps); // DefaultKafkaProducerFactory É PRONTO DO KAFKA. SÓ VOU JOGAR AS MINHAS INFOS PRA DENTRO DELA

    }

    @Bean
    public KafkaTemplate<String, CarPostDTO> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
}
