SELECT x, y, z, CASE WHEN x + y > z && y + z > x && x + z > y THEN 'Yes' ELSE 'No' END AS triangle FROM Triangle
