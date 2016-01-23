/* Write your MySQL query statement below */

SET @no = 0;

SELECT s.Score AS Score, t.Rank AS Rank FROM Scores AS s LEFT JOIN
    (SELECT o.Score AS Score, @no := @no + 1 AS Rank FROM (SELECT * FROM Scores GROUP BY Score ORDER BY Score DESC) AS o) AS t
    ON s.Score = t.Score ORDER BY s.Score DESC;
