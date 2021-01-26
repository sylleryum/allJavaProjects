import java.util.Random;
import java.util.UUID;

public class Account {

	String firstName;
	String lastName;
	String department;	
	String alternativeEmail;
	String password;
	String email;
	int mailboxCapacity;
	
	//sem password
	public Account(String firstName, String lastName, String department, String alternativeEmail, int mailboxCapacity) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.alternativeEmail = alternativeEmail;
		this.mailboxCapacity = mailboxCapacity;
		
		this.email = firstName+"."+lastName+"@"+department+".itcompany.com";
		this.password = getSaltString();
		
	}
	
	//sem password e departamento
	public Account(String firstName, String lastName, String alternativeEmail, int mailboxCapacity) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.alternativeEmail = alternativeEmail;
		this.password = getSaltString();
		this.email = firstName+"."+lastName+"@generalservices.itcompany.com";
		this.mailboxCapacity = mailboxCapacity;		
		
	}

	public String getDepartment() {
		return department;
	}
	
	public String getPassword() {
		return password;
	}

	public String getAlternativeEmail() {
		return alternativeEmail;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}

	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	
}
