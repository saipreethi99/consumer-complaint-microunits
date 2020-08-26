package com.dxctraining.consumermgt.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.consumermgt.consumer.dao.IConsumerDao;
import com.dxctraining.consumermgt.consumer.entities.Consumer;
import com.dxctraining.consumermgt.exceptions.ConsumerNotFoundException;
import com.dxctraining.consumermgt.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ConsumerServiceImpl implements IConsumerService {

   @Autowired
    private IConsumerDao dao;

    @Override
    public Consumer findConsumerById(int id) {
    	validateId(id);
		Consumer consumer = dao.findConsumerById(id);
		return consumer;
	}

	private void validateId(int id) {
		if(id == 0) {
			throw new InvalidArgumentException("id should not be null");
		}
		
	}

	@Override
	public Consumer add(Consumer consumer) {
		validate(consumer);
		consumer = dao.add(consumer);
		return consumer;
	}

	private void validate(Consumer consumer) {
		if(consumer == null) {
			throw new ConsumerNotFoundException("consumer should not be null");
		}
		
	}
	@Override
	public List<Consumer> displayAllConsumers() {
		List<Consumer>list = dao.displayAllConsumers();
		return list;
	}

   
}
