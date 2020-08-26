package com.dxctraining.consumermgt.consumer.service;

import java.util.*;

import com.dxctraining.consumermgt.consumer.entities.Consumer;

public interface IConsumerService {

    Consumer findConsumerById(int id);

    Consumer add(Consumer consumer);
    
    List<Consumer> displayAllConsumers();
}
