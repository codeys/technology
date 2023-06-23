##1.Mybatis
1.1 mybatis拦截器
1.2 pageHelper
##2.Druid数据源、监控
##3.切面、环绕通知
3.1 自定义注解
##4.多数据库支持
##5.Redis
5.1 支持多连接
##6.线程池
##7.反射机制
###什么是反射
  反射就是把Java类中的各个成分映射成一个个的Java对象。即在运行状态中，对于任意一个类，都能够知道这个类的所以属性和方法；
  对于任意一个对象，都能调用它的任意一个方法和属性。这种动态获取信息及动态调用对象方法的功能叫Java的反射机制。
###反射机制的功能
Java反射机制主要提供了以下功能：

在运行时判断任意一个对象所属的类。
在运行时构造任意一个类的对象。
在运行时判断任意一个类所具有的成员变量和方法。
在运行时调用任意一个对象的方法。
生成动态代理。
###实现反射机制的类
Java中主要由以下的类来实现Java反射机制（这些类都位于java.lang.reflect包中）：
Class类：代表一个类。 Field类：代表类的成员变量（成员变量也称为类的属性）。
Method类：代表类的方法。
Constructor类：代表类的构造方法。
Array类：提供了动态创建数组，以及访问数组的元素的静态方法。
###Class类是Reflection API中的核心类
getName()：获得类的完整名字。 getFields()：获得类的public类型的属性。
getDeclaredFields()：获得类的所有属性。
getMethods()：获得类的public类型的方法。
getDeclaredMethods()：获得类的所有方法。
getMethod(String name, Class[] parameterTypes)：获得类的特定方法，name参数指定方法的名字，parameterTypes参数指定方法的参数类型。
getConstrutors()：获得类的public类型的构造方法。
getConstrutor(Class[] parameterTypes)：获得类的特定构造方法，parameterTypes参数指定构造方法的参数类型。
newInstance()：通过类的不带参数的构造方法创建这个类的一个对象。

###Spring security
https://www.cnblogs.com/lzghyh/p/14744040.html#_label2_2
###过滤器、拦截器、监听器
###redis分布式锁
####2种方式 redis.setnx,redisson