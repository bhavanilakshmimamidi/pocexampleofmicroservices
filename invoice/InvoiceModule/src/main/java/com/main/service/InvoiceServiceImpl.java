package com.main.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.InvoiceRepository;
import com.main.model.Invoice;
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceServiceIntf {
	@Autowired
	InvoiceRepository  invRepo;
	public void saveInvoice(Invoice invo) {
		
		invRepo.save(invo);	
	}
	
	public List<Invoice> fetchDetails() {
		
		return invRepo.findAll();
	}

	
	public Optional<Invoice> viewInvoiceDetails(int in_Id) {
		
		return invRepo.findById(in_Id);
	}

	
	public Optional<Invoice> buyUsingOrderId(int orderId) {
		
		return invRepo.findById(orderId);
	
	}
}
