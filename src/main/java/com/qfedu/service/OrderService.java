package com.qfedu.service;

import java.util.List;

import com.qfedu.entity.OrderCartitem;

public interface OrderService {

	OrderCartitem getOrderId(int id);
	List<OrderCartitem> getOrder();
	int addOrder(OrderCartitem ord);
	int updateOrder(OrderCartitem ord);
	List<OrderCartitem> getremai();
}
