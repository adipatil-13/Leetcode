SELECT user_id, 
ROUND(AVG(CASE WHEN action = 'confirmed' THEN 1 ELSE 0 END), 2) AS confirmation_rate
FROM Confirmations
RIGHT JOIN Signups USING (user_id)
GROUP BY user_id;

