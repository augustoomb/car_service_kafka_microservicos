package com.analytics.data.message;

import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.service.PostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


// CONSUMIR INFORMAÇÕES QUE O KAFKA ENVIAR

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumerMessage.class); // CAST FEITO PELA IDE

    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group") // É UM LISTENER. VAI FICAR OUVINDO ESSE TOPICO DO APACHE KAFKA
    public void listening(@Payload CarPostDTO carPost) {

        System.out.println("Received Car Post information: " + carPost);
        LOG.info("ANALYTICS DATA - Received Car Post information: {}", carPost);
        postAnalyticsService.saveDataAnalytics(carPost);
    }

}

