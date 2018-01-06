package com.msita.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msita.training.dao.TableListDAO;
import com.msita.training.entity.Item;
import com.msita.training.entity.Table;
import com.msita.training.vo.Order;
//import com.msita.training.vo.Table;

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
	
	public void addItemToOrder(String idItem,int idTable) {
		Table table=tableListDAO.findTableById(idTable);
		if(table.getOrderNotPay()==null) {
			tableListDAO.addOrder();
		}else{
			tableListDAO.addItem(idItem,table.getOrderNotPay().getIdOrder());
		}
	}
}
