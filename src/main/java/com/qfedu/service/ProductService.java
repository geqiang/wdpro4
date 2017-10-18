package com.qfedu.service;

import java.util.List;

import com.qfedu.entity.Product;

public interface ProductService {
	
	List<Product> getProduct();
	int addProduct(Product pro);
	int deleteProduct(Product pro);
	int updateProduct(Product pro);
	Product getProductId(int pid);
	int delete2Product(int pid);


}
