package com.msita.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msita.training.dao.TableListDAO;
import com.msita.training.vo.Order;
import com.msita.training.vo.Table;

@Service
public class TableListService {
	@Autowired
	private TableListDAO tableListDAO;
	
	public List<Table> findAllListTable(){
		List<Table> lstTable = tableListDAO.findAllListTable();
		for(Table table: lstTable) {
			//tim order chua thanh toan
			Order order = tableListDAO.findOrderNotPay(table.getIdTable());
			if(order!=null) {
				order.setLstOrderItem(tableListDAO.getOrderItemByOrderId(order.getOrderId()));
			}
			
			table.setOrder(order);
			
		}
		return lstTable;
	}
	
}
