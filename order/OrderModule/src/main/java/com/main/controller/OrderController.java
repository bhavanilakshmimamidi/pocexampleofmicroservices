package com.main.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.main.OrderFeignIntf;
import com.main.model.Order;
import com.main.model.Product;
import com.main.service.OrderServiceIntf;

@RestController
@RequestMapping("/order")
public class OrderController {
@Autowired
 OrderServiceIntf orderServiceIntf;

@Autowired
OrderFeignIntf  orderFeignIntf;

	  @PostMapping("/saveorder/{orderId}") 
	  public ResponseEntity<String>
	  saveOrder(@RequestBody Order order, @PathVariable("orderId") int orderId){ orderServiceIntf.saveOrder(order);
	  	  return new ResponseEntity<String>("Order placed successfully with id:" +orderId,HttpStatus.CREATED); }
	
	  
	    @GetMapping("/buyUsingOrderId/{orderId}")
	    public ResponseEntity<Order> buyUsingId(@PathVariable("orderId") int orderId) {
	        Order order = orderServiceIntf.buyUsingOrderId(orderId).get();
	        if (order!=null)
	            return new ResponseEntity<>(order, HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    @GetMapping("/getTotalAmount/{orderId}")
	    public double getTotalAmount(@PathVariable("orderId") int orderId) {
	        Order order = orderServiceIntf.buyUsingOrderId(orderId).get();
	        Product product =orderFeignIntf.buyUsingId(order.getOrderid()).getBody();
	        double totalAmount = ((product.getPrice())*(order.getQuantity()));
	        System.out.println(totalAmount);
	        return totalAmount;
	    }
	    
		  
	  
	  
  @GetMapping("/orderdetails")
public ResponseEntity<List<Order>> fetchDetails(){
	List<Order> ord=orderServiceIntf.fetchDetails();
	if(ord.isEmpty()) 
    {
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
    return new ResponseEntity<>(ord,HttpStatus.OK);
}	

@GetMapping("/getorderview/{orderId}")
public ResponseEntity<Optional<Order>> getUserByPath(@PathVariable("orderId") int orderId) {
	System.out.println(orderId);
	Optional<Order> option = orderServiceIntf.viewOrderDetails(orderId);
	if (option.isPresent())
		return new ResponseEntity<>(option, HttpStatus.OK);
	else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}












}


