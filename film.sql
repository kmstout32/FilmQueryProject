--USER STORY 1
SELECT title, release_year, description
    -> FROM film WHERE id = 2;

--USER STORY 2
SELECT title , description FROM film WHERE title LIKE '%the%' OR  description LIKE '%the%';

--USER STORY 3


--USER STORY 4
 SELECT film.title, film.release_year, film.rating, film.description, language.name AS 'language'
         FROM film
         JOIN language
       ON film.language_id = language.id
       WHERE film.id= ?;