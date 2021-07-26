/*
 * DemoProcessor.java 2021. 07. 26
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.demoprocessor;

import java.util.function.Function;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongju.paek
 */
@Slf4j
@Configuration
public class DemoProcessor {

	@Bean
	public NewTopic createSquaredNumberTopic() {
		return new NewTopic("squaredNumbers", 1, (short)1);
	}

	@Bean
	public Function<KStream<String, Long>, KStream<String, Long>> evenNumberSquareProcessor() {
		return kStream -> kStream
			.filter((k, v) -> v % 2 == 0)
			.peek((k, v) -> log.info("Squaring Event : {}", v))
			.mapValues(v -> v * v);
	}
}