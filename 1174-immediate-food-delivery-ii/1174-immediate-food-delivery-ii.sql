SELECT ROUND(AVG(order_date = customer_pref_delivery_date) * 100, 2) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (
    SELECT customer_id, MIN(order_date)
    FROM Delivery
    GROUP BY customer_id
);

-- WITH first_order AS(
--     SELECT customer_id, MIN(order_date) AS firstOrder
--     FROM Delivery
--     GROUP BY customer_id
-- ),
-- immediate_order AS(
--     SELECT customer_id, order_date
--     FROM Delivery
--     WHERE order_date = customer_pref_delivery_date
-- )
-- SELECT 
--     ROUND(COUNT(io.order_date) * 100 / COUNT(fo.firstOrder), 2) AS immediate_percentage
-- FROM first_order fo
-- LEFT JOIN immediate_order io
-- ON  fo.customer_id = io.customer_id
-- AND fo.firstOrder = io.order_date;