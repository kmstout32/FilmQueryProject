package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";

	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//TEST METHOD
	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		// ...
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

		try {

			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();

			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setId(actorResult.getInt(1));
				actor.setFirstName(actorResult.getString(2));
				actor.setLastName(actorResult.getString(3));
				actor.setFilms(findFilmByActorId(actorId)); // An Actor has Films
			}
			// ...
			return actor;
		} catch (SQLException e) {
		}
		return actor;

	}

//TEST METHOD 
	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		String sql = "SELECT id, title, description, release_year,"
				+ "language_id, rental_duration, rental_rate, length, replacement_cost, rating,"
				+ "special_features FROM film WHERE id = ?";

		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();

			if (filmResult.next()) {
				film = new Film();

				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguage(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return film;

	}

//TEST METHOD
	@Override
	public List<Film> findFilmByActorId(int actorId) {
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features "
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Integer filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				Integer releaseYear = rs.getInt("release_year");
				Integer langId = rs.getInt("language_id");
				Integer rentDur = rs.getInt("rental_duration");
				Double rate = rs.getDouble("rental_rate");
				Integer length = rs.getInt("length");
				Double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;

	}

//TEST METHOD
	@Override
	public List<Actor> findActorsByFilmId(int filmId) {

		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id\n"
					+ "JOIN film ON film_actor.film_id = film.id WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Actor actor = new Actor(id, firstName, lastName);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;

	}

//APP METHOD 1
	@Override
	public Film userSearchByFilmId(int filmId) {
		Film film = new Film();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT title, release_year, description FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				film.setTitle(rs.getString("title"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setDescription(rs.getString("description"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return film;
	}

//APP METHOD 2
	@Override
	public List<Film> searchFilmByKeyWord(String keyword) {
		List<Film> films = new ArrayList<>();
		
		String sql = "SELECT title ,description FROM film WHERE title LIKE ? OR  description LIKE ?";
		try {
			Connection conn;
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String title = rs.getString("title");
				
				String desc = rs.getString("description");
				Film film = new Film(title, desc);
				films.add(film);
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return films;
	
		
	
	}


}
