package com.rabbitmq.basics.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitMQController {

	
	@Autowired
	private RabbitTemplate rbtm;
	
	
	@GetMapping("/publish")
	public void sendMessage(@RequestParam(name = "exchangeName")
	String exchangeName 
	, @RequestParam(name = "routingKey") String routingKey 
	, @RequestParam(name = "Msg") String Msg )
	{
	  
//		rbtm.convertAndSend(exchangeName,routingKey, Ms) //directExchange
//		rbtm.convertAndSend(exchangeName,"", Msg); // FanoutExchange
		
		rbtm.convertAndSend(exchangeName, routingKey, Msg);
		
	}
	
	
	
	
}
