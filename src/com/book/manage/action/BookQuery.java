package com.book.manage.action;

import java.util.List;

import com.book.manage.bean.Book;
import com.book.manage.dao.BookDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class BookQuery extends ActionSupport{
	private List<Book> list;
	private static final long serialVersionUID = 1L;
	private String param =null;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new BookDao().queryByNaAu(param);
		return super.execute();
	}
	
	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
}
