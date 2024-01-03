WITH result AS (
    SELECT CASE
        WHEN income < 20000 THEN 'Low Salary'
        WHEN income >= 20000 AND income <= 50000 THEN 'Average Salary'
        WHEN income > 50000 THEN 'High Salary'
        ELSE null
    END AS category
        , COUNT(*) AS accounts_count
    FROM Accounts 
    GROUP BY category
)

SELECT C.category
    , IF(R.category IS NULL, 0, R.accounts_count) AS accounts_count
FROM result R
RIGHT OUTER JOIN (
    SELECT 'Low Salary' AS category
    UNION
    SELECT 'Average Salary' AS category
    UNION
    SELECT 'High Salary' AS category
) C ON R.category = C.category