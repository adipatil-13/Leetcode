SELECT employee_id FROM Employees as e WHERE salary < 30000 AND manager_id NOT IN (SELECT employee_id FROM Employees) GROUP BY employee_id ORDER BY employee_id;


