package com.main.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.ProductRepository;
import com.main.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductServiceIntf {
@Autowired
ProductRepository prodao;
public void saveProduct(Product pro) {
	prodao.save(pro);
		
}
public List<Product> fetchDetails() {
	
	return prodao.findAll();
}

public Optional<Product> viewProductDetails(int id) {
	
	return prodao.findById(id);
}

public void deleteById(int id) {
	
	prodao.deleteById(id);
}
}
