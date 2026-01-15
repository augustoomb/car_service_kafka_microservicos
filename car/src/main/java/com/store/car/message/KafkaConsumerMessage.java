package com.store.car.message;

import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


// CONSUMIR INFORMAÇÕES QUE O KAFKA ENVIAR

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumerMessage.class); // CAST FEITO PELA IDE

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group") // É UM LISTENER. VAI FICAR OUVINDO ESSE TOPICO DO APACHE KAFKA
    public void listening(CarPostDTO carPost) {

        LOG.info("CAR STORE - Received Car Post information: {}", carPost);
        carPostService.newPostDetails(carPost);
    }

}
