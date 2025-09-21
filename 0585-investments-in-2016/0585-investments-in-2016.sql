SELECT  
    ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM (
    SELECT * 
    , COUNT(*) OVER(PARTITION by tiv_2015) tiv_2015_cnt
    , COUNT(*) OVER(PARTITION by lat,lon) city_cnt
    FROM Insurance
) t
WHERE city_cnt = 1 AND tiv_2015_cnt > 1