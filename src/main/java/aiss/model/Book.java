package aiss.model;



public class Book {



	private String id;
	private String title;
	private String author;
	private String genre;
	private Boolean available;
	private String date;
	private String details; 
	


	public Book(String title, String author,String date , String details, Boolean Status, String genre) {
		this.date = date;
		this.details = details;
		this.author = author;
		this.genre = genre;
		this.title = title;
		this.available = Status;
	}

	public Book() {
	}
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
		
	}

	public void setDetails(String details) {
		this.details = details;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}	

}