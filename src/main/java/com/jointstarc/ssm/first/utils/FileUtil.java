package com.jointstarc.ssm.first.utils;

import java.io.*;

public class FileUtil {

	BufferedReader bufferedReader;// 读数据流
	BufferedWriter bufferedWriter;// 写数据流
	InputStreamReader streamReader; // 字节流
	
	public static void writeFile(String folder, String fileName,
			String fileContent) {

		try {
			// 需要写入的文件夹路径不存在则自动创建
			File writeFolderPath = new File(folder);
			if (!writeFolderPath.exists()) {
				writeFolderPath.mkdirs();
			}
			// 需要写入的文件
			File file = new File(fileName);
			// 如果文件不存在，则新建一个
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			OutputStreamWriter write = new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8");
			BufferedWriter writer = new BufferedWriter(write);
			// PrintWriter writer = new PrintWriter(new BufferedWriter(new
			// FileWriter(filePathAndName)));
			// PrintWriter writer = new PrintWriter(new
			// FileWriter(filePathAndName));
			writer.write(fileContent);
			writer.close();
			System.out.println("文件写入成功！");
		} catch (Exception e) {
			System.out.println("写文件内容操作出错");
			e.printStackTrace();
		}
	}
	
	/** 
	  * 读取文件内容 
	  * 
	  * @param filePathAndName 
	  *            String 如 c:\\1.txt 绝对路径 
	  * @return boolean 
	  */ 
	public static String readFile(String filePathAndName) { 
	  String fileContent = ""; 
	  try {  
	   File f = new File(filePathAndName); 
	   if(f.isFile()&&f.exists()){ 
	    InputStreamReader read = new InputStreamReader(new FileInputStream(f),"UTF-8"); 
	    BufferedReader reader=new BufferedReader(read); 
	    String line; 
	    while ((line = reader.readLine()) != null) { 
	     fileContent += line; 
	    }   
	    read.close(); 
	   } 
	  } catch (Exception e) { 
	   System.out.println("读取文件内容操作出错"); 
	   e.printStackTrace(); 
	  } 
	  return fileContent; 
	} 
	

}
