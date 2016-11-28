package com.book.manage.action;

 import java.util.Map;

import com.book.manage.bean.Lend;
import com.book.manage.dao.LendDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class BackBook extends ActionSupport {
	//ΩË‘ƒ–≈œ¢
	private Lend lend;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5045185100766952167L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		LendDao dao = new LendDao();
		Map<String,Object> map = dao.backBook(lend);
		ActionContext.getContext().put("map",map);
		return super.execute();
	}
	public Lend getLend() {
		return lend;
	}
	public void setLend(Lend lend) {
		this.lend = lend;
	}
	
}
