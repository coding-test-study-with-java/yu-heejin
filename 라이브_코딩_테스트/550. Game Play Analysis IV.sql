# 최초 로그인 날짜 구하기
WITH first_logged AS (
    SELECT player_id
        , MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
)

SELECT ROUND(COUNT(IF(A.player_id IS NULL, NULL, 1)) / COUNT(*), 2) AS fraction
FROM first_logged F
    LEFT JOIN Activity A ON F.player_id = A.player_id
    AND A.event_date = DATE_ADD(F.first_date, INTERVAL 1 DAY)
;