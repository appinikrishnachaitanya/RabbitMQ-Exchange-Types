package com.rabbitmq.basics.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
   @Bean
   public Queue marketingQueue()
   {
	   return new Queue("marketingQueue");   
   }
   
   @Bean
   public Queue financeQueue()
   {
	   return new Queue("financeQueue");
	   
   }
   
   @Bean
   public Queue hrQueue()
   {
	   return new Queue("hrQueue");
   }
   
   @Bean
   public Queue allQueues()
   {
	   return new Queue("allQueues");
   }
   
   @Bean
//   public DirectExchange exchange()
//   {
//	   return new DirectExchange("department_exchange");
//   }
   
//   public FanoutExchange exchange()
//   {
//	   return new FanoutExchange("fanoutExchange");
//   }
   
   
   public TopicExchange exchange()
   {
	  return new TopicExchange("topicexchange");
   }
   
   
   @Bean
   public Binding marketingBinding()
   {
//	   return BindingBuilder.bind(marketingQueue()).to(exchange()).with("marketing"); //direct exchange
	   
	   return BindingBuilder.bind(marketingQueue()).to(exchange()).with("queue.marketing");
   }
   
   @Bean
   public Binding financeBinding()
   {
//	   return BindingBuilder.bind(financeQueue()).to(exchange()).with("finance");
	   return BindingBuilder.bind(financeQueue()).to(exchange()).with("queue.finance");
   }
   
   @Bean
   public Binding hrBinding()
   {
//	   return  BindingBuilder.bind(hrQueue()).to(exchange()).with("hr");
	   return  BindingBuilder.bind(hrQueue()).to(exchange()).with("queue.hr");
   }
   
   
   //the queue for the understanding the topic Exchange
   
   @Bean
   
   public Binding allqueues()
   {
	   return BindingBuilder.bind(allQueues()).to(exchange()).with("queue.*");
   }
   
	
	
	
}   
