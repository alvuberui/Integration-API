package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Film;

public class FilmResource {
private String uri = "https://proyecto-integracion-l3-g6.appspot.com/api/films";
	
	public Collection<Film> getAll(){
		
		ClientResource cr = null;
		Film [] lists = null;
		try {
			cr = new ClientResource(uri);
			lists = cr.get(Film[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of films: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(lists);
	}
	
	public Film getFilm(String filmId) {
		
		ClientResource cr = null;
		Film list = null;
		try {
			cr = new ClientResource(uri + "/" + filmId);
			list = cr.get(Film.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the films: " + cr.getResponse().getStatus());
		}
		
		return list;
	}
	
	public Film addFilm(Film pl) {
		
		ClientResource cr = null;
		Film resultFilm = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultFilm = cr.post(pl,Film.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the films: " + cr.getResponse().getStatus());
		}
		
		return resultFilm;
	}
	
	public boolean updateFilm(Film pl) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(pl);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the films: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean deleteFilm(String FilmId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + FilmId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the films: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
}
