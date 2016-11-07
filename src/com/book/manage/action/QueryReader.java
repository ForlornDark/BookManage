package com.book.manage.action;

import com.book.manage.utils.DBHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class QueryReader extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6085602299054684400L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext.getContext().put("photo", DBHelper.URL+"/upload/1/0/0/0/0/6.jpg");
		return super.execute();
	}
}
