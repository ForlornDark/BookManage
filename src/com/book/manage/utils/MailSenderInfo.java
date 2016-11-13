package com.book.manage.utils;
import java.util.Properties;
public class MailSenderInfo {
    // 邮件接收者的地址   
    private String toAddress;   
    // 登陆邮件发送服务器的用户名和密码   
    private String subject;   
    // 邮件的文本内容   
    private String content;   
    // 邮件附件的文件名   
    private String[] attachFileNames;     
    /**  
      * 获得邮件会话属性  
      */   
    public Properties getProperties(){
    	 Properties p = new Properties();   
    	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    	p.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    	p.setProperty("mail.smtp.socketFactory.fallback", "false");
    	p.setProperty("mail.smtp.socketFactory.port", ServerConst.mailPort); 
    	p.put("mail.smtp.host", ServerConst.mailHost);   
    	p.put("mail.smtp.port", ServerConst.mailPort);   
    	p.put("mail.smtp.auth",  "true" );
    	p.setProperty("mail.debug", ServerConst.mailDebug);
      return p;   
    }   
    public String[] getAttachFileNames() {   
      return attachFileNames;   
    }  
    public void setAttachFileNames(String[] fileNames) {   
      this.attachFileNames = fileNames;   
    }  
    public String getToAddress() {   
      return toAddress;   
    }   
    public void setToAddress(String toAddress) {   
      this.toAddress = toAddress;   
    }   
    public String getSubject() {   
      return subject;   
    }  
    public void setSubject(String subject) {   
      this.subject = subject;   
    }  
    public String getContent() {   
      return content;   
    }  
    public void setContent(String textContent) {   
      this.content = textContent;   
    }   

}