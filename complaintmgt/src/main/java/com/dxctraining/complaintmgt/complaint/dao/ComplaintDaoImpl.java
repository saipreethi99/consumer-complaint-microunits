package com.dxctraining.complaintmgt.complaint.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;
import com.dxctraining.complaintmgt.exceptions.ComplaintNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ComplaintDaoImpl implements IComplaintDao{

    
    @Autowired
    private EntityManager entityManager;

    @Override
    public Complaint findComplaintById(int id) {
    	Complaint complaint = entityManager.find(Complaint.class, id);
        if(complaint==null){
            throw new ComplaintNotFoundException("complaint not found for id="+id);
        }
        return complaint;
    }

	@Override
	public Complaint add(Complaint complaint){
		entityManager.persist(complaint);
		return complaint;
	}

	@Override
	public List<Complaint> displayAllComplaints() {
		String jpaql = "from Complaint";
		TypedQuery<Complaint>query = entityManager.createQuery(jpaql, Complaint.class);
		List<Complaint>list = query.getResultList();
		return list;
	}

	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerId) {
		String jpaql = "from Complaint where consumerId=:consumer";
		TypedQuery<Complaint>query = entityManager.createQuery(jpaql, Complaint.class);
		query.setParameter("consumer", consumerId);
		List<Complaint> list = query.getResultList();
		return list;
	}

}
