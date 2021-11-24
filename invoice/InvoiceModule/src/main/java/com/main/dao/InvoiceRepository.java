package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Invoice;

public interface InvoiceRepository  extends JpaRepository<Invoice, Integer>{

	
	
}
