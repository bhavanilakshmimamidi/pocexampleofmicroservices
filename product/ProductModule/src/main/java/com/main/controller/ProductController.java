package com.main.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.main.model.Product;
import com.main.service.ProductServiceIntf;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductServiceIntf serviceIntf;
	
	@PostMapping("/saveproducts")
	 public ResponseEntity<String> saveProduct(@RequestBody Product product )
    {
		serviceIntf.saveProduct(product);
        return new ResponseEntity<String>("saved Successfully", HttpStatus.CREATED);
    }    
    @GetMapping("/productdetails")
    public ResponseEntity <List<Product>> fetchDetails()
    {
        List<Product> pro=serviceIntf.fetchDetails();
        if(pro.isEmpty()) 
        {
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
        return new ResponseEntity<>(pro,HttpStatus.OK);
}	
    
    @GetMapping("/getproductview/{id}")
    public ResponseEntity<Optional<Product>> getUserByPath(@PathVariable("id") int id) {
    	System.out.println(id);
    	Optional<Product> option = serviceIntf.viewProductDetails(id);
    	if (option.isPresent())
    		return new ResponseEntity<>(option, HttpStatus.OK);
    	else
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable int id) {
    	serviceIntf.deleteById(id);
    	
    	
    }

}
