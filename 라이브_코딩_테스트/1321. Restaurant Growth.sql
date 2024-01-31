SELECT DISTINCT DATE_ADD(C1.visited_on, INTERVAL 6 DAY) AS visited_on
    , SUM(C2.amount) / COUNT(DISTINCT C1.customer_id) AS amount
    , ROUND((SUM(C2.amount) / COUNT(DISTINCT C1.customer_id)) / 7, 2) AS average_amount
FROM Customer C1
    JOIN Customer C2 ON DATEDIFF(C2.visited_on, C1.visited_on) BETWEEN 0 AND 6
WHERE DATE_ADD(C1.visited_on, INTERVAL 6 DAY) <= (
    SELECT MAX(visited_on)
    FROM Customer
)
GROUP BY C1.visited_on
ORDER BY C1.visited_on
;