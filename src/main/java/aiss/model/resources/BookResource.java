package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Book;

public class BookResource {
private String uri = "https://proyecto-integracion-l3-g6.appspot.com/api/books";
	
	public Collection<Book> getAll(){
		
		ClientResource cr = null;
		Book [] lists = null;
		try {
			cr = new ClientResource(uri);
			lists = cr.get(Book[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of books: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(lists);
	}
	
	public Book getBook(String bookId) {
		
		ClientResource cr = null;
		Book list = null;
		try {
			cr = new ClientResource(uri + "/" + bookId);
			list = cr.get(Book.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the books: " + cr.getResponse().getStatus());
		}
		
		return list;
	}
	
	public Book addBook(Book pl) {
		
		ClientResource cr = null;
		Book resultBook = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultBook = cr.post(pl,Book.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the books: " + cr.getResponse().getStatus());
		}
		
		return resultBook;
	}
	
	public boolean updateBook(Book pl) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(pl);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the books: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean deleteBook(String BookId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + BookId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the books: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
}