package com.msita.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.msita.training.vo.User;

@Repository
public class LoginDAO extends BaseDAO {
	public User login(String username) {
		User user = getJdbcTemplateObject().query("SELECT username,password,fullname from users where username=?",
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement arg0) throws SQLException {
						arg0.setString(1, username);
					}
				}, new ResultSetExtractor<User>() {
					@Override
					public User extractData(ResultSet ret) throws SQLException, DataAccessException {
						User user = null;
						if(ret.next()) {
							user = new User();
							user.setUsername(ret.getString("username"));
							user.setPassword(ret.getString("password"));
							user.setFullName(ret.getString("fullname"));
						}
						return user;
					}
				});
		return user;
	}
}
