package com.book.manage.action;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author lfm
 *
 */
public class LogoutAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession().invalidate();
		return super.execute();
	}
	
}
