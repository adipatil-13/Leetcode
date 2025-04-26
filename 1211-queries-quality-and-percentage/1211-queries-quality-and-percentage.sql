SELECT query_name, ROUND(AVG(rating / position), 2) as quality,
ROUND(SUM(rating < 3) * 100 / COUNT(*), 2) AS poor_query_percentage
FROM Queries
GROUP BY query_name;
