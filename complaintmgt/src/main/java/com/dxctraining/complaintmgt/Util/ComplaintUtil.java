package com.dxctraining.complaintmgt.Util;

import org.springframework.stereotype.Component;

import com.dxctraining.complaintmgt.complaint.dto.ComplaintDto;
import com.dxctraining.complaintmgt.complaint.entities.Complaint;

@Component
public class ComplaintUtil {
	public ComplaintDto complaintDto(Complaint complaint, int consumerId, String consumerName) {
		ComplaintDto dto = new ComplaintDto(complaint.getId(),complaint.getDescription(),complaint.getConsumerId(),consumerName);
		dto.setConsumerId(consumerId);
		dto.setConsumerName(consumerName);
		dto.setDescription(complaint.getDescription());
		return dto;
	}

}
