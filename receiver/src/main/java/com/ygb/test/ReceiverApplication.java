package com.ygb.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(Sink.class)
@IntegrationComponentScan
@MessageEndpoint
@SpringBootApplication
public class ReceiverApplication {
    @ServiceActivator(inputChannel=Sink.INPUT)
    public void accept(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        SpringApplication.run(ReceiverApplication.class, args);
    }
}