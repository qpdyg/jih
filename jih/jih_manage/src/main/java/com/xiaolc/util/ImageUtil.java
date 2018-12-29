package com.xiaolc.util;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

public class ImageUtil {
	
	//图片到byte数组  传来的是文件的绝对路径
	  public static byte[] image2byteByPath(String path){
	    byte[] data = null;
	    FileImageInputStream input = null;
	    try {
	      input = new FileImageInputStream(new File(path));
	      ByteArrayOutputStream output = new ByteArrayOutputStream();
	      byte[] buf = new byte[1024];
	      int numBytesRead = 0;
	      while ((numBytesRead = input.read(buf)) != -1) {
	      output.write(buf, 0, numBytesRead);
	      }
	      data = output.toByteArray();
	      output.close();
	      input.close();
	    }
	    catch (FileNotFoundException ex1) {
	      ex1.printStackTrace();
	    }
	    catch (IOException ex1) {
	      ex1.printStackTrace();
	    }
	    return data;
	  }	
	  
	  //图片到byte数组,传来的是一个文件
	  public static byte[] image2byteByFile(File file){
		    byte[] data = null;
		    FileImageInputStream input = null;
		    try {
		      input = new FileImageInputStream(file);
		      ByteArrayOutputStream output = new ByteArrayOutputStream();
		      byte[] buf = new byte[1024];
		      int numBytesRead = 0;
		      while ((numBytesRead = input.read(buf)) != -1) {
		      output.write(buf, 0, numBytesRead);
		      }
		      data = output.toByteArray();
		      output.close();
		      input.close();
		    }
		    catch (FileNotFoundException ex1) {
		      ex1.printStackTrace();
		    }
		    catch (IOException ex1) {
		      ex1.printStackTrace();
		    }
		    return data;
		  }	
	  
	  
	  
	  
	  //byte数组到图片
	  public static void byte2image(byte[] data,String path){
	    if(data.length<3||path.equals("")) return;
	    try{
	    FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
	    imageOutput.write(data, 0, data.length);
	    imageOutput.close();
	    System.out.println("Make Picture success,Please find image in " + path);
	    } catch(Exception ex) {
	      System.out.println("Exception: " + ex);
	      ex.printStackTrace();
	    }
	  }
	  
	  
	  
	  /****
	   * 复制图片
	   * @param src
	   * @param target
	   */
	  public static void copyFile(String src, String target)
	     {     
	         File srcFile = new File(src);
	            File targetFile = new File(target);
	            try {    
	                InputStream in = new FileInputStream(srcFile);
	                OutputStream out = new FileOutputStream(targetFile);
	                byte[] bytes = new byte[1024];    
	                int len = -1;    
	                while((len=in.read(bytes))!=-1)  
	                {    
	                    out.write(bytes, 0, len);    
	                }    
	                in.close();    
	                out.close();    
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();    
	            } catch (IOException e) {
	                e.printStackTrace();    
	            }    
	            System.out.println("文件复制成功");


	     } 
	  
    
	  
	  public static void main(String[] args) {
	
		  byte[] image2byte = ImageUtil.image2byteByPath("C:\\Users\\12966\\Desktop\\1.jpg");
		  
		  
		  for (int i = 0; i < image2byte.length; i++) {
			System.out.print(image2byte[i]);
			
		}
		  
		  System.out.println();
		  
		  
		  ImageUtil.byte2image(image2byte, "C:\\Users\\12966\\Desktop\\testImage\\hah.png");
		  
		  System.out.println("拿出图片");
		  
	}
	  
	  
	  
	  
	  

}
