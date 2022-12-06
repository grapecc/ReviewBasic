## Mysql 练习

#### Day01：

##### 编写一个 SQL 查询以报告 大国 的国家名称、人口和面积。

World 表：这张表的每一行提供：国家名称、所属大陆、面积、人口和 GDP 值。

| Column Name | Type    |
| ----------- | ------- |
| name        | varchar |
| continent   | varchar |
| area        | int     |
| population  | int     |
| gdp         | int     |

```mysql
如果一个国家满足下述两个条件之一，则认为该国是 大国 ：

面积至少为 300 万平方公里（即，3000000 km2），或者
人口至少为 2500 万（即 25000000）
编写一个 SQL 查询以报告 大国 的国家名称、人口和面积。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/big-countries
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
输入：
World 表：
+-------------+-----------+---------+------------+--------------+
| name        | continent | area    | population | gdp          |
+-------------+-----------+---------+------------+--------------+
| Afghanistan | Asia      | 652230  | 25500100   | 20343000000  |
| Albania     | Europe    | 28748   | 2831741    | 12960000000  |
| Algeria     | Africa    | 2381741 | 37100000   | 188681000000 |
| Andorra     | Europe    | 468     | 78115      | 3712000000   |
| Angola      | Africa    | 1246700 | 20609294   | 100990000000 |
+-------------+-----------+---------+------------+--------------+
输出：
+-------------+------------+---------+
| name        | population | area    |
+-------------+------------+---------+
| Afghanistan | 25500100   | 652230  |
| Algeria     | 37100000   | 2381741 |
+-------------+------------+---------+

错误写法:
select name,population,area 
  from world 
where area >= 3000000  or population >= 25000000
解释:  where条件语句中的or（逻辑或）引起的全表扫描问题，从而导致效率下降。当数据量不大的时候，使用or查询比较好。 以解决由于使用了 OR 导致的全表扫描。当使用数据量很大的时候，使用union比较好。

正确写法
select name,population,area 
  from world 
where area >= 3000000  
union 
select name,population,area 
  from world 
where population >= 25000000

```

| Column Name | Type    |
| ----------- | ------- |
| student     | varchar |
| class       | varchar |

##### 筛选学生数量超过 5 的课程

```mysql
输入: 
Courses table:
+---------+----------+
| student | class    |
+---------+----------+
| A       | Math     |
| B       | English  |
| C       | Math     |
| D       | Biology  |
| E       | Math     |
| F       | Computer |
| G       | Math     |
| H       | Math     |
| I       | Math     |
+---------+----------+
输出: 
+---------+ 
| class   | 
+---------+ 
| Math    | 
+---------+
解释: 
-数学课有6个学生，所以我们包括它。
-英语课有1名学生，所以我们不包括它。
-生物课有1名学生，所以我们不包括它。
-计算机课有1个学生，所以我们不包括它。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/classes-more-than-5-students
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

知识考察点:
group by ......having  
踩坑点: 学生会选错
##方法一
select class from
       courses   group by class  having count(distinct (student)) >= 5
## 方法二
使用上面查询结果的临时表进行子查询，筛选学生数量超过 5 的课程。

SELECT
    class
FROM
    (  SELECT  class, COUNT(DISTINCT student) AS num
    FROM courses GROUP BY class) AS temp_table
WHERE
    num >= 5

```

| Column Name | Type |
| ----------- | ---- |
| product_id  | int  |
| low_fats    | enum |
| recyclable  | enum |

##### 写出 SQL 语句，查找既是低脂又是可回收的产品编号。

product_id 是这个表的主键。
low_fats 是枚举类型，取值为以下两种 ('Y', 'N')，其中 'Y' 表示该产品是低脂产品，'N' 表示不是低脂产品。
recyclable 是枚举类型，取值为以下两种 ('Y', 'N')，其中 'Y' 表示该产品可回收，而 'N' 表示不可回收

```mysql
写出 SQL 语句，查找既是低脂又是可回收的产品编号。
返回结果 无顺序要求 。
Products 表：
+-------------+----------+------------+
| product_id  | low_fats | recyclable |
+-------------+----------+------------+
| 0           | Y        | N          |
| 1           | Y        | Y          |
| 2           | N        | Y          |
| 3           | Y        | Y          |
| 4           | N        | N          |
+-------------+----------+------------+
Result 表：
+-------------+
| product_id  |
+-------------+
| 1           |
| 3           |
+-------------+
只有产品 id 为 1 和 3 的产品，既是低脂又是可回收的产品。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/recyclable-and-low-fat-products
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


select product_id   from 
    Products  where  low_fats ='Y'  and  recyclable  ='Y'



```

寻找用户推荐人

##### 写一个查询语句，返回一个客户列表，列表中客户的推荐人的编号都 不是 2。

| id   | name | referee_id |
| ---- | ---- | ---------- |
| 1    | will | null       |
| 2    | Jane | null       |
| 3    | Alex | 2          |
| 4    | Bill | null       |
| 5    | Zack | 1          |
| 6    | Mark | 2          |

```
写一个查询语句，返回一个客户列表，列表中客户的推荐人的编号都 不是 2。
对于上面的示例数据，结果为：
+------+
| name |
+------+
| Will |
| Jane |
| Bill |
| Zack |
+------+

##考察点
ifnull 函数   ifnull(expression,alt_value)
IFNULL() 函数用于判断第一个表达式是否为 NULL，如果为 NULL 则返回第二个参数的值

select name   from customer  
       where iFNULL(referee_id, 0) != 2


```

##### 从不订购的客户

Customers 表

| Id   | Name  |
| ---- | ----- |
| 1    | Joe   |
| 2    | Henry |
| 3    | Sam   |
| 4    | Max   |

Orders表

| Customers |
| --------- |
| Henry     |
| Max       |

```mysql
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/customers-who-never-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 基础解法
select  name as  Customers  from Customers  where
    Id not in (select CustomerId   from Orders  )
select  c.name as  Customers  from Customers c where
 not exists (select CustomerId   from Orders o  where  c.Id = o.CustomerId)

## 
#  select   a.Name as  Customers  from Customers  a
#   left join Orders b on   b.CustomerId  = a.Id   where b.id is null


```

#### day02 :

##### 计算特殊奖金

| 列名        | 类型                                    |
| ----------- | --------------------------------------- |
| employee_id | int                                     |
| name        | varchar                                 |
| salary      | int                                     |
|             | 此表的每一行给出了雇员id ，名字和薪水。 |

```mysql
写出一个SQL 查询语句，计算每个雇员的奖金。如果一个雇员的id是奇数并且他的名字不是以'M'开头，那么他的奖金是他工资的100%，否则奖金为0。
eturn the result table ordered by employee_id.

返回的结果集请按照employee_id排序。
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/calculate-special-bonus
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

输入：
Employees 表:
+-------------+---------+--------+
| employee_id | name    | salary |
+-------------+---------+--------+
| 2           | Meir    | 3000   |
| 3           | Michael | 3800   |
| 7           | Addilyn | 7400   |
| 8           | Juan    | 6100   |
| 9           | Kannon  | 7700   |
+-------------+---------+--------+
输出：
+-------------+-------+
| employee_id | bonus |
+-------------+-------+
| 2           | 0     |
| 3           | 0     |
| 7           | 7400  |
| 8           | 0     |
| 9           | 7700  |
+-------------+-------+
解释：
因为雇员id是偶数，所以雇员id 是2和8的两个雇员得到的奖金是0。
雇员id为3的因为他的名字以'M'开头，所以，奖金是0。
其他的雇员得到了百分之百的奖金。

###题解

###  奇数id   
##  名字不是以M开头
##    奖金为工资100%


select a.employee_id ,IFNULL(c.salary, 0) as bonus 
     from Employees  a 
     left join (select b.employee_id , b.salary  
         from  Employees b  where  b.employee_id%2 != 0 
         and name NOT  like('M%')) c 
         on a.employee_id = c.employee_id  order by employee_id asc
```

##### 	变更性别



| id     | int     |      |
| ------ | ------- | ---- |
| name   | varchar |      |
| sex    | ENUM    |      |
| salary | int     |      |

```sql
请你编写一个 SQL 查询来交换所有的 'f' 和 'm' （即，将所有 'f' 变为 'm' ，反之亦然），仅使用 单个 update 语句 ，且不产生中间临时表。

注意，你必须仅使用一条 update 语句，且 不能 使用 select 语句。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/swap-salary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

输入：
Salary 表：
+----+------+-----+--------+
| id | name | sex | salary |
+----+------+-----+--------+
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |
+----+------+-----+--------+
输出：
+----+------+-----+--------+
| id | name | sex | salary |
+----+------+-----+--------+
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |
+----+------+-----+--------+

###考察点  case when
update salary 
    set  sex =  case sex when 'm' then  'f' else 'm' end
```

##### 删除重复电子邮箱

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
id是该表的主键列。
该表的每一行包含一封电子邮件。电子邮件将不包含大写字母。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/delete-duplicate-emails
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

输入: 
Person 表:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
输出: 
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
解释: john@example.com重复两次。我们保留最小的Id = 1。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/delete-duplicate-emails
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id

```

#### day03:

##### 修复表中的名字

```
Users表
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| user_id        | int     |
| name           | varchar |
+----------------+---------+
user_id 是该表的主键。
该表包含用户的 ID 和名字。名字仅由小写和大写字符组成。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/fix-names-in-a-table
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
编写一个 SQL 查询来修复名字，使得只有第一个字符是大写的，其余都是小写的。
输入：
Users table:
+---------+-------+
| user_id | name  |
+---------+-------+
| 1       | aLice |
| 2       | bOB   |
+---------+-------+
输出：
+---------+-------+
| user_id | name  |
+---------+-------+
| 1       | Alice |
| 2       | Bob   |
+---------+-------+
###考察点 contact 
## 字段截取 left， substr ， lower，upper 函数

select user_id ,
       concat(upper(left(name,1)),lower(substr(name,2))) as name
       from Users order by user_id;

```

#####  按日期分组销售产品

```
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| sell_date   | date    |
| product     | varchar |
+-------------+---------+
此表没有主键，它可能包含重复项。
此表的每一行都包含产品名称和在市场上销售的日期。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/group-sold-products-by-the-date
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

编写一个 SQL 查询来查找每个日期、销售的不同产品的数量及其名称。
每个日期的销售产品名称应按词典序排列。
返回按 sell_date 排序的结果表。
查询结果格式如下例所示。

输入：
Activities 表：
+------------+-------------+
| sell_date  | product     |
+------------+-------------+
| 2020-05-30 | Headphone   |
| 2020-06-01 | Pencil      |
| 2020-06-02 | Mask        |
| 2020-05-30 | Basketball  |
| 2020-06-01 | Bible       |
| 2020-06-02 | Mask        |
| 2020-05-30 | T-Shirt     |
+------------+-------------+
输出：
+------------+----------+------------------------------+
| sell_date  | num_sold | products                     |
+------------+----------+------------------------------+
| 2020-05-30 | 3        | Basketball,Headphone,T-shirt |
| 2020-06-01 | 2        | Bible,Pencil                 |
| 2020-06-02 | 1        | Mask                         |
+------------+----------+------------------------------+
解释：
对于2020-05-30，出售的物品是 (Headphone, Basketball, T-shirt)，按词典序排列，并用逗号 ',' 分隔。
对于2020-06-01，出售的物品是 (Pencil, Bible)，按词典序排列，并用逗号分隔。
对于2020-06-02，出售的物品是 (Mask)，只需返回该物品名。

###考察点group_concat(distinct clounmName order by  clounmName separator ',')
select sell_date,count(distinct(product)) as num_sold ,
       group_concat(distinct product order by product separator ',' ) as products
       from Activities  
       group by sell_date 
       order by sell_date;
```

##### 患某种疾病的患者

```
患者信息表： Patients

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| patient_id   | int     |
| patient_name | varchar |
| conditions   | varchar |
+--------------+---------+
patient_id （患者 ID）是该表的主键。
'conditions' （疾病）包含 0 个或以上的疾病代码，以空格分隔。
这个表包含医院中患者的信息。
 

写一条 SQL 语句，查询患有 I 类糖尿病的患者 ID （patient_id）、患者姓名（patient_name）以及其患有的所有疾病代码（conditions）。I 类糖尿病的代码总是包含前缀 DIAB1 。

按 任意顺序 返回结果表。

查询结果格式如下示例所示。


输入：
Patients表：
+------------+--------------+--------------+
| patient_id | patient_name | conditions   |
+------------+--------------+--------------+
| 1          | Daniel       | YFEV COUGH   |
| 2          | Alice        |              |
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 |
| 5          | Alain        | DIAB201      |
+------------+--------------+--------------+
输出：
+------------+--------------+--------------+
| patient_id | patient_name | conditions   |
+------------+--------------+--------------+
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 | 
+------------+--------------+--------------+
解释：Bob 和 George 都患有代码以 DIAB1 开头的疾病

###考察点  locate(substr, str)  substr 在str中是否含有  不存在就反回0   regexp 正则匹配

select patient_id ,patient_name ,conditions   
      from Patients where conditions  regexp  '^DIAB1| DIAB1'  order by patient_id 
```

####  day04:

##### 丢失信息的雇员

```
写出一个查询语句，找到所有 丢失信息 的雇员id。当满足下面一个条件时，就被认为是雇员的信息丢失：

雇员的 姓名 丢失了，或者
雇员的 薪水信息 丢失了，或者
返回这些雇员的id  employee_id ， 从小到大排序 。


输入：
Employees table:
+-------------+----------+
| employee_id | name     |
+-------------+----------+
| 2           | Crew     |
| 4           | Haven    |
| 5           | Kristian |
+-------------+----------+
Salaries table:
+-------------+--------+
| employee_id | salary |
+-------------+--------+
| 5           | 76071  |
| 1           | 22517  |
| 4           | 63539  |
+-------------+--------+
输出：
+-------------+
| employee_id |
+-------------+
| 1           |
| 2           |
+-------------+
解释：
雇员1，2，4，5 都工作在这个公司。
1号雇员的姓名丢失了。
2号雇员的薪水信息丢失了。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/employees-with-missing-information
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 考察点  union all 全链接 
select  employee_id from 
(select employee_id from Employees 
 union all 
 select employee_id from Salaries ) as t 
 group by employee_id
  having count(employee_id) =1
order by employee_id  asc
```

 ##### 每个产品在不同商店的价格



```mysql
表 : Products
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| product_id  | int     |
| store1      | int     |
| store2      | int     |
| store3      | int     |
+-------------+---------+
这张表的主键是product_id（产品Id）。
每行存储了这一产品在不同商店store1, store2, store3的价格。
如果这一产品在商店里没有出售，则值将为null。

输入：
Products table:
+------------+--------+--------+--------+
| product_id | store1 | store2 | store3 |
+------------+--------+--------+--------+
| 0          | 95     | 100    | 105    |
| 1          | 70     | null   | 80     |
+------------+--------+--------+--------+
输出：
+------------+--------+-------+
| product_id | store  | price |
+------------+--------+-------+
| 0          | store1 | 95    |
| 0          | store2 | 100   |
| 0          | store3 | 105   |
| 1          | store1 | 70    |
| 1          | store3 | 80    |
+------------+--------+-------+
解释：
产品0在store1，store2,store3的价格分别为95,100,105。
产品1在store1，store3的价格分别为70,80。在store2无法买到。

###   行专列  考点 union all 
select product_id , 'store1'  as store  ,store1 as  price from Products  where store1 is not null 
union all
select product_id , 'store2'  as store  ,store2 as  price from Products  where store2 is not null 
union all
select product_id , 'store3'  as store  ,store3 as  price from Products  where store3 is not null 
```

##### 树节点



```mysql
给定一个表 tree，id 是树节点的编号， p_id 是它父节点的 id 。
+----+------+
| id | p_id |
+----+------+
| 1  | null |
| 2  | 1    |
| 3  | 1    |
| 4  | 2    |
| 5  | 2    |
+----+------+

叶子：如果这个节点没有任何孩子节点。
根：如果这个节点是整棵树的根，即没有父节点。
内部节点：如果这个节点既不是叶子节点也不是根节点。
 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/tree-node
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


+----+------+
| id | Type |
+----+------+
| 1  | Root |
| 2  | Inner|
| 3  | Leaf |
| 4  | Leaf |
| 5  | Leaf |
+----+------+

###根 没有父节点
### 叶子 有父节点  id 在p_id 中没有记录
### innner 有父节点 id 在p_id 中有记录

select id , 'Root' as Type  from tree where p_id is null
union all 
select id , 'Inner'  as Type from tree  where id   in  (select distinct p_id from tree where p_id is not  null) 
and p_id is not null
union all
select id , 'Leaf' as Type from tree  where id not  in  (select distinct  p_id from tree where p_id is not  null) 
and p_id is not null
```

##### 第二高的薪水



```
示例1:
输入：
Employee 表：
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
输出：
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
示例2:
输入：
Employee 表：
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
输出：
+---------------------+
| SecondHighestSalary |
+---------------------+
| null                |
+---------------------+

###考察点 IFNULL 函数  limit 1 OFFSET  1   DISTINCT

select IFNULL(
    (select DISTINCT salary    from Employee 
order by salary desc limit 1 OFFSET  1),null ) as SecondHighestSalary
```

