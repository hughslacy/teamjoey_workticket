/**
 * 
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author TeamJoey
 *
 */
public class WorkTicketDAO {

	/**
	 * 
	 */
	protected PreparedStatement selectAnnotationStatement;
	protected PreparedStatement updateAnnotationStatement;
	protected PreparedStatement insertAnnotationStatement;
	protected PreparedStatement selectTicketStatement;
	protected PreparedStatement updateTicketStatement;
	protected PreparedStatement insertTicketStatement;
	protected PreparedStatement selectUserStatement;
	protected PreparedStatement updateUserStatement;
	protected PreparedStatement insertUserStatement;
	protected PreparedStatement selectTicketAnnotationsStatement;
	
	/**
	 * 
	 */
	public WorkTicketDAO() {
		
		try {

			// AMAZON RDS configuration
			//String jdbcUrl = "jdbc:mysql://mist7510workticket.cxja2uv5sze4.us-east-1.rds.amazonaws.com:3306/workticket";
			//String username = "awsuser";
			//String password = "wax&sh1ne";
			
			// LOCALHOST configuration
			String jdbcUrl = "jdbc:mysql://localhost:3306/workticket";
			String username = "root";
			String password = "wax&sh1ne";

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			
			selectAnnotationStatement = conn.prepareStatement("SELECT annotationId, ticketId, authorName, text FROM annotation WHERE annotationId = ?");
			updateAnnotationStatement = conn.prepareStatement("UPDATE annotation SET ticketId = ?, authorName = ?, text ? WHERE annotationId = ?");
			insertAnnotationStatement = conn.prepareStatement("INSERT INTO annotation (ticketId, authorName, text) VALUES(?, ?, ?)");
			
			selectTicketStatement = conn.prepareStatement("SELECT ticketId, datePosted, title, description FROM ticket WHERE ticketId = ?");
			updateTicketStatement = conn.prepareStatement("UPDATE ticket SET datePosted = ?, title = ?, description = ? WHERE ticketId = ?");
			insertTicketStatement = conn.prepareStatement("INSERT INTO ticket (datePosted, title, description) VALUES(?, ?, ?)");
			
			selectTicketAnnotationsStatement = conn.prepareStatement("SELECT annotationId, ticketId, authorName, text FROM annotation WHERE ticketId = ?");
			
			selectUserStatement = conn.prepareStatement("SELECT username, passHash, email, name FROM user WHERE username = ?");
			updateUserStatement = conn.prepareStatement("UPDATE user SET username = ?, passHash = ?, email = ?, name = ? WHERE username = ?");
			insertUserStatement = conn.prepareStatement("INSERT INTO user (username, passHash, email, name) VALUES(?, ?, ?, ?)");
			
			// SQL to query the database.
		} catch (Exception e) {
			//print out error for debugging.
			System.out.println(e.getClass().getName() + " opening connection: " + e.getMessage());

		}
	}
	
	/**
	 * 
	 * @param annotationId
	 * @return
	 */
	public AnnotationDTO loadAnnotation(int annotationId) {
		try{		
			selectAnnotationStatement.setInt(1, annotationId);
			ResultSet rs = selectAnnotationStatement.executeQuery();
			while (rs.next()) {
				return new AnnotationDTO(
						rs.getInt(1), // annotationId
						rs.getInt(2), // ticketId
						rs.getString(3), // authorName
						rs.getString(4)); // text
			}
		}
		catch (SQLException e) {
			System.out.println("Exception retrieving annotation: " + e.getMessage());
		}
		return new AnnotationDTO();
	}
	
	/**
	 * 
	 * @param ticketId
	 * @return
	 */
	public ArrayList<AnnotationDTO> listTicketAnnotations(int ticketId){
		try{		
			selectTicketAnnotationsStatement.setInt(1, ticketId);
			ResultSet rs = selectTicketAnnotationsStatement.executeQuery();
			ArrayList<AnnotationDTO> annotations = new ArrayList<AnnotationDTO>();
			while (rs.next()) {
				annotations.add(new AnnotationDTO(
									rs.getInt(1), // annotationId
									rs.getInt(2), // ticketId
									rs.getString(3), // authorName
									rs.getString(4))); // text
			}
			return annotations;
		}
		catch (SQLException e) {
			System.out.println("Exception retrieving annotation: " + e.getMessage());
		}
		return new ArrayList<AnnotationDTO>();
	}
	
	/**
	 * 
	 * @param annotation
	 * @return
	 */
	public int saveAnnotation(AnnotationDTO annotation) {
		try{
			if (annotation.getAnnotationId() > 0) {
				updateAnnotationStatement.setInt(1, annotation.getTicketId());
				updateAnnotationStatement.setString(2, annotation.getAuthorName());
				updateAnnotationStatement.setString(3, annotation.getText());
				updateAnnotationStatement.setInt(4, annotation.getAnnotationId());
				updateAnnotationStatement.executeUpdate();
				return annotation.getAnnotationId();
			}
			else {
				insertAnnotationStatement.setString(1, annotation.getAuthorName());
				insertAnnotationStatement.setString(2, annotation.getText());
				insertAnnotationStatement.setInt(3, annotation.getAnnotationId());
				insertAnnotationStatement.executeUpdate();
				ResultSet keys = insertAnnotationStatement.getGeneratedKeys();
				keys.next();
				return keys.getInt(1);
			}
		}
		catch (SQLException e) {
			System.out.println("Exception saving annotation: " + e.getMessage());
		}
		return 0;
	}

	/**
	 * 
	 * @param ticketId
	 * @return
	 */
	public TicketDTO loadTicket(int ticketId) {
		try{		
			selectTicketStatement.setInt(1, ticketId);
			ResultSet rs = selectTicketStatement.executeQuery();
			while (rs.next()) {

				return new TicketDTO(
						rs.getInt(1), // ticketId
						rs.getDate(2), // datePosted
						rs.getString(3), // title
						rs.getString(4)); // description
			}
		}
		catch (SQLException e) {
			System.out.println("Exception retrieving ticket: " + e.getMessage());
		}
		return new TicketDTO();
	}
	
	/**
	 * 
	 * @param ticket
	 * @return
	 */
	public int saveTicket(TicketDTO ticket) {
		try{
			if (ticket.getTicketId() > 0) {
				
				updateTicketStatement.setDate(1, new java.sql.Date(ticket.getDatePosted().getTimeInMillis()));
				updateTicketStatement.setString(2, ticket.getTitle());
				updateTicketStatement.setString(3, ticket.getDescription());
				updateTicketStatement.setInt(4, ticket.getTicketId());
				updateTicketStatement.executeUpdate();
				return ticket.getTicketId();
			}
			else {
				insertTicketStatement.setDate(1, new java.sql.Date(ticket.getDatePosted().getTimeInMillis()));
				insertTicketStatement.setString(2, ticket.getTitle());
				insertTicketStatement.setString(3, ticket.getDescription());
				insertTicketStatement.executeUpdate();
				ResultSet keys = insertTicketStatement.getGeneratedKeys();
				keys.next();
				return keys.getInt(1);
			}
		}
		catch (SQLException e) {
			System.out.println("Exception saving ticket: " + e.getMessage());
		}
		return 0;
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public UserDTO loadUser(String username) {
		try{		
			selectUserStatement.setString(1, username);
			ResultSet rs = selectUserStatement.executeQuery();
			while (rs.next()) {
				return new UserDTO(
						rs.getString(1), // userName
						rs.getBytes(2), // passhash
						rs.getString(3), // email
						rs.getString(4)); // name
			}
		}
		catch (SQLException e) {
			System.out.println("Exception retrieving user: " + e.getMessage());
		}
		return new UserDTO();
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public String saveUser(UserDTO user) {
		try{
			if (user.getUsername() == "") {
				//
				updateUserStatement.setString(1, user.getUsername());
				updateUserStatement.setBytes(2, user.getPasshash());
				updateUserStatement.setString(3, user.getEmail());
				updateUserStatement.setString(4, user.getName());
				updateUserStatement.executeUpdate();
				return user.getUsername();
			}
			else {
				//
				insertUserStatement.setString(1, user.getUsername());
				insertUserStatement.setBytes(2, user.getPasshash());
				insertUserStatement.setString(3, user.getEmail());
				insertUserStatement.setString(4, user.getName());
				insertUserStatement.executeUpdate();
				return user.getUsername();
			}
		}
		catch (SQLException e) {
			System.out.println("Exception saving user: " + e.getMessage());
		}
		return "";
	}

	
}
