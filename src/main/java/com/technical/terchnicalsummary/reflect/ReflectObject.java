package com.technical.terchnicalsummary.reflect;
/*
 * @ClassName ReflectObject
 * @Description 反射
 * @Author shuai_yu
 * @Date 2021/8/25 9:57
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.technical.terchnicalsummary.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectObject {
    public static Object copy(Object object) throws Exception{
        //获得对象的类型
        Class classType=object.getClass();
        System.out.println("Class:"+classType.getName());
        //通过默认构造方法创建一个新的对象
        Object objectCopy=classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
        //获得对象的所有属性
        Field fields[]=classType.getDeclaredFields();
        for(int i=0; i<fields.length;i++){
            Field field=fields[i];
            String fieldName=field.getName();
            String firstLetter=fieldName.substring(0,1).toUpperCase();
            //获得和属性对应的getXXX()方法的名字
            String getMethodName="get"+firstLetter+fieldName.substring(1);
            //获得和属性对应的setXXX()方法的名字
            String setMethodName="set"+firstLetter+fieldName.substring(1);
            //获得和属性对应的getXXX()方法
            Method getMethod=classType.getMethod(getMethodName,new Class[]{});
            //获得和属性对应的setXXX()方法
            Method setMethod=classType.getMethod(setMethodName,new Class[]{field.getType()});
            //调用原对象的getXXX()方法
            Object value=getMethod.invoke(object,new Object[]{});
            System.out.println(fieldName+":"+value);
            //调用拷贝对象的setXXX()方法
            //反射私有的东西的时候，如果要进行修改：setAccessible(true);
            setMethod.setAccessible(true);
            setMethod.invoke(objectCopy,new Object[]{value});
        }
        return objectCopy;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("于帅");
        try {
            System.out.println(JSON.toJSONString(copy(user), SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
