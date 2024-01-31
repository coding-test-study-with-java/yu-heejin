WITH S2 AS (
    SELECT id
        , visit_date
        , people
        , LEAD(people, 1) OVER (ORDER BY id) AS next_people1
        , LEAD(people, 2) OVER (ORDER BY id) AS next_people2
        , LAG(people, 1) OVER (ORDER BY id) AS before_people1
        , LAG(people, 2) OVER (ORDER BY id) AS before_people2
    FROM Stadium
)

SELECT id
    , visit_date
    , people
FROM S2
WHERE people >= 100    # 내가 100이 넘음
    AND (
        (next_people1 >= 100 AND next_people2 >= 100)    # 내 다음, 다다음이 100이 넘음
        OR (before_people1 >= 100 AND before_people2 >= 100)   # 내 이전, 이이전이 100이 넘음
        OR (before_people1 >= 100 AND next_people1 >= 100)   # 내 이전, 다음이 100이 넘음
    )
;