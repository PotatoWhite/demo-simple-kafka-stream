/*
 * DemoConsumer.java 2021. 07. 26
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.democonsumer;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongju.paek
 */
@Slf4j
@Configuration
public class DemoConsumer {

	@Bean
	public Consumer<KStream<String, Long>> squaredNumberConsumer() {
		return stream -> stream.foreach((key, value) -> log.info("Squared Number Consumed: {}", value));
	}
}