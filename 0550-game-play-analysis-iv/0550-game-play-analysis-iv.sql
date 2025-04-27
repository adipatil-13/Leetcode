SELECT
  ROUND(
    COUNT(DISTINCT player_id) / 
    (SELECT COUNT(DISTINCT player_id) FROM Activity), 
    2
  ) AS fraction
FROM Activity
WHERE
  (player_id, DATE_SUB(event_date, INTERVAL 1 DAY)) IN (
    SELECT player_id, MIN(event_date) AS first_login 
    FROM Activity 
    GROUP BY player_id
  );

-- WITH CTE AS (
--     SELECT DISTINCT a1.player_id
--     FROM Activity a1
--     JOIN Activity a2 
--     ON a1.player_id = a2.player_id 
--     AND DATEDIFF(a1.event_date, a2.event_date) = 1
-- )
-- SELECT 
--     ROUND( COUNT(DISTINCT c.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) 
--     AS fraction
-- FROM CTE c;