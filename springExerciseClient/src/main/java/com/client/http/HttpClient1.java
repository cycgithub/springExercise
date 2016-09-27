package com.client.http;

import com.client.BasicInterface;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chenyuchao on 2016/9/24.
 */
@Service
public class HttpClient1 implements BasicInterface{
//    @Resource
//    private MessageChannel qsqClientChannel;
    @Override
    public String doBusiness(String request){
        System.out.println("收到药师帮客户端请求：{}"+request);
        MessagingTemplate template = new MessagingTemplate();
        Message<String> requestMessage = MessageBuilder
                .withPayload(request)
                .setHeader("transCode", "abc")
                .setHeader("productCode", "01005")
                .setHeader("Accept", "*/*")
                .setHeader("Accept-Charset", "utf-8")
                .setHeader("Content-Type", "application/json;charset=UTF-8")
                .build();
        Message reply ;//= template.sendAndReceive(qsqClientChannel, requestMessage);
        return "dfgsd";//reply.getPayload().toString();
    }
}
