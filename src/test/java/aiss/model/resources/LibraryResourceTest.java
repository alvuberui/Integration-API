package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.Book;
import aiss.model.Film;
import aiss.model.Library;

public class LibraryResourceTest {
	
	static Library library, library2, library3, library4;
	static Film film;
	static Book book;
	static LibraryResource plr = new LibraryResource();
	static FilmResource sr = new FilmResource();
	static BookResource fr = new BookResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		library = plr.addLibrary(new Library("Test list 1", "Test nombre", 2, true));
		library2 = plr.addLibrary(new Library("Test list 2","Test nombre2", 3, true));
		library3 = plr.addLibrary(new Library("Test list 3","Test nombre3", 4, true));
		
	
		film = sr.addFilm(new Film("Test title", "Test director", "Test date", "Test genero", true,60));
		if(film!=null)
			plr.addFilm(library.getId(), film.getId());
		
		book = fr.addBook(new Book("La Teoría del todo", "Stephen Hawking" , "2007", "Consultable", true, "Ciencia Ficción"));
		if(book!=null)
			plr.addBook(library.getId(), book.getId());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		plr.deleteLibrary(library.getId());
		plr.deleteLibrary(library2.getId());
		plr.deleteLibrary(library4.getId());
		if(film!=null)
			sr.deleteFilm(film.getId());
	}

	@Test
	public void testGetAll() {
		Collection<Library> libraries = plr.getAll(); 
		
		assertNotNull("The collection of libraries is null", libraries);
		
		// Show result
		System.out.println("Listing all libraries:");
		int i=1;
		for (Library pl : libraries) {
			System.out.println("Library " + i++ + " : " + pl.getName() + " (ID=" + pl.getId() + ")");
		}
		
	}

	@Test
	public void testGetLibrary() {
		Library p = plr.getLibrary(library.getId());
		
		assertEquals("The id of the libraries do not match", library.getId(), p.getId());
		assertEquals("The name of the libraries do not match", library.getName(), p.getName());
		
		// Show result
		System.out.println("Library id: " +  p.getId());
		System.out.println("Library name: " +  p.getName());

	}

	@Test
	public void testAddLibrary() {
		String libraryName = "Add Library test title";
		String libraryLocation = "Add Library test location";
		Integer libraryAvailableComputers = 10;
		Boolean libraryIsOpen = true;
		
		library4 = plr.addLibrary(new Library(libraryName,libraryLocation, libraryAvailableComputers, libraryIsOpen));
		
		assertNotNull("Error when adding the library", library4);
		assertEquals("The library's name has not been setted correctly", libraryName, library4.getName());
		assertEquals("The library's location has not been setted correctly", libraryLocation, library4.getLocation());
		assertEquals("The library's availableComputers has not been setted correctly", libraryAvailableComputers, library4.getAvailableComputers());
		assertEquals("The library's isOpen has not been setted correctly", libraryIsOpen, library4.getIsOpen());
	}

	@Test
	public void testUpdateLibrary() {
		String libraryName = "Updated library name";

		// Update playlist
		library.setName(libraryName);

		boolean success = plr.updateLibrary(library);
		
		assertTrue("Error when updating the library", success);
		
		Library pl  = plr.getLibrary(library.getId());
		assertEquals("The library's name has not been updated correctly", libraryName, pl.getName());

	}

	@Test
	public void testDeleteLibrary() {
		boolean success = plr.deleteLibrary(library2.getId());
		assertTrue("Error when deleting the library", success);
		
		Library pl = plr.getLibrary(library2.getId());
		assertNull("The Library has not been deleted correctly", pl);
	}

	@Test
	public void testAddFilm() {
		if(film!=null) {
			boolean success = plr.addFilm(library3.getId(), film.getId());
			assertTrue("Error when adding the film", success);
		}
	}
	
	@Test
	public void testAddBook() {
		if(book!=null) {
			boolean success = plr.addBook(library3.getId(), book.getId());
			assertTrue("Error when adding the book", success);
		}
	}

	@Test
	public void testRemoveFilm() {
		if(film != null) {
			boolean success = plr.removeFilm(library3.getId(), film.getId());
			assertTrue("Error when deleting the film", success);
		}
	}
	
	@Test
	public void testRemoveBook() {
		if(book != null) {
			boolean success = plr.removeBook(library3.getId(), book.getId());
			assertTrue("Error when deleting the book", success);
		}
	}
}
