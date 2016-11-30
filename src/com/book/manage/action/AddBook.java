package com.book.manage.action;
import java.io.File;
import com.book.manage.bean.Book;
import com.book.manage.dao.BookDao;
import com.book.manage.utils.DBHelper;
import com.book.manage.utils.SaveFile;
import com.book.manage.utils.ServerConst;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lfm
 *
 */
public class AddBook extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3564363930759618822L;
	//图书信息
	private Book book;
	//图书缓冲封面，图片
	private File photo;
	//图书图片名
	private String photoFileName;
	//图书图片类型
	private String photoContentType;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		book.setSnum(book.getCnum());
		if(photo!=null){
			if(photoFileName.endsWith(".png"))
			photoFileName = book.getISBN()+".png";
		else if(photoFileName.endsWith(".gif"))
			photoFileName = book.getISBN()+".gif";
		else if(photoFileName.endsWith(".jpg")||photoFileName.endsWith(".jpeg"))
			photoFileName = book.getISBN()+".jpg";
			book.setPath(SaveFile.save(photo,photoFileName));
		}
		System.out.println(book.getPath());
		BookDao dao= new BookDao();
		dao.addBook(book);
		System.out.println(book.getISBN());
		if(book.getPath()!=null&&(!book.getPath().isEmpty()))
		book.setPath(ServerConst.URL+book.getPath());
		return super.execute();
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
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
	
}
