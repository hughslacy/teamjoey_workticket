package db;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test Annotation class - Tests the creation of an annotation object with an id, 
 * ticket ID Author name, and annotation text
 * @author TeamJoey
 *
 */

public class AnnotationDTOTest {

	/** 
	 * Test to see if all parts of the Annotation constructor are working
	 */
	@Test
	public void testAnnotationDTO() {
		/** Test defaults */
		AnnotationDTO instance1 = new AnnotationDTO();
		assertEquals("Annotation ID",0,instance1.getAnnotationId());
		assertEquals("Annotation's Ticket ID",0,instance1.getTicketId());
		assertEquals("Annotation Author Name","",instance1.getAuthorName());
		assertEquals("Annotation's Text","",instance1.getText());
		/** Test being set */
		AnnotationDTO instance2 = new AnnotationDTO(143, 33, "Bill Williams", "Lord help us, we have a Macbook Air on fire");
		assertEquals("Annotation ID",143,instance2.getAnnotationId());
		assertEquals("Annotation's Ticket ID",33,instance2.getTicketId());
		assertEquals("Annotation Author Name","Bill Williams",instance2.getAuthorName());
		assertEquals("Annotation's Text","Lord help us, we have a Macbook Air on fire",instance2.getText());
	}

	@Test
	public void testAnnotationDTOIntIntStringString() {
		
	}

	@Test
	public void testGetAnnotationId() {
		
	}

	@Test
	public void testSetAnnotationId() {
		
	}

	@Test
	public void testGetTicketId() {
		
	}

	@Test
	public void testSetTicketId() {
		
	}

	@Test
	public void testGetAuthorName() {
		
	}

	@Test
	public void testSetAuthorName() {
		
	}

	@Test
	public void testGetText() {
		
	}

	@Test
	public void testSetText() {
		
	}

}
