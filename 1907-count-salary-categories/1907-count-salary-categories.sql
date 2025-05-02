WITH CTE1 AS (
    SELECT * FROM Accounts
    WHERE income < 20000
),
CTE2 AS (
    SELECT * FROM Accounts
    WHERE income <= 50000 and income >= 20000
),
CTE3 AS (
    SELECT * FROM Accounts
    WHERE income > 50000
)
SELECT 'Low Salary' AS category, COUNT(*) AS accounts_count
FROM CTE1
UNION
SELECT 'Average Salary' AS category, COUNT(*) AS accounts_count
FROM CTE2
UNION
SELECT 'High Salary' AS category, COUNT(*) AS accounts_count
FROM CTE3;