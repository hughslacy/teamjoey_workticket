/**
 * 
 */
package db;

/**
 * @author TeamJoey
 *
 */
public class AnnotationDTO {
	private int annotationId;
	private int ticketId;
	private String authorName;
	private String text;
	
	/**
	 * 
	 */
	public AnnotationDTO() {
		setAnnotationId(0);
		setTicketId(0);
		setAuthorName("");
		setText("");
	}
	
	/**
	 * 
	 * @param annotationId
	 */
	public AnnotationDTO(int annotationId, int ticketId, String authorName, String text) {
		setAnnotationId(annotationId);
		setTicketId(ticketId);
		setAuthorName(authorName);
		setText(text);
	}
	
	/**
	 * @return the annotationId
	 */
	public int getAnnotationId() {
		return annotationId;
	}
	/**
	 * @param ticketId the ticketId to set
	 */
	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}

	/**
	 * @return the ticketId
	 */
	public int getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
}
