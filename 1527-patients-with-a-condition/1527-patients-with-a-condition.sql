-- SELECT * FROM Patients WHERE conditions REGEXP '^DIAB1| DIAB1';
SELECT * FROM Patients WHERE conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%'

