package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
// TEST METHOD - finds films by film_id
  public Film findFilmById(int filmId) ;
// TEST METHOD - finds actor by actor_id
  public Actor findActorById(int actorId) ;
// TEST METHOD - finds actors by film_id 
  public List<Actor> findActorsByFilmId(int filmId);
// TEST METHOD - finds films by actors id
  public List<Film> findFilmByActorId(int filmId);
//APP METHOD 1
  public Film userSearchByFilmId(int filmId);
//APP METHOD 2
  public List<Film> searchFilmByKeyWord(String keyword);
//APP METHOD 
//APP METHOD 

  
}
