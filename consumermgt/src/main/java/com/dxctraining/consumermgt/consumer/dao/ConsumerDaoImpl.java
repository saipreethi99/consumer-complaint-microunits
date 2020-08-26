package com.dxctraining.consumermgt.consumer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.consumermgt.consumer.entities.Consumer;
import com.dxctraining.consumermgt.exceptions.ConsumerNotFoundException;

@Repository
public class ConsumerDaoImpl implements IConsumerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Consumer findConsumerById(int id) {
        Consumer consumer = entityManager.find(Consumer.class, id);
        if(consumer==null){
            throw new ConsumerNotFoundException("consumer not found for id="+id);
        }
        return consumer;
    }

	@Override
	public Consumer add(Consumer consumer) {
		entityManager.persist(consumer);
		return consumer;
	}

	@Override
	public List<Consumer> displayAllConsumers() {
		String jpaql = "from Consumer";
		TypedQuery<Consumer>query = entityManager.createQuery(jpaql, Consumer.class);
		List<Consumer>list = query.getResultList();
		return list;
	}

}
