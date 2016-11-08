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
		String path = DBHelper.relPath + DBHelper.logicPath;
		StringBuilder builder2 =  new StringBuilder(DBHelper.logicPath);
		try {
			File f = new File(path);
				if (!f.exists())
					f.mkdirs();
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

	public static void deleteFile(String relaPath){
		if(relaPath!=null&&(!relaPath.isEmpty())){
			String path =DBHelper.relPath+relaPath;
			System.out.println(path);
			File file = new File(path);
			if(file.exists())
			file.delete();
		}
	}
}
