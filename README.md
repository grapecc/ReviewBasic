# ReviewBasic
**构造方法特点：**

1.方法名和类名相同

2.通过new方法实例化对象调用

3.当没有定义的时候系统会自动添加一个，添加自定义构造方法的时候会覆盖午餐的

4.构造方法没有返回类型

**jvm 虚拟机模型** 

  线程 （程序计数器、虚拟机栈、本地方法栈），方法区 ，堆(年轻代，年老代，永久代)

垃圾回收机制:即回收堆中的对象

分配对象 ：new 关键字创建对象

释放对象：将对象赋值为null

**垃圾回收过程：**

发现无用的对象，回收无用对象占用的内存空间

垃圾回收相关算法：**引用技术法**   每一个对象引入一个计数器，引用的时候技术器加一，指向的对象失效的时候 则减一，当计数器为零的时候，则该对象无用，进行回收。

**根搜索法**

年轻代 》》》minor GC

年老代》》》major GC

永久代》》》full  GC

system.gc()//然后建议使用通过建议 然后让服务员进行清扫

**内存泄漏操作一般案例**

1.创建大量无用对象

```
for (int i = 0; i < 5000 ; i++) {
            str += i;  //创建5000个对象
        }
```

2.静态集合类的适合用 像 HashMap ，List ， vector 

3.各种创建对象(IO对象、数据库对象、网络连接对象)未关闭

4.监听器的使用

this 指创建对象的地址     在构造方法中指当前对象

自动装箱/拆箱

自动装箱：基础数据类型在所需对象的类型时 ，自动转化为对象

```
Interger  i =5；   ///实际操作 是Interger  i = new Interger(5)；

```

拆箱：需要某一个值时，对象会自动转化为基本数据类型

```
Interger  i =5；
int j = i;
```

String 、StringBuilder 、 StringBuffer

```
string 长度不可变
StringBuilder(效率高，线性不安全) 、 StringBuffer（效率低，线程安全）      都可变
```

<<<<<<< HEAD
枚举：

```
* Description :  枚举  一个类有多个实例
* 例如word文档的对齐方式有几种：左对齐、居中对齐、右对齐。开车的方向有几种：前、后、左、右！
```
=======

>>>>>>> origin/main

建立该仓库原由，主要是因为期间面试过程中发下自己很多地方碰壁，然后自省自己基础很薄弱，于是乎就自己网上找了点资料进行自我复习

字符流 、文件字节流

## radius相关知识点

```radius
radius 存储五大类型
String类型 哈希，list ，set ，sortSet
string 基本指令
radius基础的库一般有16 个
通过使用以下命令
select  index
String 操作基本命令
  set username 1   //存储单个字符串  以键值对得到形式进行存储
  mset username 1  age 18 //批量操作存储子字符串
  get username  //获取某个键值对的值
  mget username age //获取多个键值
  append username 123  //在某一个字段追加
  incr username  // 每次增量+1
  decr username  // 每次减量 1 
  incrby username 10 // 每次增量 +10
  decrby username 10 
map 因为 只修改对象中某一个键值对的时候使用 上述操作会造成资源浪费的问题
  可以通过哈希操作指令
  hset testDemo username gape
  hmset testDemo age 20 address yongji
  hget testDemo username
  hget testDemo username  address
  hkeys testDemo  //获取集合中的key
  hvals testDemo  
list  可以进行操作未左插入和右插入
   lpush list_demo 1 2 3 4 5 6
   rpush list_demo2 1 2 3 4 5 6
   lrange list_demo 0 -1  //查询全部   StartIndex endIndex 
   lindex list_demo 1  //根据索引获取当前的 值
   llen   list_demo  查询当前的集合长度
set  
	sadd setDemo a b c 
	srem setDemo c 
	sdiff setA setB  //取 setA中没有的setB 元素
	sdiff setA setB   // 相反
    sinter setA setB //取两个集合的交集
    sunion setA setB //取并集
    scard setA //获取当前集合下的的个数
    set members setA // 查看当前的setA 集合中的元素
    set ismember setA hello  //查看某元素是否存在  有为1 无为0 
    
    
设置过期时间 
  expire username 10   //设置过期时间
  ttl username    //查看距离过期还剩的时间
  
```

