package com.qfedu.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.qfedu.entity.Cartitem;

public class Cart {

	List<Cartitem> items= new ArrayList<Cartitem>();
	public List<Cartitem> getItems(){
		
		return items;
	}

	public void setItems(List<Cartitem> items) {
		this.items = items;
	}
	public void add(Cartitem item) {
		((List<Cartitem>) item).add(item);
		
	}
}
