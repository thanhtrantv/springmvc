package com.msita.training.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.msita.training.vo.Order;
import com.msita.training.vo.OrderItem;
import com.msita.training.vo.Table;

@Repository
public class TableListDAO extends BaseDAO{
	public List<Table> findAllListTable(){
		List<Table> lst = (List<Table>) getJdbcTemplateObject().query("select * from cafedb.table",new RowMapper<Table>() {
			@Override
			public Table mapRow(ResultSet ret, int arg1) throws SQLException {
				Table table=new Table();
				table.setIdTable(ret.getInt("idtable"));
				table.setType(ret.getString("type"));
				return table;
			}
			
		});
			
		
		return lst;		
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderItem> getOrderItemByOrderId(String orderId){
		return getJdbcTemplateObject().query("select * from cafedb.order_item where idorder=?",new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement setter) throws SQLException {
				setter.setString(1, orderId);
			}
		},new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				OrderItem orderItem = new OrderItem();
				orderItem.setItemId(rs.getString("iditem"));
				orderItem.setOrderId(rs.getString("idorder"));
				orderItem.setTime(rs.getTimestamp("time"));
				return orderItem;
			}
		});
		
	}
	//tim order chua thanh toan
	public Order findOrderNotPay(int tableId) {
		Order order=getJdbcTemplateObject().query("select * from cafedb.order where idtable=? and idstatus='CTT'",new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement setter) throws SQLException {
				setter.setInt(1, tableId);
			}
		},new ResultSetExtractor<Order>() {
			@Override
			public Order extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Order order = new Order();
					order.setOrderId(rs.getString("idorder"));
					order.setSum(rs.getDouble("sum"));
					return order;
				}
				return null;
			}
		});
		 
		
		return order;
	}
}
