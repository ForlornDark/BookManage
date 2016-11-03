package com.book.manage.action.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.book.manage.bean.Lend;
import com.book.manage.dao.LendDao;
import com.book.manage.utils.QueryRunner;

public class LendTest {
public void testLendDao(){
	try {
		List<Lend> list = new LendDao().queryById(1000000);
		for(Lend l :list){
			System.out.println(l.getISBN());
			System.out.println(l.getNum());
			System.out.println(l.getTime());
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void testDate(){
	SimpleDateFormat m = new SimpleDateFormat("yyyy-MM-dd");
	System.out.println(m.format(new Date()));
}
@Test
public void testUpdate(){
	QueryRunner runner = new QueryRunner();
	String sql="update book set snum = ? where isbn = ?";
	try {
		runner.update(sql, 20,"978-7-121-13072-4");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Íê±Ï");
}
}
