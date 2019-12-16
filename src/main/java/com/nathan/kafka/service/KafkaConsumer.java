package com.nathan.kafka.service;

import com.nathan.kafka.model.SampleMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
@Service
public class KafkaConsumer {
    private CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics = "${sample.message.topic.name}", groupId = "samplemessage", containerFactory = "sampleMessageKafkaListenerContainerFactory")
    public void listenGroupSampleMessage(SampleMessage sampleMessage) {
        System.out.println("Received Messasge in group 'samplemessage': " + sampleMessage.toString());
        latch.countDown();
    }
}
