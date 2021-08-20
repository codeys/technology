package com.technical.terchnicalsummary.utils;

import org.springframework.context.ApplicationContext;

/**
 * @ClassName SpringUtil
 * @Date 2021/3/10 13:55
 * @Created by 王新
 */
public class SpringUtils {

     private static ApplicationContext applicationContext;

     public static void setApplicationContext(ApplicationContext applicationContext){
         if (SpringUtils.applicationContext == null){
             SpringUtils.applicationContext = applicationContext;
         }
     }

     public  static Object getBean(Class c){
       return   applicationContext.getBean(c);
     }

    // 通过name获取 Bean.
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
}
