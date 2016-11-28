package com.book.manage.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.book.manage.bean.Reader;
import com.book.manage.dao.ReaderDao;
import com.book.manage.utils.DBHelper;
import com.book.manage.utils.DateUtil;
import com.book.manage.utils.SaveFile;
import com.book.manage.utils.ServerConst;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class AddReader extends ActionSupport{
	//生日，年
	private int year;
	//生日，月
	private int month;
	//生日，天
	private int day;
	//读者缓存图片封装类
	private File photo;
	//图片名
	private String photoFileName;
	//封装的读者信息
	private Reader reader;
	//图片类型
	private String photoContentType;
	//图片验证码
	private int checkcode;
	//提示处理结果
	private String state;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4631218184303741386L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int code = (int) ActionContext.getContext().getSession().get(reader.getMail());
		ActionContext.getContext().getSession().remove(reader.getMail());
		if(code!=checkcode){
			state="验证码输入不正确，注册失败";
			return SUCCESS;
		}
		reader.setBorn(DateUtil.parse(year+"-"+month+"-"+day));
		ReaderDao dao= new ReaderDao();
		dao.addReader(reader);
		reader.setReaderId(dao.queryID(reader));
		if(photo!=null){
			if(photoFileName.endsWith(".png"))
			photoFileName = reader.getReaderId()+".png";
		else if(photoFileName.endsWith(".gif"))
			photoFileName = reader.getReaderId()+".gif";
		else if(photoFileName.endsWith(".jpg")||photoFileName.endsWith(".jpeg"))
			photoFileName = reader.getReaderId()+".jpg";
			reader.setPhoto(SaveFile.save(photo, photoFileName));
			dao.updatePhoto(reader);
			reader.setPhoto(ServerConst.URL+reader.getPhoto());
		}
		return super.execute();
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public int getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(int checkcode) {
		this.checkcode = checkcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
