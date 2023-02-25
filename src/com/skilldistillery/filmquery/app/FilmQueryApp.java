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
//    app.test();
    app.launch();
  }

  private void test() throws SQLException  {
// √TEST method below -- for findActorById(4) = 
//	Actor actor = db.findActorById(4);
//    System.out.println(actor);
// √TEST method below -- for findActorById(23) = ANACONDA CONFESSIONS
//    Film film = db.findFilmById(23);
//    System.out.println(film);
// √TEST method below -- for findActorsByFilmId(1)
//	List<Actor> actor = db.findActorsByFilmId(1);
//	System.out.println(actor);
// √TEST method below -- for findFilmByActorId(4)
//	List<Film> film = db.findFilmByActorId(4);
//	System.out.println(film);
  
    
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
//    menu goes here
	  System.out.println("************WELCOME**********************");
	  System.out.println("| 1) Look up films by ID                |");
	  System.out.println("| 2) Look up a film by a search keyword |");
	  System.out.println("| 0) EXIT                               |");
	  System.out.println("*****************************************");
	  System.out.print("CHOOSE OPTION FROM THE MENU: ");
//USER INTERFACE
	  String choice = " ";
		do {
			
			switch (choice =input.next()) {
			case "1":
				System.out.println("*****************************************"
						+ "*****************************************"
						+ "*****************************************");
				System.out.print("ENTER THE FILM ID NUMBER: ");
				int x = input.nextInt();
				Film film;
				film = db.userSearchByFilmId(x);
				if(film != null) {
				System.out.println(film);
				}else {
					System.out.println("Film not found");
				}
				break;
			case "2":
				System.out.println("*****************************************"
						+ "*****************************************"
						+ "*****************************************");
				System.out.print("ENTER THE KEYWORD: ");
				input.nextLine();
				String y = input.nextLine();
				List<Film> films;
				films = db.searchFilmByKeyWord(y);
				if(films != null) {
				System.out.println(films);
				
				}else {
					System.out.println("Films not found");
				}
				
				break;
			case "0":
				System.out.println("Byeeeeeee!");
				if (choice.equalsIgnoreCase("0")) {
					break;
				}
			default:
				System.out.println("Thats not an option. Try again!");
				break;
			}
		} while (!choice.equals("0"));
	  
	  
  }
	  

}
