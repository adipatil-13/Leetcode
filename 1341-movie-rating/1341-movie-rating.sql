(
    SELECT u.name AS results FROM Users u
    JOIN Movierating m on u.user_id = m.user_id
    GROUP BY u.user_id 
    ORDER BY COUNT(m.rating) DESC, u.name ASC
    LIMIT 1
)
UNION ALL
(
    SELECT m.title AS results FROM Movies m
    JOIN Movierating mr ON mr.movie_id = m.movie_id
    WHERE mr.created_at LIKE '2020-02%'
    GROUP BY m.movie_id
    ORDER BY AVG(mr.rating) DESC, m.title ASC
    LIMIT 1
);
