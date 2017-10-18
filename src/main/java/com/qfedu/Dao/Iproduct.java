package com.qfedu.Dao;

import java.util.List;

import com.qfedu.entity.Product;;

public interface Iproduct {

	
	List<Product> getProduct();
	int addProduct(Product pro);
	int deleteProduct(Product pro);
	int updateProduct(Product pro);
	Product getProductId(int pid);
	int delete2Product(int pid);

}
