SELECT p.product_id, ROUND(SUM(p.price * u.units) / SUM(u.units), 2) as average_price
FROM Prices p LEFT JOIN UnitsSold u
ON p.product_id = u.product_id
AND u.purchase_date BETWEEN start_date AND end_date
GROUP BY product_id;
