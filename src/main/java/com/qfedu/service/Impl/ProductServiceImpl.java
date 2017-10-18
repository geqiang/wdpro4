package com.qfedu.service.Impl;

import java.util.List;

import com.qfedu.Dao.Iproduct;
import com.qfedu.Dao.Impl.ProductImpl;
import com.qfedu.entity.Product;
import com.qfedu.service.ProductService;

public class ProductServiceImpl implements ProductService {
	Iproduct ipro = new ProductImpl();
	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return ipro.getProduct();
	}

	@Override
	public int addProduct(Product pro) {
		// TODO Auto-generated method stub
		return ipro.addProduct(pro);
	}

	@Override
	public int deleteProduct(Product pro) {
		// TODO Auto-generated method stub
		return ipro.deleteProduct(pro);
	}

	@Override
	public int updateProduct(Product pro) {
		// TODO Auto-generated method stub
		return ipro.updateProduct(pro);
	}

	@Override
	public Product getProductId(int pid) {
		// TODO Auto-generated method stub
		return ipro.getProductId(pid);
	}

	@Override
	public int delete2Product(int pid) {
		// TODO Auto-generated method stub
		return ipro.delete2Product(pid);
	}



}
