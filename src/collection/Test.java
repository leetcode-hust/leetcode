package collection;

/**
 * Created by Administrator on 2016/10/29.
 */
public class Test {

    @org.junit.Test
    public void main(){

        String str1 = "11111";
        String str2 = "11111";

        if(str1==str2){
            System.out.println(str1.hashCode());
        }

        str2="22222";
        System.out.println(str1.equals(str2));

    }
}
