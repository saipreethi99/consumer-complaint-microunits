package com.dxctraining.complaintmgt.complaint.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.complaintmgt.Util.ComplaintUtil;
import com.dxctraining.complaintmgt.complaint.dto.ComplaintDto;
import com.dxctraining.complaintmgt.complaint.dto.ConsumerDto;
import com.dxctraining.complaintmgt.complaint.dto.CreateComplaintRequest;
import com.dxctraining.complaintmgt.complaint.entities.Complaint;
import com.dxctraining.complaintmgt.complaint.service.IComplaintService;


@RestController
@RequestMapping("/complaints")
public class ComplaintRestController {

    @Autowired
    private IComplaintService complaintservice;
    
    @Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ComplaintUtil complaintUtil;

    @PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ComplaintDto add(@RequestBody CreateComplaintRequest requestData) {
    	Complaint complaint = new Complaint();
    	String description=requestData.getDescription();
		int consumerId=requestData.getConsumerId();
		complaint=complaintservice.add(complaint);
		ConsumerDto consumerdto=fetchFromConsumerById(consumerId);
		ComplaintDto response = complaintUtil.complaintDto(complaint, consumerId, consumerdto.getName());
		return response;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ComplaintDto getComplaint(@PathVariable("id") int id) {
		Complaint complaint = complaintservice.findComplaintById(id);
		int consumerId=complaint.getConsumerId();
		ConsumerDto consumerdto=fetchFromConsumerById(consumerId);
		ComplaintDto response = complaintUtil.complaintDto(complaint, consumerId, consumerdto.getName());
		return response;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	public List<ComplaintDto> fetchAll() {
		List<Complaint> list = complaintservice.displayAllComplaints();
		List<ComplaintDto> response = new ArrayList<>();
		for (Complaint complaint : list) {
			int consumerId=complaint.getConsumerId();
			ConsumerDto consumerdto=fetchFromConsumerById(consumerId);
			ComplaintDto complaintdto = complaintUtil.complaintDto(complaint, consumerId, consumerdto.getName());
			response.add(complaintdto);
		}
		return response;
	}
	
	@GetMapping("/consumers/{consumerId}")
	@ResponseStatus(HttpStatus.FOUND)
	public List<ComplaintDto> fetchAllComplaintsByConsumer(@PathVariable("consumerId")int consumerId) {
		List<Complaint> list = complaintservice.allComplaintsByConsumer(consumerId);
		List<ComplaintDto> response = new ArrayList<>();
		ConsumerDto consumerDto = fetchFromConsumerById(consumerId);
		for (Complaint complaint : list) {
			ComplaintDto complaintdto = complaintUtil.complaintDto(complaint, consumerId, consumerDto.getName());
			response.add(complaintdto);
		}
		return response;
	}
	

	 public ConsumerDto fetchFromConsumerById(int consumerId) {
	 String url = "http://localhost:8586/consumers/get/" + consumerId;
	 ConsumerDto dto = restTemplate.getForObject(url, ConsumerDto.class);
	 return dto;
	}
}





