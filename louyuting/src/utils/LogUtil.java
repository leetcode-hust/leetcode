package utils;

import java.util.*;


/**
 * function: 日志工具
 * @author LL
 * @since 2016-7-19
 */
public class LogUtil {
	public static final int ERROR = 0;
	public static final int WARN = 1;
	public static final int INFO = 2;
	public static final int DEBUG = 3;
	
	public static final int DEFAULT = DEBUG;//默认
	
	
	/**
	 * 输出日志到控制台
	 * @param outStr
	 */
	public static void log_debug2(String outStr){
		int level = DEBUG;
		if(level<= DEFAULT)
			System.out.println(DateUtil.fmtDateToMillisecond(new Date()) +"："+ outStr);
	}
	
	public static void log_error(String outStr){
		int level = ERROR;
		if(level<= DEFAULT)
			System.out.println(DateUtil.fmtDateToMillisecond(new Date()) +"："+ outStr);
	}
	public static void log_warn(String outStr){
		int level = WARN;
		if(level<= DEFAULT)
			System.out.println(DateUtil.fmtDateToMillisecond(new Date()) +"："+ outStr);
	}
	public static void log_info(String outStr){
		int level = INFO;
		if(level<= DEFAULT)
			System.out.println(DateUtil.fmtDateToMillisecond(new Date()) +"："+ outStr);
	}
	public static void log_debug(String outStr){
		int level = DEBUG;
		if(level<= DEFAULT)
			System.out.println(DateUtil.fmtDateToMillisecond(new Date()) +"："+ outStr);
	}
	
	/**
	 * 默认的println
	 * @param obj
	 */
	public static <T> void println(T obj){
		System.out.println(obj.toString());
	}
	
	/**
	 * function：一级输出集合： 输出集合中的每一项信息，该集合的类型是基础类型，如List<String>
	 * @param collection
	 */
	public static <E> void printList(Collection<E> collection) {
		
		System.out.println("该集合的大小为：" + collection.size());
		System.out.println("[");
		for (E e : collection) {
			System.out.println("    "+e+", ");
		}
		System.out.println("]");
	}

    public static void log_iterator(Iterator<String> iterator){
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
	
	
/**
 * =================================================================================================
 * 测试=============================================================================================
 * =================================================================================================
 */
	public void test_printList(){
		List<String> lists = new ArrayList<String>();
		lists.add("aaa");
		lists.add("bbb");
		lists.add("ccc");
		lists.add("ddd");
		lists.add("eee");
		lists.add("fff");
		
		printList(lists);
	}
	
}

