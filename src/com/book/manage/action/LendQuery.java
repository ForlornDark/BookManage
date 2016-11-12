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
	private int id;
	private String state;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new LendDao().queryById(id);
		if(list.size()==0)
			state="Ã»ÓÐ¼ÇÂ¼";
		return super.execute();
	}
	public List<Lend> getList() {
		return list;
	}
	public void setList(List<Lend> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
