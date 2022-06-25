package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

 import aiss.model.Film;

public class FilmResourceTest {

	static Film Film1, Film2, Film3;
	static FilmResource sr = new FilmResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		Film1 = sr.addFilm(new Film("Star Wars: Episodio I - La amenaza fantasma", "George Lucas" , "19/05/1999", "Ciencia Ficción", true, 136));
		Film2 = sr.addFilm(new Film("Mulan", "Barry Cook" , 	"05/06/1998", "Familiar", false, 88));
		
	}
	@AfterClass
	public static void tearDown() throws Exception {
		sr.deleteFilm(Film1.getId());
		sr.deleteFilm(Film2.getId());

	}

	@Test
	public void testGetAll() {
		Collection<Film> films = sr.getAll(); 
		
		assertNotNull("The collection of films is null", films);
		
		// Show result
		System.out.println("Listing all films:");
		int i=1;
		for (Film sr : films) { 
			System.out.println("Title " + i++ + " : " + sr.getTitle() + " (ID=" + sr.getId() + ")");
		}
		
	}

	@Test
	public void testGetFilm() {
		Film f = sr.getFilm(Film1.getId());
		
		assertEquals("The id of the films do not match", Film1.getId(), f.getId());
		assertEquals("The name of the films do not match", Film1.getTitle(), f.getTitle());
		
		// Show result
		System.out.println("Film id: " +  f.getId());
		System.out.println("Film title: " +  f.getTitle());

	}

	@Test
	public void testAddFilm() {
		String title = "Cuidadano kane";
		String Director = "Orson Huelles";
		
		
		Film3 = sr.addFilm(new Film(title, Director, "11/02/1946", "Drama", true, 119));
		
		assertNotNull("Error when adding the film", Film3);
		assertEquals("The playlist's name has not been setted correctly", title, Film3.getTitle());
		assertEquals("The playlist's description has not been setted correctly", Director, Film3.getDirector());
	}

	@Test
	public void testUpdateFilm() {
		String FilmTitle = "Updated title name";

		// Update Title
		Film1.setTitle(FilmTitle);

		boolean success = sr.updateFilm(Film1);
		
		assertTrue("Error when updating the playlist", success);
		
		Film f  = sr.getFilm(Film1.getId());
		assertEquals("The library's name has not been updated correctly", FilmTitle, f.getTitle());

	}

	@Test
	public void testDeleteFilm() {
		boolean success = sr.deleteFilm(Film2.getId());
		assertTrue("Error when deleting the library", success);
		
		Film f = sr.getFilm(Film2.getId());
		assertNull("The Library has not been deleted correctly", f);
	}

}
