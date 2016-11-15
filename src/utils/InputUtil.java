package utils;

import java.util.Scanner;

/**
 * Created by louyuting on 16/11/15.
 */
public class InputUtil {

    public static int inputInt(String note){
        if(note==null){
            System.out.println("请输入num:");
        }else{
            System.out.println(note);
        }
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int num = Integer.valueOf(input);
        return num;
    }


    public static String inputString(String note, String str){
        if(note==null){
            System.out.println("请输入字符串:");
        }else{
            System.out.println(note);
        }
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }


}
