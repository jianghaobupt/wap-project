package com.tyyd.extension;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class TxtHandle {
	
	public static String readData(String sourceFile, int lineNumber)  throws IOException {  
		FileReader in = new FileReader(sourceFile);  
		LineNumberReader reader = new LineNumberReader(in);  
		String row = null;  
		String myStrs = null;
		
		if (lineNumber < 0 || lineNumber > getTotalLines(sourceFile)) {  
			System.out.println("不在文件的行数范围(1至总行数)之内。");  
			System.exit(0);  
			}  
		int lines = 0;
		row = reader.readLine();
		while (null != row) {
			if(0 == (lines - lineNumber)) { 
				myStrs = row;
				} 
			lines ++;
			row = reader.readLine();
			}  
		reader.close();  
		in.close(); 
		return myStrs;
	}
	
	// 文件内容的总行数。  
    public static int getTotalLines(String file) throws IOException {  
    	FileReader in = new FileReader(file);  
        LineNumberReader reader = new LineNumberReader(in);  
        String s = reader.readLine();  
        int lines = 0;  
        while (s != null) {  
        	lines++;  
        	s = reader.readLine();  
//        	if(lines>=2){  
//        		if(s!=null){  
//        			System.out.println(s+"$");  
//        			} 
//        		} 
        	}  
        reader.close();  
        in.close();  
        return lines;  
        } 

}