package com.dxctraining.consumermgt.consumer.dao;

import java.util.List;

import com.dxctraining.consumermgt.consumer.entities.Consumer;

public interface IConsumerDao {

    Consumer findConsumerById(int id);

    Consumer add(Consumer consumer);
    
    List<Consumer> displayAllConsumers();

}
