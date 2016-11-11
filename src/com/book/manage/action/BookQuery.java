package com.book.manage.action;

import java.util.List;

import com.book.manage.bean.Book;
import com.book.manage.bean.Page;
import com.book.manage.dao.BookDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class BookQuery extends ActionSupport{
	private List<Book> list;
	private static final long serialVersionUID = 1L;
	private String param =null;
	private String state ;
	private Page<List<Book>> page;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		new BookDao().queryByPage(page);
		if(page.getResult()==null||page.getResult().size()==0)
			state="无搜索结果，请改变搜索关键词";
//		list = new BookDao().queryByNaAu(param);
//		if(list.size()==0)
//			state = "无搜索结果";
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public Page<List<Book>> getPage() {
		return page;
	}

	public void setPage(Page<List<Book>> page) {
		this.page = page;
	}
}
