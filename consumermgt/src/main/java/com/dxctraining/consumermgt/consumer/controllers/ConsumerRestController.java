package com.dxctraining.consumermgt.consumer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.consumermgt.consumer.dto.ConsumerDto;
import com.dxctraining.consumermgt.consumer.dto.CreateConsumerRequest;
import com.dxctraining.consumermgt.consumer.entities.Consumer;
import com.dxctraining.consumermgt.consumer.service.IConsumerService;

@RestController
@RequestMapping("/consumers")
public class ConsumerRestController {

	@Autowired
	private IConsumerService consumerservice;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ConsumerDto add(@RequestBody CreateConsumerRequest requestData) {
		Consumer consumer = new Consumer();
		consumer.setName(requestData.getName());
		ConsumerDto response = toDto(consumer);
		return response;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ConsumerDto getConsumer(@PathVariable("id") int id) {
		Consumer consumer = consumerservice.findConsumerById(id);
		ConsumerDto response = toDto(consumer);
		return response;
	}

	public ConsumerDto toDto(Consumer consumer) {
		ConsumerDto dto = new ConsumerDto();
		dto.setId(consumer.getId());
		dto.setName(consumer.getName());
		return dto;
	}

	@GetMapping
	public List<ConsumerDto> fetchAll() {
		List<Consumer> list = consumerservice.displayAllConsumers();
		List<ConsumerDto> response = new ArrayList<>();
		for (Consumer consumer : list) {
			ConsumerDto consumerdto = toDto(consumer);
			response.add(consumerdto);
		}
		return response;
	}

}
