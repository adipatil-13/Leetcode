SELECT u.user_id as buyer_id, u.join_date, COUNT(o.order_id) AS orders_in_2019
FROM Users u
LEFT JOIN (
    SELECT order_id, order_date, buyer_id
    FROM Orders
    WHERE order_date >= '2019-01-01' AND order_date < '2020-01-01'
) o
ON u.user_id = o.buyer_id 
GROUP BY u.user_id, u.join_date;