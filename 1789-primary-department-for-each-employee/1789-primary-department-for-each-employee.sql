SELECT employee_id, department_id
FROM Employee
WHERE primary_flag = 'Y' OR
employee_id IN (
    SELECT employee_id
    FROM Employee
    GROUP BY employee_id
    HAVING COUNT(employee_id) = 1
)

-- SELECT employee_id,
--     department_id
-- FROM Employee
-- GROUP BY employee_id
-- HAVING COUNT(employee_id) = 1
-- UNION
-- SELECT employee_id,
--     department_id
-- FROM Employee
-- WHERE primary_flag  = 'Y'

-- Display only those that have either 1 department only with 'N' or those who belong to multiple departments and that department primary flag is 'Y'