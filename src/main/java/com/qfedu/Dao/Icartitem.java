package com.qfedu.Dao;

import java.util.List;

import com.qfedu.entity.Cartitem;

public interface Icartitem {
	List<Cartitem> getAll();
	List<Cartitem> getCartitem(String naem,int pid);
	int addCartitem(Cartitem car);
	int deleteCartitem(Cartitem car);
	int updateCartitem(Cartitem car2 );
	Cartitem getCartitemId(int pid);
	int deleteAll(Cartitem car);
	Cartitem getCartitemName(String name);
}
