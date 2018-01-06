package com.msita.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msita.training.entity.Item;
import com.msita.training.entity.Table;
import com.msita.training.service.TableListService;
//import com.msita.training.vo.Table;

@Controller
@RequestMapping("/tableList")
public class TableListController {
	
	@Autowired
	private TableListService tableListService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String goToFormDanhSachBan() {
		
		return "tableList";
	}
	
	@ResponseBody
	@RequestMapping(value="/getTables",method = RequestMethod.GET)
	public List<Table> getTables(){
		return tableListService.findAllListTable();
	}
	
	@ResponseBody
	@RequestMapping(value="/getItems",method = RequestMethod.GET)
	public List<Item> getItems(){
		return tableListService.findAllItem();
	}
	
	@RequestMapping(value="/saveItem",method = RequestMethod.POST)
	public String saveItem(@RequestParam("checkitem") String checkItem,
			@RequestParam("tableId") int tableId){
		System.out.println(checkItem+"::::"+tableId);
		tableListService.addItemToOrder(checkItem,tableId);
		return "redirect:/tableList";
	}
}
