package test;

import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by louyuting on 17/1/15.
 * 反射机制的测试代码
 */
class Parent {
    private Integer pf1=1;
    protected Integer pf2=2;
    public Integer pf3=3;
    Integer pf4=4;
}

public class ReflectTest extends Parent implements Serializable{

    private String field1="field1";
    protected String field2="field2";
    public String field3="field3";
    String field4="field3";


    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        ReflectTest reflectTest = new ReflectTest();
        System.out.println(reflectTest.getClass().getName());
    }

    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("test.ReflectTest");
        System.out.println("类名称是:"+class1);
    }

    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> clazz = null;
        clazz = Class.forName("test.ReflectTest");

        //获取父类
        Class<?> parentClass = clazz.getSuperclass();
        System.out.println("clazz的父类为：" + parentClass.getName());

        // 获取所有的接口
        Class<?> intes[] = clazz.getInterfaces();
        System.out.println("clazz实现的接口有：");
        for (int i = 0; i < intes.length; i++) {
            System.out.println((i + 1) + "：" + intes[i].getName());
        }
    }

    /**
     * 获取某一个类中全部构造函数 以及 实例化一个类对象
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        Class<?> class1 = null;
        class1 = Class.forName("test.User");
        // 第一种方法，实例化默认构造方法，调用set赋值
        User user = (User) class1.newInstance();
        user.setAge(23);
        user.setName("LouLou");
        System.out.println(user);
        // 结果 User [age=20, name=Rollen]
        // 第二种方法 取得全部的构造函数 使用构造函数赋值
        Constructor<?> cons[] = class1.getConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ", ");
            }
            System.out.println(")");
        }
        // 结果
        // cons[0] (int, java.lang.String)
        //cons[1] (java.lang.String)
        //cons[2] ()
        user = (User) cons[0].newInstance(23, "LouLou");
        System.out.println(user);
        // 结果 User [age=23, name=LouLou]
        user = (User) cons[1].newInstance("LouLou");
        System.out.println(user);
        // 结果 User [age=0, name=LouLou]
    }

    @Test
    public void test5() throws Exception {
        Class<?> clazz = null;
        clazz = Class.forName("test.ReflectTest");

        System.out.println("===============本类属性===============");
        Field[] field = clazz.getDeclaredFields();//获取本类的全部属性(不包括父类或则实现的接口)
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }

        System.out.println("==========本类或则实现的接口或者父类的public的属性==========");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }
    }

    private void testtttt(){

    }
    /**
     * 获取某个类的全部方法
     * @throws Exception
     */
    @Test
    public void test6() throws Exception {
        Class<?> clazz = Class.forName("test.ReflectTest");
        //Method[] method = clazz.getMethods();//获取本类以及继承类\实现接口的所有public修饰的方法
        Method[] method = clazz.getDeclaredMethods();//只获取本类的所有方法
        for(int i=0; i<method.length; i++){
            int mod = method[i].getModifiers();
            String modifier = Modifier.toString(mod);//获取方法修饰符

            Class<?> returnType = method[i].getReturnType();//获取返回值类型
            Class<?> [] para = method[i].getParameterTypes();//获取参数类型
            System.out.print(modifier + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
    }


    public void reflect1() {
        System.out.println("Java 反射机制 - 调用某个类的方法1.");
    }
    public void reflect2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }
    /**
     * 通过反射机制调用某个类的方法
     */
    @Test
    public void test7() throws Exception{
        Class<?> clazz = Class.forName("test.ReflectTest");
        // 调用TestReflect类中的reflect1方法
        Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());
        //output: Java 反射机制 - 调用某个类的方法1.

        // 调用TestReflect的reflect2方法
        method = clazz.getMethod("reflect2", int.class, String.class);
        method.invoke(clazz.newInstance(), 20, "张三");
        // Java 反射机制 - 调用某个类的方法2.
        //output:  age -> 20. name -> 张三
    }


    private String proprety = null;
    /**
     * 通过反射机制操作某个类的属性
     */
    @Test
    public void test8() throws Exception{
        Class<?> clazz = Class.forName("test.ReflectTest");
        Object obj = clazz.newInstance();
        // 可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println("proprety="+field.get(obj));
    }

}


class User {
    private int age;
    private String name;
    public User() {
        super();
    }
    public User(String name) {
        super();
        this.name = name;
    }
    public User(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }

}









