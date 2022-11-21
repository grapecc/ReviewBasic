## Mysql 练习

Day01：

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



从不订购的客户

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

