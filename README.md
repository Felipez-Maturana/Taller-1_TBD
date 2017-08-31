# README #

Para correr la aplicación en el boot de spring ejecutar "gradle bootrun"

Para empaquetar en un war se debe ejecutar "gradle war"

Una vez empaquetado el proyecto en un war se puede desplegar en tomcat 8

# Código de Ejemplo para Taller de Base de Datos #

El taller JavaEE consiste en construir servicios del tipo GET y POST para la tabla Film_Actor.

GET

/actors/1/films --> retorna todas las películas en las que ha participado el actor 1.

/films/1/actors ---> retorna todos los actores de la película 1.

POST

/actors/1/films/2 --> vincula la película 2 al actor 1. (se debe validar que exista la película 2).

/films/1/actors/2 --> vincula el actor 2 a la película 1. (se debe validar que exista la actor 2).

  //FROM sakila.actor JOIN sakila.film_actor ON sakila.actor.actor_id=sakila.film_actor.actor_id WHERE sakila.actor.actor_id = 1
  //This is using a named query method
  @Query("select a FROM Actor a JOIN film_actor ON a.actor_id=film_actor.actor_id WHERE a.actor_id = ?1")