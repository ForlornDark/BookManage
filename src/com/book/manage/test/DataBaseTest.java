package com.book.manage.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.book.manage.utils.DBHelper;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.ResultSetHandler;

public class DataBaseTest {
	@Test
	public void testConn(){
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "select count(*) from orders";
			runner.query(sql, new ResultSetHandler<Integer>() {

				@Override
				public Integer handle(ResultSet set) throws SQLException {
					// TODO Auto-generated method stub
					set.next();
					System.out.println(set.getString(1));
					return set.getInt(1);
				}
			});
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
