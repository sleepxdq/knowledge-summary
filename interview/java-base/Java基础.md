Java基础
---
## 介绍
面向对象语言，
易开发：安装简单，有很多类库可以使用
易学习：语言简单
易使用：支持对平台运行，基于JVM
易复用：类复用，方法复用
## 基本类型（8种）
|类型|字节(1byte=8位)|位数|最大值|最小值|默认值|包装类|
|---|---|---|---|---|---|---|
|short|2|2*8=16|-(2^16-1)| |0|Short|
|int|4|4*8=32| | |0|Integer|
|long|8|8*8=64| | |0L|Long|
|float|4|32| | |0.0f|Float|
|double|8|64| | |0.0d|Double|
|byte|1|8| | | |Byte|
|char|2|16|'\uffff'/65535|'\u0000'/0|'u0000'|Character| 
|boolean| |1| | |false|Boolean|
基本类型的拆箱和装箱
>装箱过程其实是XXX.valueOf(参数),Integer a = Integer.valueOf(1)
拆箱过程其实是xxxValue(),int b = a.intValue()
>
存储方式
>基本类型都是存储在栈内存中的局部变量表中
>
>包装类型比较特别,其中Short,Integer,Long,Byte,Character,Boolean使用长量池
>
>Short,Integer,Long,Byte默认创建了[-128,127]缓存的数据;
>Character默认创建了[0,127]的缓存数据;
>Boolean默认直接就是False和True.
>
>包装类型值的比较使用equals方法比较,防止引用导致值同,引用不同

## ==与equals()
==在基本类型中比较的是值，在引用类型中比较的也是值，但是这个值其实是对象的引用地址（对象在内存中的地址）
> 基本类型是否值一样，对象比较是否是同一个对象

equals()方法
Object类的equals()比较的对象是否是同一对象，和==作用一样

String的equals()比较的是对象地址或者值是否相同

## hashCode()与equals()
hashCode()是本地方法，也就是基于C实现的方法，简单可以理解就是对象内存地址的一个int值

**hash算法是什么样的机制**需要了解下

在比较对象是否相同是，先比较hash值时，hash值不同肯定就不是相同对象，不同时再比较对象的值，这样可以提供性能
一般在HashSet，HashMap等经常使用hash比较判断是否需要覆盖key对应的value
## 反射
serialVersionUID的作用：控制序列化和反序列化的版本是否一致，不一致会反序列化失败
### 基本知识
>什么是反射
>
程序在运行是去创建对象并获取对象的所有信息(构造器，属性，方法)
>有什么用
>
- 可以运用在框架中，方便对象的创建
- 注解
>基本原理

获取Class对象后，可以获取Class对应的示例对象

```java
    package com.xdq.base.reflection;
    
    /**
     * @author Seven.Xu
     * @version 2021/5/3
     **/
    public class Reflection {
    
        private static void createClassFromClassForName() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            Class<?> personClass = Class.forName("com.xdq.base.reflection.Person");
            Person person = (Person) personClass.newInstance();
            person.setName("xdq");
            person.printName();
        }
    
        private static void createClassFromObjectClass() throws IllegalAccessException, InstantiationException {
            Class<Person> personClass = Person.class;
            Person person = personClass.newInstance();
            person.setName("xdq");
            person.printName();
        }
    
        private static void createClassFromClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            Class<?> personClass = ClassLoader.getSystemClassLoader().loadClass("com.xdq.base.reflection.Person");
            Person person = (Person) personClass.newInstance();
            person.setName("xdq");
            person.printName();
        }
    
        public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    //        createClassFromClassForName();
    //        createClassFromObjectClass();
            createClassFromClassLoader();
        }
    }

```

>优缺点

### 静态代理
>什么是静态代理

首先代理是对一个接口/类做一次代理处理，也就是对原先公共的包装，然后可以扩展自己所要的功能，就像代理商一样，同样把东西卖给你但是这里面代理商可以转差价
>有什么用
>
对原有的功能做扩展开发
>基本原理
>
做一层包装
>有什么缺点
>
只能指定代理类
新的代理都需要创建代理类
### 动态代理
>什么是动态代理
不需要我们指定的创建代理类
>有什么用
动态的创建代理类
>基本原理
代理模式
>优缺点

>使用场景
>
首先我们一般需要对接口和对象做代理，所以现在有的动态代理工具有：JDK动态代理和CGLIB动态代理
#### JDK动态代理
>什么是JDK动态代理
>
JDK提供的动态代理方便工具
>基本原理
>
基于InvocationHandler接口和Proxy类
Invocation接口做代理中逻辑的处理
Proxy生成代理接口
> 使用场景

> 优缺点
>
只能代理接口
#### CGLIB动态代理
> 什么是CGLIB动态代理
>
是一个开源的java项目,是基于字节码.
[链接](https://github.com/cglib/cglib)

>Byte Code Generation Library is high level API to generate and transform JAVA byte code.

>基本原理
>
基于ASM的字节码生成库
>使用场景
>
AOP,TEST,还是数据访问的框架(Hibernate,iBatis)
>优缺点
>
- 可以代理类也可以代理接口
- 类/方法被修饰为static,private,final的时候不能代理

>JDK动态代理与CGLIB动态代理比较
>
- JDK有局限性，只能代理接口
- JDK是基于反射实现的，在生成类过程会比较快
- CGLIB是基于ASM实现的，在执行相关代理类的过程中比较快

>还有其他的动态代理技术吗
>
- 基于 Aspectj 实现动态代理（修改目标类的字节，织入代理的字节，在程序编译的时候 插入动态代理的字节码，不会生成全新的Class ）
- 基于 instrumentation 实现动态代理（修改目标类的字节码、类装载的时候动态拦截去修改，基于javaagent） -javaagent:spring-instrument-4.3.8.RELEASE.jar （类装载的时候 插入动态代理的字节码，不会生成全新的Class ）
> ASM是什么
>
[官网](https://asm.ow2.io/)
[java-asm](https://www.baeldung.com/java-asm)

## 集合
### ArrayList VS LinkList
ArrayList基于数组
LinkList基于链表
### ArrayList扩容机制
默认数组的大小为0，源码中10其实在放第一个元素的时候才会优先扩容到10,之后在当前所需容量小于当前容量时，会扩容当前容量的1.5倍。
基本逻辑是:
先获取最小需要容量，小于10时，容量为10,大于等于10时增加1.5倍
主要的扩容方法是grow()
扩容基本方法是Arrays.copyOf(),他的原理是使用System.arraycopy()是本地方法

### HashMap VS HashTable VS ConcurrentHashMap
#### HashMap
看源码，总结扩容机制和并发下为什么会死循环
##### 扩容机制
```java
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put("xdq" + i, "xdq" + i);
        }
        //k=xdq0,v=xdq0,会执行resize()，这是table的大小为16
        //这里的扩容只是开辟空间
        //k=xdq1,v=xdq1,会将元素放到table上,数组位置是hash(key)&(table大小-1)
        //k=xdq2,v=xdq2,会将元素放到table上,数组位置是hash(key)&(table大小-1)
        //...
        //k=xdq12,v=xdq12时，会发现同一个数组位置有元素，这时候会把新的元素链到原的next节点上
        //并且会发现size=13>16*0.75=12，这个会执行resize()做扩容
        //这里的扩容会开辟原来table大小的2次方(使用的是右移<<1)大小的新的table
        //会将原来table上的元素转移到新的table中，这里面会有三种逻辑
        //1.原来的table数组位置只有一个元素->基本是放在原来索引下
        //2.原来的table数组位置是一个链表->判断是否是相同索引位置，之后从头到尾的转到新的链表上，再放到对应的索引上
        //3.原来的table数组存放的是树节点-> todo

        //只有在节点长度大于等于8时&数组的长度大于等于64才会转红黑树
        //长度大于8但数组长度小于64只会resize()
    }
}
```

##### 为什么会出现死循环

#### ConcurrentHashMap

## 面向对象（多态，继承，封装）
## JVM
### JVM内存模型

## 多线程
锁升级机制
轻量锁，偏向锁，重量锁