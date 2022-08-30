package dev.fadyayad;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping
    public void publish(@RequestBody MessageRequest  messageRequest){
        Message message = new Message(messageRequest.message(), LocalDateTime.now());
        kafkaTemplate.send("general", message);
    }
}
