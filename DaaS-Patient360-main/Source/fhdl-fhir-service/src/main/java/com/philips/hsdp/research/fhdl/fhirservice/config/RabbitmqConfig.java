// /* /**
  // * (C) Koninklijke Philips Electronics N.V. 2021
  // *
  // * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  // * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  // * the copyright owner. 
  // **/
 
// package com.philips.hsdp.research.fhdl.fhirservice.config;

// import org.springframework.amqp.core.Binding;
// import org.springframework.amqp.core.BindingBuilder;
// import org.springframework.amqp.core.DirectExchange;
// import org.springframework.amqp.core.Queue;
// import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
// import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
// import org.springframework.amqp.rabbit.connection.ConnectionFactory;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import com.philips.hsdp.research.fhdl.fhirservice.constant.Constants;

// /*
 // * @author Rajeshwar Tondare
 // */

// @Configuration
// public class RabbitmqConfig {

	// @Bean
	// Queue queue() {
		// return new Queue(Constants.RMQ_QUEUE, true);
	// }

	// @Bean
	// DirectExchange exchange() {
		// return new DirectExchange(Constants.RMQ_EXCHANGE);
	// }

	// @Bean
	// Binding binding(Queue queue, DirectExchange exchange) {
		// return BindingBuilder.bind(queue).to(exchange).with(Constants.RMQ_BINDING_KEY);
	// }

	// @Bean
	// public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		// SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		// factory.setConnectionFactory(connectionFactory());
		// return factory;
	// }

	// @Bean
	// ConnectionFactory connectionFactory() {
		// CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(
				// System.getProperty("hostname"));
		// cachingConnectionFactory.setUsername(System.getProperty("admin_username"));
		// cachingConnectionFactory.setPassword(System.getProperty("admin_password"));
		// cachingConnectionFactory.setPort(Integer.parseInt(System.getProperty("port")));
		// cachingConnectionFactory.setVirtualHost(System.getProperty("vhost"));
		// return cachingConnectionFactory;
	// }
// }
 