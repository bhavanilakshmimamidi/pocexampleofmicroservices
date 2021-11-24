package com.main;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.model.Invoice;



@FeignClient(value = "order-service")
public interface InvoiceFeignIntf {

	@GetMapping("/order/getorderview/{orderId}")
	String findOrderByIdResponse(@PathVariable("orderId")int orderId);
		
	
    @GetMapping("/order/getTotalAmount/{orderId}")
    public double getTotalAmount(@PathVariable("orderId") int orderId);


	void saveInvoiceDetails(Invoice reg2, double totalAmount);


	void saveInvoiceDetails(double totalAmount);
	
	
}
