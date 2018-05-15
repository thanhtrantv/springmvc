package com.msita.training.dao;

import com.msita.training.entity.Product;
import com.msita.training.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDAO extends BaseDAO{
    @Transactional
    public List<Product> getProducts() {
        List<Product> lst = getJdbcTemplateObject().query(
                "SELECT * from product", new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                        Product product = new Product();
                        product.setProductId(resultSet.getString("idproduct"));
                        product.setDescription(resultSet.getString("description"));
                        product.setTitle(resultSet.getString("title"));
                        product.setImage(resultSet.getString("image"));
                        return product;
                    }
                });
        return lst;
    }
}
