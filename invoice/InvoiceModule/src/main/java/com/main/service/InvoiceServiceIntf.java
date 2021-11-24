package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.model.Invoice;

public interface InvoiceServiceIntf {

	void saveInvoice(Invoice invo);

	List<Invoice> fetchDetails();

	Optional<Invoice> viewInvoiceDetails(int in_Id);

	Optional<Invoice> buyUsingOrderId(int orderId);

}
