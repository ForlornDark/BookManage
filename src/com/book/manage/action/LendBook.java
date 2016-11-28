package com.book.manage.action;

import java.util.Map;

import com.book.manage.bean.Lend;
import com.book.manage.dao.LendDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LendBook extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ΩË‘ƒ–≈œ¢
	private Lend lend;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		LendDao dao = new LendDao();
		Map<String,Object> map = dao.lendBookForResult(lend);
		ActionContext.getContext().put("map", map);
		return super.execute();
	}
	public Lend getLend() {
		return lend;
	}

	public void setLend(Lend lend) {
		this.lend = lend;
	}
	
}
