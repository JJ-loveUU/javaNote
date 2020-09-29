package com.example.demo.consume;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author yh
 * @Date 2020/9/14 19:40
 */
//@Component
//@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
//public class DirectReceiver {
//
//  @RabbitHandler
//  public void process(Map testMessage) {
//    System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
//  }
//
//}