SELECT MAX(num) AS num FROM (
    SELECT num 
    FROM MyNumbers 
    GROUP BY num 
    HAVING count(*) = 1
) AS SingleMaxNumber;
