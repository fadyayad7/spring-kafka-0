package dev.fadyayad;

import dev.fadyayad.utils.LoopFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafka0Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafka0Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
        return args -> {
            LoopFactory.execute(5, () -> kafkaTemplate.send("general", "Hey dad 👋"));
        };
    }

}
