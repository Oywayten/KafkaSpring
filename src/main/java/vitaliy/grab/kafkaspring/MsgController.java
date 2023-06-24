package vitaliy.grab.kafkaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * Oywayten 23.06.2023.
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    private final KafkaTemplate<Long, String> kafkaTemplate;

    @Autowired
    public MsgController(KafkaTemplate<Long, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /*@PostMapping
    public void sendOrder(String msgId, String msg) {
        kafkaTemplate.send("msg", msgId, msg);
    }*/

    @PostMapping
    public void sendMsg(Long msgId, String msg) {
        CompletableFuture<SendResult<Long, String>> future = kafkaTemplate.send("msg", msgId, msg);
//        future.whenComplete((stringStringSendResult, throwable) -> System.out.println(msg));
//        kafkaTemplate.flush();
    }
}

