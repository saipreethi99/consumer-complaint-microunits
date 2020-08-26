package com.dxctraining.complaintmgt.complaint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.complaintmgt.complaint.dao.IComplaintDao;
import com.dxctraining.complaintmgt.complaint.entities.Complaint;
import com.dxctraining.complaintmgt.exceptions.ComplaintNotFoundException;
import com.dxctraining.complaintmgt.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	private IComplaintDao dao;

	@Override
	public Complaint findComplaintById(int id) {
		validateId(id);
		Complaint complaint = dao.findComplaintById(id);
		return complaint;
	}

	private void validateId(int id) {
		if (id == 0) {
			throw new InvalidArgumentException("id should not be null");
		}

	}

	@Override
	public List<Complaint> displayAllComplaints() {
		List<Complaint> complaints = dao.displayAllComplaints();
		return complaints;
	}

	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerId) {
		List<Complaint> list = dao.allComplaintsByConsumer(consumerId);
		return list;
	}

	@Override
	public Complaint add(Complaint complaint) {
		validate(complaint);
		complaint = dao.add(complaint);
		return complaint;
	}

	private void validate(Complaint complaint) {
		if(complaint == null) {
			throw new ComplaintNotFoundException("Complaint not found");
		}
		
	}
}
