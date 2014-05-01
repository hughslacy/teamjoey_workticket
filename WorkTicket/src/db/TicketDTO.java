/**
 * 
 */
package db;

import java.util.GregorianCalendar;

/**
 * @author TeamJoey
 *
 */
public class TicketDTO {
	private int ticketId;
	private GregorianCalendar datePosted;
	private String title;
	private String description;
	
	/**
	 * 
	 */
	public TicketDTO() {
		setTicketId(0);
		setDatePosted(new GregorianCalendar());
		setTitle("");
		setDescription("");
	}
	
	/**
	 * 
	 * @param ticketId
	 */
	public TicketDTO(int ticketId) {
		setTicketId(ticketId);
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
	 * @return the datePosted
	 */
	public GregorianCalendar getDatePosted() {
		return datePosted;
	}
	/**
	 * @param datePosted the datePosted to set
	 */
	public void setDatePosted(GregorianCalendar datePosted) {
		this.datePosted = datePosted;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
