package com.hs.ykh;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //获取class对象的方式
        Class<TestReflect> class1 = TestReflect.class;
        Class<? extends TestReflect> class2 = new TestReflect().getClass();
        Class<?> class3 = Class.forName("com.hs.ykh.TestReflect");
        Object o = class3.newInstance();
        System.out.println(class3.getPackageName());
        //获取类的所有构造方法 getDeclaredConstructors 会获取private的方法
        Constructor<?>[] constructors = class3.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("构造方法名称："+constructors[i]+"参数个数:"+constructors[i].getParameterCount());
        }
        //获取类的属性
        //获取public属性
        Field[] fields = class3.getFields();
        //获取所有属性，包含private和public,protected属性
        Field[] declaredFields = class3.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {

        }
        //获取类的方法和调用方法
        //获取所有方法
        Method[] methods = class3.getMethods();
        //获取所有方法，包含private和public,protected的方法
        Method[] declaredMethods = class3.getDeclaredMethods();
        //调用private方法需要设置 setAccessible 和 DeclaredMethod
        Method privateMethod = class3.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(o);
    }
}