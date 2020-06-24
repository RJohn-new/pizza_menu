/**
 * Class for the customer's account
 */
public class Account {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;

    /**
     * Constructor for an account
     * @param phoneNumber user phone number
     * @param firstName user first name
     * @param lastName user last name
     * @param emailAddress user email address
     * @param password user password
     */
    public Account(String phoneNumber, String firstName, String lastName, String emailAddress,
                   String password) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    /**
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

}
