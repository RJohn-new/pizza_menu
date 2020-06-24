import javafx.application.Application;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class for the program
 */
public class Main {

    static Account user;
    static Order order;

    /**
     *  Main method launches the GUI
     */
    public static void main(String[] args) {
        Application.launch(Gui.class, args);
    }

    /**
     *  Establish connection to database / file
     *  @param phone Phone number for log in
     *  @param password Password for the user
     *  @throws InvalidUserException exception if entered information is bad
     */
    public static void login(String phone, String password) throws InvalidUserException {
        String firstName;
        String lastName;
        String email;
        String number;
        String pass;
        try {
            Scanner scan = new Scanner(Main.class.getResourceAsStream("/accounts/"+phone+".txt"));
            firstName = scan.next();
            lastName = scan.next();
            email = scan.next();
            number = scan.next();
            pass = scan.next();
            scan.close();
        } catch (Exception e) {
            throw new InvalidUserException("No Account with that Phone Number");

        }

        if (phone.equals(number) && password.equals(pass))
            user = new Account(number, firstName, lastName, email, pass);
        else
            throw new InvalidUserException("Bad password");
        order = new Order(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    }

    /**
     * Creates a new file/database entry for a new customer
     * @param firstName user first name
     * @param lastName user last name
     * @param email user email address
     * @param phone user phone number
     * @param password user password
     * @param confirm re-enter password
     * @throws InvalidUserException exception if the entered information is malformed
     */
    public static void signUp(String firstName, String lastName, String email,
                              String phone, String password, String confirm) throws InvalidUserException {
        if (!password.equals(confirm)) {
            throw new InvalidUserException("Passwords must match");
        }
        if (phone.length() != 10)
            throw new InvalidUserException("Please check your entered phone number");

        File newUser;
        try {
            newUser = new File(Main.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI().getPath() + "\\accounts\\"+phone+".txt");
        } catch (Exception e) {
            throw new InvalidUserException("Problem with file resource");
        }

        if (newUser.exists())
            throw new InvalidUserException("Account with that phone number already exists.");

        try {
            FileWriter f1 = new FileWriter(newUser);
            BufferedWriter output = new BufferedWriter(f1);
            output.write(firstName + "\n" + lastName + "\n" + email + "\n" + phone + "\n" + password);
            output.flush();
            output.close();
        } catch (IOException e) {
            throw new InvalidUserException("There was an issue saving your information");
        }
        login(phone, password);
    }

    /**
     * Terminate connection to database / file
     */
    public static void signOut() {
        user = null;
        order = null;
    }

    /**
     * @param newPizza Pizza to be added to the order
     */
    public static void orderPizza(Pizza newPizza) {
        order.addPizza(newPizza);
    }

    /**
     * @param newDrink Drink to be added to the order
     */
    public static void orderDrink(Drink newDrink) {
        order.addDrink(newDrink);
    }

    /**
     * @param newSide Side to be added to the order
     */
    public static void orderSide(Side newSide) {
        order.addSide(newSide);
    }

    /**
     * Adds order to order history
     */
    public static void submit() {

    }
}

/**
 * A custom exception for login/sign-up issues
 */
class InvalidUserException extends Exception {
    InvalidUserException(String message){
        super(message);
    }
}
