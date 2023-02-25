package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {

	// TODO Auto-generated constructor stub
	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private int language;
	private int rentalDuration;
	private double rate;
	private Integer length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	private String language_name;
	public Film() {
		
	}
	
	public Film(String title2, Integer releaseYear2, String desc) {
		this.title = title2;
		this.releaseYear = releaseYear2;
		this.description = desc;
	}

	public Film(int filmId, String title, String desc, Integer releaseYear, int langId, int rentDur, double rate,
			Integer length, double repCost, String rating, String features) {
		this.id = filmId;
		this.title = title;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.language = langId;
		this.rentalDuration = rentDur;
		this.rate = rate;
		this.length = length;
		this.replacementCost = repCost;
		this.rating = rating;
		this.specialFeatures = features;
		
	}

	public Film(int filmId, String title, String desc, Integer releaseYear, int langId, int rentDur, double rate,
			Integer length, double repCost, String rating, String features, List<Actor> actors) {
		this.id = filmId;
		this.title = title;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.language = langId;
		this.rentalDuration = rentDur;
		this.rate = rate;
		this.length = length;
		this.replacementCost = repCost;
		this.rating = rating;
		this.specialFeatures = features;
		this.actors = actors;
	}

	public Film(String title, String desc) {
		this.title = title;
		this.description = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
// TEST toString
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Film [id=").append(id).append(", title=").append(title).append(", description=")
//				.append(description).append(", releaseYear=").append(releaseYear).append(", language=").append(language)
//				.append(", rentalDuration=").append(rentalDuration).append(", length=").append(length)
//				.append(", replacementCost=").append(replacementCost).append(", rating=").append(rating)
//				.append(", specialFeatures=").append(specialFeatures).append("]");
//		return builder.toString();
//	}
//APP toString 
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Film]: ").append(title)
		.append(" [Release Year]: ").append(releaseYear)
		.append(" [Film Description]: ").append(description);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, language, length, rating, releaseYear, rentalDuration, replacementCost,
				specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && id == other.id && language == other.language
				&& Objects.equals(length, other.length) && Objects.equals(rating, other.rating)
				&& Objects.equals(releaseYear, other.releaseYear) && rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

	public String getLanguage_name() {
		return language_name;
	}

	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}

}
