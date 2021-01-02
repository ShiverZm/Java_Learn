package com.company.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * 1、获取Class对象的三种方式
 * 1.1 Object ——> getClass();
 * 1.2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 1.3 通过Class类的静态方法：forName（String  className）(常用)
 */
public class Reflection {

    static Reflection reflection = new Reflection();

    public Reflection(){
        System.out.println("ABC");
    }

    public Reflection(int a){
        System.out.println("a");
    }

    public  void ReflectionMethod(){

    }

    public void LoadClass(String className){
        try {
            Class<?> cls = Class.forName(className); // 直接使用字符串描述要使用的类, 无需 import
            Object object = cls.newInstance();  // 实例化对象 :等价　new java.util.Date()
            System.out.println(cls.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //任何的实例化对象可以通过 Object 类中的 getClass() 方法取得 Class 类对象
    public  static void GetClassName(){
        System.out.println("=========ClassName========");
        Class<?> cls = reflection.getClass();
        System.out.println(cls.getName());
    }

    public static void GetClassConstruct(){
        try {
            System.out.println("=========Construct========");
            Class<?> cls = reflection.getClass();
            for (Constructor<?> construct : cls.getDeclaredConstructors()) {
                System.out.println(construct.getName());
                Class<?> clasz[] = construct.getParameterTypes();

                for (Class<?> clas:clasz
                     ) {
                    System.out.println(clas.getName());
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void GetClassMethod(){
        System.out.println("=========Methods========");
        Class<?> cls = reflection.getClass();
        for (Method method:cls.getMethods()) {
            System.out.println(method.getName());
        }
    }

    public static void GetClassMemeber(){
        System.out.println("=========Memebers========");
        Class<?> cls = reflection.getClass();
        for (Field memeber:cls.getDeclaredFields()) {
            System.out.println(memeber.getName());
        }
    }


    public static void GetInstanceA(){
        try {
            System.out.println("=========GetInstanceA========");
            Class<?> cls = reflection.getClass();
            cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void GetInstanceB(){
        try {
            System.out.println("=========GetInstanceB========");
            Class<?> cls = reflection.getClass();
            cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void GetInstanceC(){
        try {
            System.out.println("=========GetInstanceB========");
            Class<?> cls = reflection.getClass();
            cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void PublicMethodTest(){
        System.out.println("===========================================");
        System.out.println("PublicMethodTest invoked");
        System.out.println("===========================================");
    }

    private void PrivateMethodTest(){
        System.out.println("===========================================");
        System.out.println("PrivateMethodTest invoked");
        System.out.println("===========================================");
    }

    public static void InvokePublicMethod(String methodName){
        try {
            System.out.println("=============InvokePublicMethod==============");

            Method[] ms = reflection.getClass().getDeclaredMethods();//当前类的方法，包括私有
            //ms=obj.getClass().getMethods();//子类 父类的所有公共方法
            for (Method m : ms) {
                if (m.getName().equals(methodName)) {
                    m.invoke(reflection, null);//调用无参方法
                }

            }
//            Method methods = reflection.getClass().getMethod(methodName, null);//根据方法名和参数直接调用方法，方法无参传null
//            methods.invoke(reflection, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void InvokePrivateMethod(String methodName){
        try {
            System.out.println("=============InvokePrivateMethod==============");

            Method[] ms = reflection.getClass().getDeclaredMethods();//当前类的方法，包括私有
            //ms=obj.getClass().getMethods();//子类 父类的所有公共方法
            for (Method m : ms) {
                if (m.getName().equals(methodName)) {
                    m.setAccessible(true);
                    m.invoke(reflection, null);//调用无参方法
                }

            }
//            Method methods = reflection.getClass().getMethod(methodName, null);//根据方法名和参数直接调用方法，方法无参传null
//            methods.invoke(reflection, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
