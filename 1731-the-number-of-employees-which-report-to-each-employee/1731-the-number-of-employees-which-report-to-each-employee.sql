SELECT 
    manager.employee_id, 
    manager.name, 
    COUNT(employee.employee_id) AS reports_count, 
    ROUND(AVG(employee.age)) AS average_age
FROM Employees employee 
JOIN Employees manager
ON employee.reports_to = manager.employee_id
GROUP BY employee_id
ORDER BY employee_id;
