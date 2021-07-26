/*
 * DemoProducer.java 2021. 07. 26
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.demoproducer;

import java.time.Duration;
import java.util.function.Supplier;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;

/**
 * @author dongju.paek
 */
@Configuration
public class DemoProducer {

	@Bean
	public NewTopic createNumberTopic() {
		return new NewTopic("numbers", 1, (short)1);
	}

	@Bean
	public Supplier<Flux<Long>> numberProducer() {
		return () -> Flux.range(1, 1000)
			.map(i -> (long)i)
			.delayElements(Duration.ofSeconds(1));
	}
}