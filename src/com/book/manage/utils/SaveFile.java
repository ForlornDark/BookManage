package com.book.manage.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.struts2.ServletActionContext;

public class SaveFile {
	public static String save(File file,String feature){
		String path = "";
		StringBuilder builder2 =  new StringBuilder("/upload");
		try {
			URL url = ServletActionContext.getServletContext().getResource("WEB-INF/upload");
			File f = null;
			if (url == null) {
				path = ServletActionContext.getServletContext().getResource("WEB-INF").getPath() + "upload";
				f = new File(path);
				if (!f.exists())
					f.mkdirs();
			} else
				path = url.getPath();
			StringBuilder builder = new StringBuilder(path);
			int i = 0;
			for (i = 0; feature.charAt(i) != '.'; i++) {
				if(feature.charAt(i) == '-')
					continue;
				builder2.append('/');
				builder2.append(feature.charAt(i));
				builder.append('/');
				builder.append(feature.charAt(i));
				f = new File(builder.toString());
				if(feature.charAt(i+1) != '.')
				if(!f.exists())
					f.mkdirs();
			}
			builder.append(feature.substring(i));
			builder2.append(feature.substring(i));
			path = builder.toString();
			f = new File(path);
			if(!f.exists())
				f.createNewFile();
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(f);
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = fis.read(b)) > 0)
				fos.write(b, 0, len);
			
			fis.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path);
		System.out.println(file.getAbsolutePath());
		return builder2.toString();
	}
	public String getPath(String feature){
		return feature;
	}
}
