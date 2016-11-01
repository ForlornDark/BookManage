package com.book.manage.action;

import com.book.manage.bean.User;
import com.book.manage.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class LoginAction extends ActionSupport {

	private User user;
	private String msg;
	/**
	 * 处理登录与注册管理员
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		User u = dao.queryUser(user);
		if( u == null){
			setMsg("账户或密码错误");
			return "error";
		}
		return "success";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
