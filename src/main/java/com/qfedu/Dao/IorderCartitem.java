package com.qfedu.Dao;

import java.util.List;

import com.qfedu.entity.OrderCartitem;

public interface IorderCartitem {

	List<OrderCartitem> getOrder();
	int addOrder(OrderCartitem ord);
	OrderCartitem getOrderId(int id);
	int updateOrder(OrderCartitem ord);
	List<OrderCartitem> getremai();
}
