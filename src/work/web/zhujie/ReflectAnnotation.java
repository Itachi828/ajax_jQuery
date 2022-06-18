package work.web.zhujie;

import jakarta.servlet.annotation.WebServlet;

import java.lang.annotation.Annotation;

/**
 * @Author: Itachi
 * @Date: 2022/5/26 12:42
 * @Version: jdk1.8
 */
public class ReflectAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取类对象
        Class<?> welcomeClass = Class.forName("work.web.zhujie.WelcomeServlet");
        // 判断是否有注解
        if(welcomeClass.isAnnotationPresent(WebServlet.class)){
            // 获取注解对象
            WebServlet welcomeClassAnnotation = welcomeClass.getAnnotation(WebServlet.class);
            String[] values = welcomeClassAnnotation.value();
            for(String value:values){
                System.out.println(value);
            }
        }
    }
}
