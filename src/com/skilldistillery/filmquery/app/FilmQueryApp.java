package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) throws SQLException {
    FilmQueryApp app = new FilmQueryApp();
    app.test();
//    app.launch();
  }

  private void test() throws SQLException  {
// √TEST method below -- for findActorById(4) = 
//	  Actor actor = db.findActorById(4);
//    System.out.println(actor);
// √TEST method below -- for findActorById(23) = ANACONDA CONFESSIONS
//    Film film = db.findFilmById(23);
//    System.out.println(film);
// √TEST method below -- for findActorsByFilmId(1)
//	 List<Actor> actor = db.findActorsByFilmId(1);
//	  System.out.println(actor);
// √TEST method below -- for findFilmByActorId(4)
//	  List<Film> film = db.findFilmByActorId(4);
//	  System.out.println(film);
  
    
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
//    menu goes here
  }

}
