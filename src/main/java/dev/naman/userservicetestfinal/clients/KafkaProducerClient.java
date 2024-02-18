package dev.naman.userservicetestfinal.clients;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerClient {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerClient(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    // Message: jsonString of whatever data you want to send
    // {
    //   id: 1,
    //   name: Naman Bhalla,
    //   email: "naman@scaler.com"
    // }


}
