package aiss.model;

import java.util.List;

public class Library {
	
	private String id;
	private String name;
	private String location;
	private Integer availableComputers;
	private Boolean isOpen;
	private List<Book> books;
	private List<Film> films;
	
	public Library(String name, String location, Integer availableComputers, Boolean isOpen) {
		this.name = name;
		this.location = location;
		this.availableComputers = availableComputers;
		this.isOpen = isOpen;
	}
	
	
	public Library() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	protected void setBooks(List<Book> b) {
		books = b;
	}
	
	protected void setFilms(List<Film> f) {
		films = f;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getAvailableComputers() {
		return availableComputers;
	}

	public void setAvailableComputers(Integer availableComputers) {
		this.availableComputers = availableComputers;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public List<Book> getBooks() {
		return books;
	}

	public List<Film> getFilms() {
		return films;
	}
	
	public Book getBook(String id) {
		
		if (books==null)
			return null;
		
		Book book = null;
		Book aux = books.stream().filter(x -> x.getId() == id).findFirst().get();
		if(aux != null) book = aux;
		
		return book;
	}
	public Film getFilm(String id) {
		
		if (films==null)
			return null;
		
		Film film = null;
		Film aux = films.stream().filter(x -> x.getId() == id).findFirst().get();
		if(aux != null) film = aux;
		
		return film;
	}
	
	public void addBook(String id) {
		Book s = getBook(id);
		if(s!=null) {
			books.add(s);
		}
	}
	
	
	public void deleteBook(String id) {
		Book s = getBook(id);
		if (s!=null)
			books.remove(s);
	}
	
	public void addFilm(String id) {
		Film s = getFilm(id);
		if(s!=null) {
			films.add(s);
		}
	}
	
	public void deleteFilm(String id) {
		Film s = getFilm(id);
		if (s!=null)
			films.remove(s);
	}
}
