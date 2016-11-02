package com.book.manage.action;

import java.util.List;

import com.book.manage.bean.Lend;
import com.book.manage.dao.LendDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class LendQuery extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3252649536972207290L;

	private List<Lend> list;
	private String id;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int i = Integer.parseInt(id);
		list = new LendDao().queryById(i);
		return super.execute();
	}
	public List<Lend> getList() {
		return list;
	}
	public void setList(List<Lend> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
