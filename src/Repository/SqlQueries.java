package Repository;

public class SqlQueries {
    String q1 = "select product_id from Products where recyclable = 'Y' and low_fats  = 'Y';";
    String q2 ="SELECT name FROM Customer WHERE (referee_id != 2 )OR (referee_id IS NULL);";
}
/*
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| product_id  | int     |
| low_fats    | enum    |
| recyclable  | enum    |
+-------------+---------+
* */
//Notes : As

/*
Select author_id as id from Views  (here author_id need to seen as id in outPut )
where author_id = viewer_id
group by author_id
order by author_id; (Ascending order)


SELECT tweet_id
FROM Tweets
WHERE LENGTH(content) > 15; (Checks the character count to be greater then 15 in string)


//Proper left Join
select t2.unique_id, t1.name
from Employees as t1
left join
EmployeeUNI as t2
on t1.id = t2.id; (conditioning for joins is mentioned using On)



Note******
LEFT JOIN Transactions t ON v.visit_id = t.visit_id   (THIS LINE ITSELF GIVES RESULT)
WHERE t.transaction_id IS NULL  (Select null transaction entries after doing left join)


so

SELECT v.customer_id, COUNT(*) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;

used over

select a.customer_id, count(a.visit_id) as count_no_trans from
(
    select t.transaction_id, v.visit_id, t.amount, v.customer_id
    from Visits as v
    left join Transactions as t
    on v.visit_id = t.visit_id
) as a
where a.transaction_id is null
group by a.customer_id



//Some other problem

SELECT t1.id
FROM Weather t1
JOIN Weather t2 ON t1.recordDate = DATE_ADD(t2.recordDate, INTERVAL 1 DAY)   (can do operations on joins on condition also)
WHERE t1.temperature > t2.temperature; (Date related operations should done using standard functions)


 */


/*
select query_name,
Round(Avg(rating/position),2) as quality,
COALESCE(
Round(
    (
    (select count(*) as p from Queries where rating<3 and query_name=q.query_name group by query_name) *** directly can use SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) ***
    /
    (select count(*) as p from Queries where query_name=q.query_name group by query_name)  ***directly can use COUNT(*)***
    )*100
    ,
    2)
 ,0) as poor_query_percentage
from Queries as q
where query_name is not null
group by query_name

*/