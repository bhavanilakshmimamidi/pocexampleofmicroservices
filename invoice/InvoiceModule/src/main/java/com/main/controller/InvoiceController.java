package com.main.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.InvoiceFeignIntf;
import com.main.model.Invoice;

import com.main.service.InvoiceServiceIntf;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;


@RestController
@RequestMapping("/invoice")
public class InvoiceController {
@Autowired
InvoiceServiceIntf invoServiceIntf;

@Autowired 
InvoiceFeignIntf  invoiceFeignIntf;


@Autowired
Order order;

@PostMapping("/saveInvoice")
public ResponseEntity<String> saveRegister(@RequestBody Invoice invo) {
    double totalAmount = invoiceFeignIntf.getTotalAmount(invo.getO_id());
       
    
    invoiceFeignIntf.saveInvoiceDetails(invo,totalAmount);
        
        return new ResponseEntity<String>("Invoice Added Successfully", HttpStatus.CREATED);
    }
    
    
   

@GetMapping("/invoicedetails")
public ResponseEntity<List<Invoice>> fetchDetails(){
	List<Invoice> inv=invoServiceIntf.fetchDetails();
	if(inv.isEmpty()) 
    {
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
    return new ResponseEntity<>(inv,HttpStatus.OK);
		
}
@GetMapping("/getinvoiceview/{in_Id}")
public ResponseEntity<Optional<Invoice>> getUserByPath(@PathVariable("in_Id") int in_Id) {
	System.out.println(in_Id);
	Optional<Invoice> option = invoServiceIntf.viewInvoiceDetails(in_Id);
	if (option.isPresent())
		return new ResponseEntity<>(option, HttpStatus.OK);
	else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
}