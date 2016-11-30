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
	//查询结果
	private List<Lend> list;
	//借阅ID
	private int id;
	//查询结果状态。
	private String state;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = new LendDao().queryById(id);
		if(list.size()==0)
			state="没有记录";
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
