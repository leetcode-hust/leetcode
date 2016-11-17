package utils;

import java.io.*;
import java.util.*;

/**
 * function：提供一些静态方法，像简单字符串一样读写文件
 * @author LL
 */
public class IOUtil extends ArrayList<String> {
	/**
	 * function：缓冲输入文件，返回文件内容的字符串形式
	 * @param fileName
	 * @return 返回文件内容的字符串形式
	 */
	public static String readByBufferedReader(String fileName) {
		StringBuilder sb = new StringBuilder();
	    try {
	    	//获取的绝对路径（磁盘名开始）
	    	BufferedReader inReader= new BufferedReader(new FileReader( new File(fileName).getAbsoluteFile()));
	    	try {
		        String s;
		        while((s = inReader.readLine()) != null) {
		        	sb.append(s+"\n");
		        }
	    	} finally {
                inReader.close();
	    	}
	    } catch(IOException e) {
	    	throw new RuntimeException(e);
	    }
	    return sb.toString();
	}
	
	
    /**
     * function:往文件里面写入一个字符串
     * @param fileName
     * @param text
     */
	public static void write(String fileName, String text) {
	    try {
	        PrintWriter out = new PrintWriter( new File(fileName).getAbsoluteFile());
		    try {
		    	out.print(text);
		    } finally {
		        out.close();
		    }
	    } catch(IOException e) {
	    	throw new RuntimeException(e);
	    }
	}
	
	/**
	 * function：构造器：
	 * 读一个文件返回字符串，并以一个正则表达式分离，然后保存在一个ArrayList中
	 */
	public IOUtil(String fileName, String splitter) {
	    super( Arrays.asList( readByBufferedReader(fileName).split(splitter) ) );
	    if(get(0).equals(""))
		    remove(0);
	}
	/**
	 * function：构造器
	 * 默认以换行符为正则
	 * @param fileName
	 */
	public IOUtil(String fileName) {
		this(fileName, "\n");
	}
	
	
	public void write(String fileName) {
	    try {
	    	PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
	    	try {
		        for(String item : this)
		        	out.println(item);
		    } finally {
		    	out.close();
		    }
	    } catch(IOException e) {
	    	throw new RuntimeException(e);
	    }
	}

}






