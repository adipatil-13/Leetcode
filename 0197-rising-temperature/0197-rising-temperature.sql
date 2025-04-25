SELECT today.id
FROM Weather yeaterday 
CROSS JOIN Weather today
WHERE DATEDIFF(today.recordDate, yeaterday.recordDate) = 1
AND today.temperature > yeaterday.temperature;
