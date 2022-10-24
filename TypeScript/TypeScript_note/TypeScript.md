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

   ```
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

   ```
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
   consloe.log(c)  // 若无默认值则输出当前索引
   ```

   