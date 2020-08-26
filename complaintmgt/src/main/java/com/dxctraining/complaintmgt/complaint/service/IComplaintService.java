package com.dxctraining.complaintmgt.complaint.service;

import java.util.List;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;

public interface IComplaintService {

    Complaint findComplaintById(int id);
    
    Complaint add(Complaint complaint);

    List<Complaint> displayAllComplaints();

    List<Complaint> allComplaintsByConsumer(int consumerId);
}
