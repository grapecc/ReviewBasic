## TypeScript

#### 安装

```
npm install -g typescript
或者
cnpm install -g typescript
yarm global typescript 
```

#### 运行

```
//ts 编译es5 
tsc hellworld.ts
执行命令后 出现js

```

##  自动编译 .ts文件

1.创建tsconfig.json文件   通过命令 `tsc --init` 生成文件

![微信截图_20221024155804](D:\project\ReviewBasic\TypeScript\TypeScript_note\TypeScript.assets\微信截图_20221024155804.png)

2. typescript  中数据类型

   typescript 中 为了使比那些的代码更加规范，更有利于维护，增加了类型校验。

   typescript 基本数据类型

   ```javascript
   布尔类型-- boolean
   数字类型-- number
   字符串类型-- string
   数组类型-- array
   元组类型-- tuple 
   枚举类型-- enum 
   任意类型-- any
   null-- 和undefined
   void类型
   never类型
   ```

   ```javascript
   --- 布尔声明
   var flag:boolean = ture
   flag= false
   --- 数字类型
   var a:number = 123
   console.log(a)
   a = 12.3
   console.log(a)
   
   ---字符串类型
   var str:string = "this is ts"
   
   --- 数组类型
   第一种方式
   var arr:number[] = [1,2,3,4,5]
   console.log(arr)
   var arr2:string[] = ["php","java"]
   第二种
   let arr:Array<number>= [1,2,3,4,5]
   
   ---元组类型
   let arr[string,number,boolean] = ["ts",123,true]
   
   --- 枚举类型
   enum Flag{
     success= 1,error= -1
   }
   var f:Flag = Flag.success
   consloe.log(f) // 1
   enum Color {red, blue, orange}
   var c:Color = Color.blue
   consloe.log(c)  // 若无默认值则输出当前索引 1
   --任意类型
      var num:any = 123
      num = "str"
      consloe.log(num) 
   
      ///应用场景
      var oBox:any = document.getElementById("box")；
      oBox.style.color = "red";
   
   -- null 和 undefined
   
   ```

3. typescript中的函数

```typescript
//-----es5 函数声明
function run(){
   return 'run';
}
// 匿名函数
var run2 = function(){
 return 'run2';
}
----------------------
// typescript 函数
//ts中定义函数的方法
//函数声明法
function run():string{
   return 'run';
}
//匿名函数
var fun2 = fuction():number{
   return 123；
}
//ts定义方法 传参
function getInfo(name:String, age:number):string{
	return `${name} ---- ${age}`;
}
alert(getInfo("张三"， 100));
//匿名函数
var getInfo = function(name:String, age:number):string{
    return `${name} ---- ${age}`;
}
alert(getInfo("张三"， 100));
---------
方法可选参数
//在es5 方法的实参和形参可以不一样，但ts中必须一样
? 形参允许为空
function getInfo(name:String, age?:number):string{
    if(age){
       return `${name} ---- ${age}`;
    }else{
        return `${name} ---- 年龄保密`;
    }
	
}
alert('张三')
// 扩展运算符 接收新参传过来的值 
function sum(a:number,b:number,c:number,d:number):number{
    return a+b+c+d;
}
function sum(...result:number[]):number{
    var sum = 0;
    for(var i= 0; result.length; i++){
        sum += result;
    }
    return sum;
}
alert(sum(1,2,3,4));
------ts函数重载
//es5
function css(config){
    
}
function css(config,value){
    
}
//ts中的重载
function getInfo(name:string):string;
function getInfo(age:number):number;
function getInfo(str:any):any{
    if(typeod str === 'string'){
       return '我叫'+str;
    }else{
        return '我的年龄是'+str；
    }
}
```

4.typescript 中的类

```typescript
///es5 里的类
//1.构造函数
function Person(){
   this.name = '张三';
   this.age = 20;
}
var p = new Person();
console.log(p.name);
// 2.构造函数和原型链里面增加方法
function Person(name, age){
   this.name = name;
   this.age = age;
    this.run = function(){
        alert(this.name);
    }
}
// 原型链上的属性会被多个实例共享，构造函数不会
Person.prototype.sex= '男'
Person.prototype.work = funcntion(){
    console.log(this.name + '在工作');
}
var p = new Person();
// p.run();
// p.work()
//3. 类里面的静态方法
Person.getInfo =function(){
    console.log("我是静态方法！")
}

p.getInfo();
//4 es5 里面的继承
 function Web(){
     Person.call(this); //冒充对象实现继承
 }
var w = new Web();
w.run();  //对象冒充可以集成构造函数的属性和方法 但是 不可以集成原型链里的属性和方法

 function Web(){
     Person.call(this); //冒充对象实现继承
 }
var w = new Web();
w.run();  //对象冒充可以集成构造函数的属性和方法 但是 不可以集成原型链里的属性和方法

Web.prototype = new Person(); //原型链实现 既可以继承构造函数方法  也可以继承原型链上的属性和方法
var w = new Web(); 
w.work();

//原型链没法给父类传参
Web.prototype = new Person(){
    
}
var w = new Web("赵四"，20); //原型链没法给父类传参


function Web(name, age){
    Person.call(this.name, this.age);  //对象冒充继承，实例化子类可以给父类传参
}
//ts中类的定义
class Person{
    name: string;
    constructor(name:string){ //构造函数 实例化对象的时候触发的方法
        this.name = name;
    }

   run():void{
       alert(this.name);
   }
   getName():string{
       return this.name;
   }
   setName(name:String):void{
       this.name = name;
   }
}
var p = new Person("张三");
p.run();
// 2 ts中实现继承  extend ，super
class Person{
    public name: string;
    constructor(name:string){ //构造函数 实例化对象的时候触发的方法
        this.name = name;
    }

   run():string{
       alert(`${this.name}在运动`);
   }
 
}
//var p = new Person('王五');
//p.run();

class Web extends Person(){
    constructor(name:string){ 
       super(name);
    }
    work(){
        alert(`${this.name}在工作`)
    }
}

var w = new Web('李四');
alert(w.run());
w.work();
//3 类里面的修饰符  tsc  属性定义的时候提供了三种修饰符
/**
public 在类里面 、子类、类外面都可以访问
protected    在类里面、子类里面可以方法问，在类外部没法访问
private   可以在类里面访问，子类和类外部都没法访问
如果不加修饰符的话 默认public
**/


```











