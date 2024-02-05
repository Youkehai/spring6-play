package com.hs.ykh.bean;

import com.hs.ykh.annotation.Autowired;
import com.hs.ykh.annotation.Bean;
import com.hs.ykh.dao.DaoTest;
import com.hs.ykh.service.ServiceTest;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过注解加载bean
 */
public class AnnotationApplicationContext implements ApplicationContext {

    //bean工厂集合
    private Map<Class, Object> beanFactory = new HashMap<>();

    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    /**
     * 传递包路径，指明扫描包的路径地址
     *
     * @param basePackage 扫描包路径
     */
    public AnnotationApplicationContext(String basePackage) {
        //通过包名查找文件夹中的文件
        //1.将包名转换为文件目录格式
        String packageUrl = basePackage.replaceAll("\\.", "\\\\");
        //2.拿到文件的绝对路径
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packageUrl);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
                //获取包名前面的路径
                rootPath = filePath.substring(0, filePath.length() - packageUrl.length());
                //扫描包
                loadBean(new File(filePath));
            }
        } catch (IOException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        loadDi();
    }

    /**
     * 注入beanFactory class对象的所有属性
     */
    private void loadDi() {
        //1.遍历 beanFactory 拿到所有 class 对象
        for (Map.Entry<Class, Object> classObjectEntry : beanFactory.entrySet()) {
            Class clazz = classObjectEntry.getValue().getClass();
            //获取所有属性
            Field[] declaredFields = clazz.getDeclaredFields();
            //遍历属性，判断所有属性是否有 autoWired的注解
            for (Field declaredField : declaredFields) {
                if (declaredField.getAnnotation(Autowired.class) != null) {
                    declaredField.setAccessible(true);
                    //设置 clazz 的属性
                    try {
                        declaredField.set(classObjectEntry.getValue(), beanFactory.get(declaredField.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    /**
     * 扫描包，并生成类的实例化
     *
     * @param file
     */
    private void loadBean(File file) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1.判断是否为文件夹
        if (file.isDirectory()) {
            //1.1 是文件夹拿到文件夹的所有内容
            File[] childrenFiles = file.listFiles();
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            for (File childrenFile : childrenFiles) {
                if (childrenFile.isDirectory()) {
                    //是文件夹，继续递归
                    loadBean(childrenFile);
                } else {
                    //得到文件的 包路径+类名称的部分，例如:com.hs.ykh.Main
                    String absolutePath = childrenFile.getAbsolutePath().substring(rootPath.length() - 1);
                    //判断是否为.class文件
                    if (!absolutePath.endsWith(".class")) {
                        continue;
                    }
                    //将 斜杠转换为点,并去掉.class后缀
                    String replaceAll = absolutePath.replaceAll("\\\\", ".");
                    //6的来源 .class 长度为6
                    absolutePath = replaceAll.substring(0, replaceAll.length() - 6);
                    //获取 class 对象
                    Class<?> myClass = Class.forName(absolutePath);
                    //判断是否为接口
                    if (myClass.isInterface()) {
                        continue;
                    }
                    //不是接口，判断该class是否有@bean注解
                    Bean annotation = myClass.getAnnotation(Bean.class);
                    if (annotation == null) {
                        continue;
                    }
                    //包含bean注解，对对象进行实例化
                    Object newInstance = myClass.getConstructor().newInstance();
                    //实例化完成，放入beanFactory中
                    //如果该类实现了接口，则用接口作为key
                    if (myClass.getInterfaces().length > 0) {
                        for (Class<?> anInterface : myClass.getInterfaces()) {
                            beanFactory.put(anInterface, newInstance);
                        }
                    } else {
                        //没有实现接口，则直接放入
                        beanFactory.put(myClass, newInstance);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ApplicationContext annotationApplicationContext = new AnnotationApplicationContext("com.hs.ykh");
        ServiceTest bean = (ServiceTest) annotationApplicationContext.getBean(ServiceTest.class);
        System.out.println(bean);
        bean.test();
    }
}
