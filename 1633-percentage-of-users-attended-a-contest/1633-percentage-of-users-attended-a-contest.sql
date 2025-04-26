SELECT 
    contest_id, 
    ROUND(COUNT(DISTINCT user_id) * 100 / (SELECT COUNT(DISTINCT user_id) FROM Users), 2) as percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage DESC, contest_id

