package com.qfedu.service.Impl;

import java.util.List;

import com.qfedu.Dao.Icartitem;
import com.qfedu.Dao.Impl.CartitemImpl;
import com.qfedu.entity.Cartitem;
import com.qfedu.service.CartitemService;

public class CartitemServiceImpl implements CartitemService {
	Icartitem icar = new CartitemImpl();
	

	@Override
	public int addCartitem(Cartitem car) {
		return icar.addCartitem(car);
	}

	@Override
	public int deleteCartitem(Cartitem car) {
		return icar.deleteCartitem(car);
	}

	@Override
	public int updateCartitem(Cartitem car) {
		return icar.updateCartitem(car);
	}

	@Override
	public List<Cartitem> getAll() {
		return icar.getAll();
	}

	@Override
	public List<Cartitem> getCartitem(String naem, int pid) {
		// TODO Auto-generated method stub
		return icar.getCartitem(naem, pid);
	}

	@Override
	public Cartitem getCartitemId(int pid) {
		// TODO Auto-generated method stub
		return icar.getCartitemId(pid);
	}

	@Override
	public int deleteAll(Cartitem car) {
		// TODO Auto-generated method stub
		return icar.deleteAll(car);
	}


}
