/**
 * 
 */
package db;

/**
 * @author TeamJoey
 *
 */
public class UserDTO {
	private String username;
	private	byte[] passhash;
	private String email;
	private String name;
	
	/**
	 * 
	 */
	public UserDTO() {
		setUsername("");
		setPasshash(new byte[0]);
		setEmail("");
		setName("");
	}
	
	/**
	 * 
	 * @return
	 */
	public UserDTO(String username, byte[] passhash, String email, String name) {
		setUsername(username);
		setPasshash(passhash);
		setEmail(email);
		setName(name);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the passhash
	 */
	public byte[] getPasshash() {
		return passhash;
	}

	/**
	 * @param passhash the passhash to set
	 */
	public void setPasshash(byte[] passhash) {
		this.passhash = passhash;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
