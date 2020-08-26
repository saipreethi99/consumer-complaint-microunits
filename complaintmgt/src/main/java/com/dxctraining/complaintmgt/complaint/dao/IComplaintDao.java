package com.dxctraining.complaintmgt.complaint.dao;

import java.util.List;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;

public interface IComplaintDao {

	Complaint findComplaintById(int id);

	Complaint add(Complaint consumer);

	List<Complaint> displayAllComplaints();

	List<Complaint> allComplaintsByConsumer(int consumerId);
}
