# Write your MySQL query statement below
SELECT U.user_id AS buyer_id
    , U.join_date
    , IFNULL(COUNT(order_date), 0) AS orders_in_2019
FROM Orders O
    RIGHT JOIN (
        SELECT user_id
            , join_date
        FROM Users
    ) U ON O.buyer_id = U.user_id
    AND YEAR(O.order_date) = '2019'
GROUP BY U.user_id
;