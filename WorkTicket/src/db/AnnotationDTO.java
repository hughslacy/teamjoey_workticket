/**
 * 
 */
package db;

/**
 * Annotation class - Creates an annotation object with an id, 
 * ticket ID Author name, and annotation text
 * @author TeamJoey
 *
 */

/** Initializing all the basics of an annotation*/
public class AnnotationDTO {
	private int annotationId;
	private int ticketId;
	private String authorName;
	private String text;
	
	/**
	 * Creates a default annotation object
	 * and set the parameters to the defaults
	 */
	public AnnotationDTO() {
		setAnnotationId(0);
		setTicketId(0);
		setAuthorName("");
		setText("");
	}
	
	/**
	 * Create an annotation object
	 * @param annotationId
	 */
	public AnnotationDTO(int annotationId, int ticketId, String authorName, String text) {
		setAnnotationId(annotationId);
		setTicketId(ticketId);
		setAuthorName(authorName);
		setText(text);
	}
	
	/**
	 * Retrieves the annotation ID
	 * @return the annotationId
	 */
	public int getAnnotationId() {
		return annotationId;
	}
	/**
	 * Sets the annotation ID
	 * @param ticketId the ticketId to set
	 */
	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}

	/**
	 * Retrieves the Ticket ID
	 * @return the ticketId
	 */
	public int getTicketId() {
		return ticketId;
	}

	/**
	 * Sets the ticketID of the annotation 
	 * to the ticket it is associated with
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * Retrieves the name of the user that is 
	 * creating the annotation
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Sets the author name of the annotation object to the
	 * provided author name
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * Retrieves the current text entered
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text field to the text provided
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
}
