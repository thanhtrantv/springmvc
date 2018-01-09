package com.msita.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msita.training.dao.TableListDAO;
import com.msita.training.entity.Item;
import com.msita.training.entity.Order;
import com.msita.training.entity.OrderItem;
import com.msita.training.entity.Table;

@Service
public class TableListService {
	@Autowired
	private TableListDAO tableListDAO;
	
	public List<Table> findAllListTable(){
		return tableListDAO.findAllListTable();
	}
	public List<Item> findAllItem(){
		return tableListDAO.findAllItem();
	}
	/**
	 * add order
	 * @param idItem
	 * @param idTable
	 */
	public void addItemToOrder(String idItem,int idTable) {
		Table table=tableListDAO.findTableById(idTable);
		if(table.getOrderNotPay()==null) {
			tableListDAO.addOrder(idTable);
			table=tableListDAO.findTableById(idTable);
			tableListDAO.addItem(idItem,table.getOrderNotPay().getIdOrder());
		}else{
			if(tableListDAO.checkExistingItem(idItem, table.getOrderNotPay().getIdOrder())) {
				tableListDAO.updateQuantity(idItem, table.getOrderNotPay().getIdOrder());
			}else {
				tableListDAO.addItem(idItem,table.getOrderNotPay().getIdOrder());
			}
		}
		calculateSum(table.getOrderNotPay().getIdOrder());
	}
	
	public void calculateSum(String idOrder) {
		Order order = tableListDAO.findOrderById(idOrder);
		double sum =0;
		for (OrderItem item : order.getLstOrderItem()) {
			sum += item.getItem().getPrice()*item.getQuantity();
		}
		order.setSum(sum);
		tableListDAO.updateOrder(order);
	}
	public void updatePaidOrder(String idOrder) {
		Order order = tableListDAO.findOrderById(idOrder);
		order.setIdStatus("DTT");
		tableListDAO.updateOrder(order);
	}
}
