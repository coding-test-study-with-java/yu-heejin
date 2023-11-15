WITH success_insurance AS (
    SELECT *
    FROM insurance I
    GROUP BY lat, lon
    HAVING COUNT(*) = 1
)

SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM success_insurance SI
WHERE tiv_2015 IN (
    SELECT tiv_2015
    FROM insurance
    WHERE pid <> SI.pid
)