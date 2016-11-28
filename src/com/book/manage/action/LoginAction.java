package com.book.manage.action;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.book.manage.bean.User;
import com.book.manage.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class LoginAction extends ActionSupport {
	//管理员封装对象
	private User user;
	//登陆结果信息
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
		Map<String, Object> map = ActionContext.getContext().getSession();
		Cookie c = new Cookie("user",String.valueOf(u.getId()));
		Cookie c2 = new Cookie("name",u.getName());
		ServletActionContext.getResponse().addCookie(c);
		ServletActionContext.getResponse().addCookie(c2);
		map.put(String.valueOf(u.getId()), u);
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
