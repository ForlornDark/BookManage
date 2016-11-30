package com.book.manage.test;

import java.util.Properties;
import java.util.Random;
import org.junit.Test;
import com.book.manage.utils.MailSenderInfo;
import com.book.manage.utils.SimpleMailSender;

public class MailTest {
	@Test
	public void send(){
		Random r = new Random();
		int t = r.nextInt(8999)+1000;
		System.out.println(t);
		MailSenderInfo mailInfo = new MailSenderInfo();   
	     mailInfo.setToAddress("1226007593@qq.com");   ///对方的邮箱
	     mailInfo.setSubject("欢迎注册图书管理系统读者");   
	     mailInfo.setContent("本次注册验证码是:"+t);
	     //这个类主要来发送邮件  
	     SimpleMailSender sms = new SimpleMailSender();  
	     if(sms.sendTextMail(mailInfo)){    //发送文体格式   
	    	 System.out.println("发送成功！");
	     }
	  //   sms.sendHtmlMail(mailInfo);//发送html格式
	}
}
