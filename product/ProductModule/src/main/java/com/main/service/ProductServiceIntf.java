package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.model.Product;

public interface ProductServiceIntf {

	void saveProduct(Product pro);

	List<Product> fetchDetails();

	Optional<Product> viewProductDetails(int id);

	void deleteById(int id);

}
