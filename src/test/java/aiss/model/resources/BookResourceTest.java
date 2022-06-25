package aiss.model.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.Book;

public class BookResourceTest {
	static Book Book1, Book2, Book3;
	static BookResource sr = new BookResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		Book1 = sr.addBook(new Book("Harry Potter, el cáliz de fuego", "J. K. Rowling" , "2000", "Consultable", true, "Ciencia Ficción"));
		Book2 = sr.addBook(new Book("La Teoría del todo", "Stephen Hawking" , "2007", "Consultable", true, "Ciencia Ficción"));
			
	}
	@AfterClass
	public static void tearDown() throws Exception {
		sr.deleteBook(Book1.getId());
		sr.deleteBook(Book2.getId());

	}

	@Test
	public void testGetAll() {
		Collection<Book> books = sr.getAll(); 
		
		assertNotNull("The collection of books is null", books);
		
		// Show result
		System.out.println("Listing all books:");
		int i=1;
		for (Book sr : books) { 
			System.out.println("Title " + i++ + " : " + sr.getTitle() + " (ID=" + sr.getId() + ")");
		}
		
	}

	@Test
	public void testGetBook() {
		Book f = sr.getBook(Book1.getId());
		
		assertEquals("The id of the books do not match", Book1.getId(), f.getId());
		assertEquals("The name of the books do not match", Book1.getTitle(), f.getTitle());
		
		// Show result
		System.out.println("Book id: " +  f.getId());
		System.out.println("Book title: " +  f.getTitle());

	}

	@Test
	public void testAddBook() {
		String title = "4 3 2 1";
		String author = "Paul Auster";
		
		Book3 = sr.addBook(new Book(title, author , "2017", "Consultable", true, "Ciencia Ficción"));
		
		assertNotNull("Error when adding the book", Book3);
		assertEquals("The book's name has not been setted correctly", title, Book3.getTitle());
		assertEquals("The book's author has not been setted correctly", author, Book3.getAuthor());
	}

	@Test
	public void testUpdateBook() {
		String BookTitle = "Updated title name";

		// Update Title
		Book1.setTitle(BookTitle);

		boolean success = sr.updateBook(Book1);
		
		assertTrue("Error when updating the book", success);
		
		Book f  = sr.getBook(Book1.getId());
		assertEquals("The books's name has not been updated correctly", BookTitle, f.getTitle());

	}

	@Test
	public void testDeleteBook() {
		boolean success = sr.deleteBook(Book2.getId());
		assertTrue("Error when deleting the book", success);
		
		Book f = sr.getBook(Book2.getId());
		assertNull("The book has not been deleted correctly", f);
	}
}