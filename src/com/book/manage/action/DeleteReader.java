package com.book.manage.action;

import com.book.manage.dao.ReaderDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class DeleteReader extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3168288896120281354L;
	//删除结果信息
	private String state;
	//读者ID
	private int readerId;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(readerId);
		ReaderDao dao =new ReaderDao();
		state =  dao.deleteByID(readerId);
		return super.execute();
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
}
