WITH count_friends AS (
    SELECT requester_id AS id 
        , COUNT(requester_id) AS num
    FROM RequestAccepted
    GROUP BY requester_id
    UNION ALL
    SELECT accepter_id AS id
        , COUNT(accepter_id) AS num
    FROM RequestAccepted
    GROUP BY accepter_id
),
sum_count AS (
    SELECT id
        , SUM(num) AS num
    FROM count_friends
    GROUP BY id
)

SELECT *
FROM sum_count
WHERE num = (
    SELECT MAX(num) AS num
    FROM sum_count
)