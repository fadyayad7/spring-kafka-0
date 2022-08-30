package dev.fadyayad;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListeners {

    @KafkaListener(
            topics = "general",
            groupId = "someId",
            containerFactory = "messageFactory"
    )
    void listener (Message data){
        log.info("🚀 Received from Kafka: {}", data.message());
    }
}
