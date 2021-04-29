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
|float|4|32| | |0f|Float|
|double|8|64| | |0d|Double|
|byte|1|8| | | |Byte|
|char|2|16| | |'u0000'|Character| 
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

## 集合
### ArrayList VS LinkList

### HashMap VS HashTable VS CurrentHashMap
## 面向对象（多态，继承，封装）
## JVM
## 多线程