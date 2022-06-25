package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Library;


public class LibraryResource {
	
	private String uri = "https://proyecto-integracion-l3-g6.appspot.com/api/libraries";
	
	public Collection<Library> getAll() {
		
		ClientResource cr = null;
		Library [] lists = null;
		try {
			cr = new ClientResource(uri);
			System.out.println("aedawd");
			System.out.println(cr);
			lists = cr.get(Library[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of libraries: " + cr.getResponse().getStatus());
		}
		return Arrays.asList(lists);
	}
	
	public Library getLibrary(String libraryId) {
		
		ClientResource cr = null;
		Library list = null;
		try {
			cr = new ClientResource(uri + "/" + libraryId);
			list = cr.get(Library.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the library: " + cr.getResponse().getStatus());
		}
		
		return list;
	}
	
	public Library addLibrary(Library pl) {
		
		ClientResource cr = null;
		Library resultLibrary = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultLibrary = cr.post(pl,Library.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the library: " + cr.getResponse().getStatus());
		}
		
		return resultLibrary;
	}
	
	public boolean updateLibrary(Library pl) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(pl);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the library: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean deleteLibrary(String LibraryId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + LibraryId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the library: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean addFilm(String libraryId, String filmId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + libraryId + "/films/" + filmId);
			cr.setEntityBuffering(true);
			cr.post(" ");
		} catch(ResourceException re) {
			System.err.println("Error when adding the film with id=" +filmId + " to the library with id=" + libraryId);
			success = false;
		}
		return success;
	}
	
	public boolean removeFilm(String libraryId, String filmId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + libraryId + "/films/" + filmId);
			cr.setEntityBuffering(true);
			cr.delete();
		} catch(ResourceException re) {
			System.err.println("Error when deleting the film with id=" + filmId + " from the library with id=" + libraryId);
			success = false;
		}
		return success;
	}
	
	public boolean addBook(String libraryId, String bookId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + libraryId + "/books/" + bookId);
			cr.setEntityBuffering(true);
			cr.post(" ");
		} catch(ResourceException re) {
			System.err.println("Error when adding the book with id=" + bookId + " to the library with id=" + libraryId);
			success = false;
		}
		return success;
		
	}
	
	public boolean removeBook(String libraryId, String bookId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + libraryId + "/books/" + bookId);
			cr.setEntityBuffering(true);
			cr.delete();
		} catch(ResourceException re) {
			System.err.println("Error when deleting the film with id=" + bookId + " from the library with id=" + libraryId);
			success = false;
		}
		return success;
	}
}
