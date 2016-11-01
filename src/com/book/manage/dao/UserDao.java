package com.book.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.manage.bean.User;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.ResultSetHandler;

/**
 * @author lfm
 *
 */
public class UserDao {
	public User queryUser(User u) throws SQLException{
		QueryRunner runner = new QueryRunner();
		String sql = "select id,name from login where id = ? and password = ?";
		User user = runner.query(sql, new ResultSetHandler<User>(){

			@Override
			public User handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				User t = null;
				while(set.next()){
					 t = new User();
					t.setId(set.getInt("id"));
					t.setName(set.getString("name"));
					
				}
				return t;
			}}, u.getId(),u.getPassword());
		return user;
	}
}
