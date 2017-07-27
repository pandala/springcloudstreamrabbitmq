package com.ygb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
@SpringBootApplication
public class SenderApplication {
    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel channel;

    @RequestMapping(method = RequestMethod.GET, path = "/send")
    public void write (@RequestParam("ygb") String msg){
        channel.send(MessageBuilder.withPayload(msg).build());
    }

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }
}