/**
 * 
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author craigmoliver
 *
 */
public class WorkTicketDAO {

	
	protected PreparedStatement selectAnnotation;
	protected PreparedStatement updateAnnotation;
	protected PreparedStatement insertAnnotation;
	
	protected PreparedStatement selectTicket;
	protected PreparedStatement updateTicket;
	protected PreparedStatement insertTicket;
	
	public WorkTicketDAO() {
		
		try {
			String jdbcUrl = "jdbc:mysql://locahost:3306/workTicket";
			String username = "awsuser";
			String password = "wax&sh1ne";

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			
			selectAnnotation = conn.prepareStatement("SELECT annotationId, ticketId, authorName, text FROM annotation WHERE annotationId = ?");
			updateAnnotation = conn.prepareStatement("UPDATE annotation SET ticketId = ?, authorName = ?, text ? WHERE annotationId = ?");
			insertAnnotation = conn.prepareStatement("INSERT INTO annotation (ticketId, authorName, text) VALUES(?, ?, ?)");
			
			selectTicket = conn.prepareStatement("SELECT ticketId, datePosted, title, description FROM ticket WHERE ticketId = ?");
			updateTicket = conn.prepareStatement("UPDATE ticket SET datePosted = ?, title = ?, description = ? WHERE ticketId = ?");
			insertTicket = conn.prepareStatement("INSERT INTO ticket (datePosted, title, description) VALUES(?, ?, ?)");
			
			
			// SQL to query the database.
		} catch (Exception e) {
			//print out error for debugging.
			System.out.println(e.getClass().getName() + " opening connection: " + e.getMessage());

		}
	}
	
}
