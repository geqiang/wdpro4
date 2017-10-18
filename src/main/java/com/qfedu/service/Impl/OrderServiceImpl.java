package com.qfedu.service.Impl;

import java.util.List;

import com.qfedu.Dao.IorderCartitem;
import com.qfedu.Dao.Impl.OrderCartitemImpl;
import com.qfedu.entity.OrderCartitem;

public class OrderServiceImpl implements com.qfedu.service.OrderService {
	IorderCartitem iord = new OrderCartitemImpl();
	@Override
	public List<OrderCartitem> getOrder() {
		return iord.getOrder();
	}

	@Override
	public int addOrder(OrderCartitem ord) {
		return iord.addOrder(ord);
	}

	@Override
	public OrderCartitem getOrderId(int id) {
		return iord.getOrderId(id);
	}

	@Override
	public int updateOrder(OrderCartitem ord) {
		return iord.updateOrder(ord);
	}

	@Override
	public List<OrderCartitem> getremai() {
		return iord.getremai();
	}

}
