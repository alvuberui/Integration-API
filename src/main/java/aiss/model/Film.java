package aiss.model;



public class Film {

	private String id;
	private String title;
	private String director;
	private String date;
	private Boolean available;
	private String genre;
	private Integer duration; 
	


	public Film(String title, String director,String date , String genre, Boolean status, Integer duration) {
		this.title = title;
		this.director = director;
		this.date = date;
		this.available = status;
		this.genre = genre;
		this.duration = duration;
	}

	public Film() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}