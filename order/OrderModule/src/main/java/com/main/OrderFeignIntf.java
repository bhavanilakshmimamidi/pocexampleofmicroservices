package com.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="PRODUCT-SERVICE")


public interface OrderFeignIntf {
	@GetMapping("/product/buyUsingId/{id}")
	String findProductByIdResponse(@PathVariable("id") int id);

	

	

	
	
}
