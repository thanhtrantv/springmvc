package com.msita.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msita.training.service.TableListService;
import com.msita.training.vo.Table;

@Controller
@RequestMapping("/danhsachban")
public class TableListController {
	
	@Autowired
	private TableListService tableListService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String goToFormDanhSachBan() {
		
		return "danhsachban";
	}
	
	@ResponseBody
	@RequestMapping(value="/getTables",method = RequestMethod.GET)
	public List<Table> getTables(){
		List<Table> lst = tableListService.findAllListTable();
		System.out.println("YYYYYYY:"+lst.size());
		for(Table table: lst) {
			if(table.getOrder()!=null) {
				System.out.println("table::"+table.getOrder().getOrderId());
				System.out.println("item:"+table.getOrder().getLstOrderItem().get(0).getItemId());
			}
			
		}
		return lst;
	}
}
