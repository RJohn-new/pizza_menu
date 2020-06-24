import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.regex.Pattern;

/**
 * UI for the program
 */
public class Gui extends Application {

    private Scene home, about, signIn, signUp, pizzaMenu,
            drinkMenu, sideMenu, confirmation, checkOut, receipt;

    /**
     * Override method from the Application class
     * @param primaryStage stage for the window
     */
    @Override
    public void start(Stage primaryStage) {

        int width = 1200, height = 675;

        // home page scene
        CustomPane homeLayout = makeHome(primaryStage);

        home = new Scene(homeLayout, width, height);

        // about page scene
        CustomPane aboutLayout = new CustomPane();
        homeAndAbout(aboutLayout, primaryStage);

        ImageView info = new ImageView(new Image("Images/about.png"));
        info.setFitWidth(1200);
        info.setFitHeight(450);
        AnchorPane.setTopAnchor(info, 50.0);

        aboutLayout.getCenter().getChildren().add(info);
        about = new Scene(aboutLayout, width, height);

        // signIn page scene
        CustomPane signInLayout = makeSignIn(primaryStage);

        signIn = new Scene(signInLayout, width, height);

        // signUp page scene
        CustomPane signUpLayout = makeSignUp(primaryStage);

        signUp = new Scene(signUpLayout, width, height);


        // pizza menu scene
        CustomPane pizzaMenuLayout = makePizzaMenu(primaryStage);

        pizzaMenu = new Scene(pizzaMenuLayout, width, height);


        // drinks menu scene
        CustomPane drinkMenuLayout = makeDrinkMenu(primaryStage);

        drinkMenu = new Scene(drinkMenuLayout, width, height);

        // sides menu scene
        CustomPane sidesMenuLayout = makeSidesMenu(primaryStage);

        sideMenu = new Scene(sidesMenuLayout, width, height);

        primaryStage.setScene(home);
        primaryStage.setTitle("Mom and Pop's Pizza");
        primaryStage.show();

    }

    /**
     * Private method to setup the action events for common template buttons (like Home and About)
     * @param p The pane to be setup up
     * @param primaryStage The stage for the window
     */
    private void homeAndAbout(CustomPane p, Stage primaryStage) {
        p.goHome.setOnAction(e->primaryStage.setScene(home));
        p.goToAbout.setOnAction(e->primaryStage.setScene(about));
        p.goToPizza.setOnAction(e->primaryStage.setScene(pizzaMenu));
        p.goToDrink.setOnAction(e->primaryStage.setScene(drinkMenu));
        p.goToSides.setOnAction(e->primaryStage.setScene(sideMenu));
        p.loggedStatus.setOnAction(e -> {
            if (Main.user == null)
                primaryStage.setScene(signIn);
            else {
                Main.signOut();
                primaryStage.setScene(home);
            }
        });
    }

    /**
     * Private method to create and setup the home page
     * @param primaryStage the stage for the GUI
     * @return A CustomPane for the home screen
     */
    private CustomPane makeHome(Stage primaryStage) {
        CustomPane homeLayout = new CustomPane();
        homeAndAbout(homeLayout, primaryStage);

        Button goToSignUp = new Button("Sign up");
        goToSignUp.setStyle("-fx-background-color: #f09609;");
        Button goToSignIn = new Button("Sign In");
        goToSignIn.setStyle("-fx-background-color: #f09609;");
        goToSignIn.setFont(Font.font("Arial Black", 18));
        goToSignUp.setFont(Font.font("Arial Black", 18));
        ImageView logo = new ImageView(new Image("Images/logo.png"));
        logo.setFitWidth(600);
        logo.setFitHeight(300);

        AnchorPane.setLeftAnchor(goToSignIn, 300.0);
        AnchorPane.setBottomAnchor(goToSignIn, 30.0);

        AnchorPane.setRightAnchor(goToSignUp, 300.0);
        AnchorPane.setBottomAnchor(goToSignUp, 30.0);

        AnchorPane.setBottomAnchor(logo, 50.0);
        AnchorPane.setLeftAnchor(logo, 600 - logo.getFitWidth()/2);

        homeLayout.getCenter().getChildren().addAll(goToSignIn, goToSignUp, logo);

        goToSignIn.setOnAction(e -> primaryStage.setScene(signIn));
        goToSignUp.setOnAction(e -> primaryStage.setScene(signUp));

        return homeLayout;
    }

    /**
     * Private method to build and setup the SignIn page
     * @param primaryStage Stage for the window
     * @return A CustomPane that represents the SignIn page
     */
    private CustomPane makeSignIn(Stage primaryStage) {
        CustomPane signInLayout = new CustomPane();
        homeAndAbout(signInLayout, primaryStage);

        Label title = new Label("    Sign In Page    ");
        title.setFont(Font.font("Arial Black", 18));
        title.setStyle("-fx-background-color: #f09609;");

        TextField numberField = new TextField();
        PasswordField passwordField = new PasswordField();
        Label number = new Label("Phone Number");
        Label password = new Label("Password");
        Button Signin = new Button("Sign In");
        Signin.setFont(Font.font("Arial Black", 18));

        AnchorPane.setTopAnchor(title, 100.0);
        AnchorPane.setLeftAnchor(title, 520.0);

        AnchorPane.setTopAnchor(number, 250.0);
        AnchorPane.setLeftAnchor(number, 525.0);

        AnchorPane.setTopAnchor(numberField,  275.0);
        AnchorPane.setLeftAnchor(numberField, 525.0);

        AnchorPane.setTopAnchor(password, 300.0);
        AnchorPane.setLeftAnchor(password, 525.0);

        AnchorPane.setTopAnchor(passwordField, 325.0);
        AnchorPane.setLeftAnchor(passwordField, 525.0);

        AnchorPane.setTopAnchor(Signin, 425.0);
        AnchorPane.setLeftAnchor(Signin, 600.0);

        Label newUser = new Label("New User?");
        Button goToSignUp = new Button("Sign Up");

        goToSignUp.setFont(Font.font("Arial Black", 18));
        goToSignUp.setStyle("-fx-background-color: #f09609; -fx-border-color: #000000");

        AnchorPane.setTopAnchor(newUser, 250.0);
        AnchorPane.setLeftAnchor(newUser, 815.0);
        AnchorPane.setTopAnchor(goToSignUp, 275.0);
        AnchorPane.setLeftAnchor(goToSignUp, 815.0);

        signInLayout.getCenter().getChildren().addAll(title, number, numberField, password, passwordField, Signin,
                newUser, goToSignUp);

        goToSignUp.setOnAction(e->primaryStage.setScene(signUp));
        Signin.setOnAction(e->{
            for (Node n : signInLayout.getCenter().getChildren()) {
                if (n instanceof Text) {
                    signInLayout.getCenter().getChildren().remove(n);
                    break;
                }
            }
            Text status = new Text();
            try {
                Main.login(numberField.getText(), passwordField.getText());
                passwordField.clear();
                numberField.clear();
                primaryStage.setScene(pizzaMenu);
            } catch (InvalidUserException ex) {
                status = new Text(ex.getMessage());
                status.setStroke(Color.RED);
            } finally {
                AnchorPane.setBottomAnchor(status,120.0);
                signInLayout.getCenter().getChildren().add(status);
            }
        });
        return signInLayout;
    }

    /**
     * Private method to build and setup the SignUp page
     * @param primaryStage the stage for the window
     * @return a CustomPane that represents the SignUp page
     */
    private CustomPane makeSignUp(Stage primaryStage) {
        CustomPane signUpLayout = new CustomPane();
        homeAndAbout(signUpLayout, primaryStage);

        Label title = new Label("    Sign Up Page    ");
        title.setFont(Font.font("Arial Black", 18));
        title.setStyle("-fx-background-color: #f09609;");

        Label firstName = new Label("First Name");
        Label lastName = new Label("Last Name");
        Label emailAddress = new Label("Email Address");
        Label number = new Label("Phone Number");
        Label pass = new Label("Password");
        Label rePass = new Label("Confirm Password");

        TextField firstNameField = new TextField();
        firstNameField.setPrefWidth(75);
        TextField lastNameField = new TextField();
        lastNameField.setPrefWidth(75);
        TextField emailAddressField = new TextField();
        TextField numberField = new TextField();
        PasswordField passField = new PasswordField();
        PasswordField rePassField = new PasswordField();

        Button submit = new Button("Sign Up");
        submit.setFont(Font.font("Arial Black", 18));

        AnchorPane.setLeftAnchor(title, 520.0);
        AnchorPane.setTopAnchor(title, 100.0);

        AnchorPane.setLeftAnchor(firstName, 525.0);
        AnchorPane.setTopAnchor(firstName, 150.0);
        AnchorPane.setLeftAnchor(firstNameField, 525.0);
        AnchorPane.setTopAnchor(firstNameField, 175.0);

        AnchorPane.setLeftAnchor(lastName, 625.0);
        AnchorPane.setTopAnchor(lastName, 150.0);
        AnchorPane.setLeftAnchor(lastNameField, 625.0);
        AnchorPane.setTopAnchor(lastNameField, 175.0);

        AnchorPane.setLeftAnchor(emailAddress, 525.0);
        AnchorPane.setTopAnchor(emailAddress, 200.0);
        AnchorPane.setLeftAnchor(emailAddressField, 525.0);
        AnchorPane.setTopAnchor(emailAddressField, 225.0);

        AnchorPane.setLeftAnchor(number, 525.0);
        AnchorPane.setTopAnchor(number, 250.0);
        AnchorPane.setLeftAnchor(numberField, 525.0);
        AnchorPane.setTopAnchor(numberField, 275.0);

        AnchorPane.setLeftAnchor(pass, 525.0);
        AnchorPane.setTopAnchor(pass, 300.0);
        AnchorPane.setLeftAnchor(passField, 525.0);
        AnchorPane.setTopAnchor(passField, 325.0);

        AnchorPane.setLeftAnchor(rePass, 525.0);
        AnchorPane.setTopAnchor(rePass, 350.0);
        AnchorPane.setLeftAnchor(rePassField, 525.0);
        AnchorPane.setTopAnchor(rePassField, 375.0);

        AnchorPane.setTopAnchor(submit, 425.0);
        AnchorPane.setLeftAnchor(submit, 600.0);


        Label alreadyUser = new Label("Returning User?");
        Button goToSignIn = new Button("Sign In");

        goToSignIn.setFont(Font.font("Arial Black", 18));
        goToSignIn.setStyle("-fx-background-color: #f09609; -fx-border-color: #000000");

        AnchorPane.setTopAnchor(alreadyUser, 250.0);
        AnchorPane.setLeftAnchor(alreadyUser, 815.0);
        AnchorPane.setTopAnchor(goToSignIn, 275.0);
        AnchorPane.setLeftAnchor(goToSignIn, 815.0);

        signUpLayout.getCenter().getChildren().addAll(title, firstName, firstNameField, lastName, lastNameField,
                emailAddress, emailAddressField, number, numberField, pass, passField, rePass, rePassField, submit,
                alreadyUser, goToSignIn);

        goToSignIn.setOnAction(e -> primaryStage.setScene(signIn));

        submit.setOnAction(e->{
            for (Node n : signUpLayout.getCenter().getChildren()) {
                if (n instanceof Text) {
                    signUpLayout.getCenter().getChildren().remove(n);
                    break;
                }
            }
            Text status;
            if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() ||
                    emailAddressField.getText().isEmpty() || numberField.getText().isEmpty() ||
                    passField.getText().isEmpty() || rePassField.getText().isEmpty()) {

                status = new Text("Please enter all fields");
                status.setStroke(Color.RED);

            }
            else {
                try {
                    Main.signUp(firstNameField.getText(), lastNameField.getText(), emailAddressField.getText(),
                            numberField.getText(), passField.getText(), rePassField.getText());
                    status = new Text("Account successfully created for: " +Main.user.getFirstName() + " " +
                            Main.user.getLastName() + ".");
                    primaryStage.setScene(pizzaMenu);

                } catch (InvalidUserException ex) {
                    status = new Text(ex.getMessage());
                    status.setStroke(Color.RED);
                }
            }
            AnchorPane.setBottomAnchor(status, 120.0);
            AnchorPane.setRightAnchor(status, 830.0);
            signUpLayout.getCenter().getChildren().add(status);
        });
        return signUpLayout;
    }

    /**
     * Private method to build and setup the pizza menu page
     * @param primaryStage stage for the window
     * @return a CustomPane representing the first menu page
     */
    private CustomPane makePizzaMenu(Stage primaryStage) {
        CustomPane pizzaLayout = new CustomPane();
        homeAndAbout(pizzaLayout, primaryStage);

        Label pizza = new Label("PIZZA");
        pizza.setFont(Font.font("Calibri", FontWeight.BOLD, 28));
        Line upperborder = new Line(150, 100, 1050, 100);
        Label meatList = new Label("Meats:");
        Line meatBorder = new Line(150, 200, 600, 200);
        Label veggieList = new Label("Veggies:");
        Line veggieBorder = new Line(150, 300, 600, 300);
        Label crustList = new Label("Crust:");
        Line crustBorder = new Line(150, 400, 600, 400);
        Label sizeList = new Label("Size:");
        Line sizeBorder = new Line(150, 500, 600, 500);
        Label desc = new Label("Your pizza:");
        TextArea description = new TextArea();

        CheckBox pep, saus, ham;
        pep = new CheckBox("Pepperoni");
        saus = new CheckBox("Sausage");
        ham = new CheckBox("Ham");
        HBox meatChoice = new HBox(pep, saus, ham);
        meatChoice.setSpacing(5);
        meatChoice.setPadding(new Insets(5, 0, 0, 5));

        CheckBox cheese, grPep, onion, tomato, mushroom, pine;
        cheese = new CheckBox("Cheese");
        grPep = new CheckBox("Green Pepper");
        onion = new CheckBox("Onion");
        tomato = new CheckBox("Tomato");
        mushroom = new CheckBox("Mushroom");
        pine = new CheckBox("Pineapple");
        HBox veggieChoice = new HBox(cheese, grPep, onion, tomato, mushroom, pine);
        veggieChoice.setSpacing(5);
        veggieChoice.setPadding(new Insets(5,0,0,5));

        RadioButton thin, reg, pan;
        thin = new RadioButton("Thin");
        reg = new RadioButton("Regular");
        pan = new RadioButton("Pan");
        ToggleGroup tg1 = new ToggleGroup();
        thin.setToggleGroup(tg1);
        reg.setToggleGroup(tg1);
        pan.setToggleGroup(tg1);
        thin.setSelected(true);
        HBox crustChoice = new HBox(thin, reg, pan);
        crustChoice.setSpacing(5);
        crustChoice.setPadding(new Insets(5,0,0,5));

        RadioButton small, med, lrg, xlrg;
        small = new RadioButton("Small");
        med = new RadioButton("Medium");
        lrg = new RadioButton("Large");
        xlrg = new RadioButton("Extra Large");
        ToggleGroup tg2 = new ToggleGroup();
        small.setToggleGroup(tg2);
        med.setToggleGroup(tg2);
        lrg.setToggleGroup(tg2);
        xlrg.setToggleGroup(tg2);
        small.setSelected(true);
        HBox sizeChoice = new HBox(small, med, lrg, xlrg);
        sizeChoice.setSpacing(5);
        sizeChoice.setPadding(new Insets(5,0,0,5));

        Button addition = new Button("Add to Order");
        Button submit = new Button("View Order");
        addition.setFont(Font.font("Calibri", 20));
        submit.setFont(Font.font("Calibri", 20));
        addition.setStyle("-fx-background-color: #f09609;");
        submit.setStyle("-fx-background-color: #f09609;");

        meatList.setFont(Font.font("Calibri", 18));
        veggieList.setFont(Font.font("Calibri", 18));
        crustList.setFont(Font.font("Calibri", 18));
        sizeList.setFont(Font.font("Calibri", 18));
        desc.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        description.setEditable(false);
        RadioButton thisSize = (RadioButton)tg2.getSelectedToggle();
        RadioButton thisCrust = (RadioButton)tg1.getSelectedToggle();
        description.setText(thisSize.getText() + " " +  thisCrust.getText() + " crust pizza");

        AnchorPane.setTopAnchor(pizza, 50.0);
        AnchorPane.setLeftAnchor(pizza, 200.0);
        AnchorPane.setTopAnchor(meatList, 150.0);
        AnchorPane.setLeftAnchor(meatList, 150.0);
        AnchorPane.setTopAnchor(veggieList, 250.0);
        AnchorPane.setLeftAnchor(veggieList, 150.0);
        AnchorPane.setTopAnchor(crustList, 350.0);
        AnchorPane.setLeftAnchor(crustList, 150.0);
        AnchorPane.setTopAnchor(sizeList, 450.0);
        AnchorPane.setLeftAnchor(sizeList, 150.0);
        AnchorPane.setTopAnchor(desc, 150.0);
        AnchorPane.setLeftAnchor(desc, 660.0);
        AnchorPane.setTopAnchor(description, 200.0);
        AnchorPane.setLeftAnchor(description, 660.0);
        AnchorPane.setTopAnchor(addition, 450.0);
        AnchorPane.setLeftAnchor(addition, 660.0);
        AnchorPane.setTopAnchor(submit, 450.0);
        AnchorPane.setLeftAnchor(submit, 900.0);

        AnchorPane.setTopAnchor(meatChoice, 150.0);
        AnchorPane.setLeftAnchor(meatChoice, 200.0);
        AnchorPane.setTopAnchor(veggieChoice, 250.0);
        AnchorPane.setLeftAnchor(veggieChoice, 210.0);
        AnchorPane.setTopAnchor(crustChoice, 350.0);
        AnchorPane.setLeftAnchor(crustChoice, 200.0);
        AnchorPane.setTopAnchor(sizeChoice, 450.0);
        AnchorPane.setLeftAnchor(sizeChoice, 200.0);

        Label logged = new Label("Welcome ");
        logged.setVisible(false);
        AnchorPane.setLeftAnchor(logged, 10.0);
        AnchorPane.setTopAnchor(logged, 10.0);
        pizzaLayout.setOnMouseMoved(e -> {
            if (!logged.isVisible() && Main.user != null) {
                logged.setText("Welcome " + Main.user.getFirstName() + " " +Main.user.getLastName());
                logged.setVisible(true);
            } else if (Main.user != null && !logged.getText().substring(6, logged.getText().length()).equals(
                    Main.user.getFirstName()+ " " +Main.user.getLastName())) {
                logged.setText("Welcome " + Main.user.getFirstName() + " " +Main.user.getLastName());
            }
        });

        pizzaLayout.getCenter().getChildren().addAll(upperborder, pizza, meatBorder, veggieBorder, crustBorder,
                sizeBorder, meatList, veggieList, crustList, sizeList, desc, description, meatChoice, veggieChoice,
                crustChoice, sizeChoice, addition, submit, logged);

        CheckBox[] toppings = {pep, saus, ham, cheese, grPep, onion, tomato, mushroom, pine};

        addition.setOnAction(e ->{

            if (Main.user == null) {
                Text result = new Text("Please sign in to order a pizza");
                AnchorPane.setTopAnchor(result, 500.0);
                AnchorPane.setLeftAnchor(result, 800.0);
                result.setFont(Font.font("Calibri", 16));
                result.setStroke(Color.RED);
                pizzaLayout.getCenter().getChildren().add(result);
                pizzaLayout.setOnMouseClicked(event -> pizzaLayout.getCenter().getChildren().remove(result));
            } else {

                boolean[] arr = new boolean[9];
                for (int i = 0; i < arr.length; i++) {
                    if (toppings[i].isSelected())
                        arr[i] = true;
                }

                SIZE size;
                CRUST crust;
                if (((RadioButton) tg2.getSelectedToggle()).getText().equals("Small"))
                    size = SIZE.SMALL;
                else if (((RadioButton) tg2.getSelectedToggle()).getText().equals("Medium"))
                    size = SIZE.MEDIUM;
                else if (((RadioButton) tg2.getSelectedToggle()).getText().equals("Large"))
                    size = SIZE.LARGE;
                else
                    size = SIZE.EXTRA_LARGE;

                if (((RadioButton) tg1.getSelectedToggle()).getText().equals("Thin"))
                    crust = CRUST.THIN;
                else if (((RadioButton) tg1.getSelectedToggle()).getText().equals("Regular"))
                    crust = CRUST.REGULAR;
                else
                    crust = CRUST.PAN;

                Main.orderPizza(new Pizza(size, crust, arr));
                small.setSelected(true);
                thin.setSelected(true);
                for (Node n : meatChoice.getChildren()) {
                    ((CheckBox)n).setSelected(false);
                }
                for (Node n : veggieChoice.getChildren()) {
                    ((CheckBox)n).setSelected(false);
                }
                description.setText(small.getText() + " " +  thin.getText() + " crust pizza");

            }
        });

        for (CheckBox c: toppings) {
            c.setOnAction(e -> {
                if (c.isSelected() && !description.getText().contains(c.getText())) {
                    description.setText(c.getText() + " " + description.getText());
                } else {
                    description.setText(description.getText().replace(c.getText()+ " ", ""));
                }
            });
        }

        for (Node n: sizeChoice.getChildren()) {
            RadioButton rb = (RadioButton)n;
            rb.setOnAction(e -> {
                String alter;
                if (description.getText().contains("Small"))
                    alter = description.getText().replace("Small", rb.getText());
                else if (description.getText().contains("Medium"))
                    alter = description.getText().replace("Medium", rb.getText());
                else if (description.getText().contains("Extra Large"))
                    alter = description.getText().replace("Extra Large", rb.getText());
                else
                    alter = description.getText().replace("Large", rb.getText());
                description.setText(alter);
            });
        }

        for (Node n: crustChoice.getChildren()) {
            RadioButton rb = (RadioButton)n;
            rb.setOnAction(e -> {
                String alter;
                if (description.getText().contains("Thin"))
                    alter = description.getText().replace("Thin", rb.getText());
                else if (description.getText().contains("Regular"))
                    alter = description.getText().replace("Regular", rb.getText());
                else
                    alter = description.getText().replace("Pan", rb.getText());
                description.setText(alter);
            });
        }

        submit.setOnAction(e -> {
            if (Main.user == null) {
                Text result = new Text("Please sign in to order a pizza");
                AnchorPane.setTopAnchor(result, 500.0);
                AnchorPane.setLeftAnchor(result, 800.0);
                result.setFont(Font.font("Calibri", 16));
                result.setStroke(Color.RED);
                pizzaLayout.getCenter().getChildren().add(result);
                pizzaLayout.setOnMouseClicked(event -> pizzaLayout.getCenter().getChildren().remove(result));
            } else {
                CustomPane confirmationLayout = makeConfirmation(primaryStage);

                confirmation = new Scene(confirmationLayout, 1200, 675);
                primaryStage.setScene(confirmation);
            }
        });

        return pizzaLayout;
    }

    /**
     * Private method to build and setup the drink menu page
     * @param primaryStage stage for the window
     * @return CustomPane representing the drink menu page
     */
    private CustomPane makeDrinkMenu(Stage primaryStage) {
        CustomPane drinkMenuLayout = new CustomPane();
        homeAndAbout(drinkMenuLayout, primaryStage);

        Label drinks = new Label("DRINKS");
        drinks.setFont(Font.font("Calibri", FontWeight.BOLD, 28));
        Line upperborder = new Line(150, 100, 1050, 100);

        Text result1 = new Text();
        result1.setVisible(false);

        class DrinkBox extends HBox{
            ImageView pic;
            String name;

            private DrinkBox(ImageView pic, String name) {
                this.pic = pic;
                pic.setFitHeight(120);
                pic.setFitWidth(100);
                this.name = name;
                this.getChildren().add(pic);

                RadioButton small, med, lrg;
                small = new RadioButton("$1 Small");
                med = new RadioButton("$1 Medium");
                lrg = new RadioButton("$1 Large");
                ToggleGroup size = new ToggleGroup();
                lrg.setSelected(true);
                small.setToggleGroup(size);
                med.setToggleGroup(size);
                lrg.setToggleGroup(size);

                Button addition = new Button("  ADD  ");
                addition.setFont(Font.font("Calibri",18));
                addition.setStyle("-fx-background-color: #f09609; -fx-text-fill: white;");

                VBox list = new VBox(new Text(name), small, med, lrg, addition);
                list.setSpacing(5);
                this.getChildren().add(list);
                this.setStyle("-fx-border-color: lightgray");

                addition.setOnAction(e -> {
                    if (Main.user == null) {
                        Text result = new Text("Please sign in to order a drink");
                        AnchorPane.setTopAnchor(result, 500.0);
                        AnchorPane.setLeftAnchor(result, 800.0);
                        result.setFont(Font.font("Calibri", 16));
                        result.setStroke(Color.RED);
                        drinkMenuLayout.getCenter().getChildren().add(result);
                        drinkMenuLayout.setOnMouseClicked(event -> drinkMenuLayout.getCenter().getChildren().remove(result));
                    } else {
                        RadioButton rb = (RadioButton) size.getSelectedToggle();
                        String choice = rb.getText().substring(3, rb.getText().length());
                        SIZE drinkSize;
                        if (choice.equals("Small"))
                            drinkSize = SIZE.SMALL;
                        else if (choice.equals("Medium"))
                            drinkSize = SIZE.MEDIUM;
                        else
                            drinkSize = SIZE.LARGE;
                        Drink d = new Drink(name, drinkSize, 1);
                        Main.orderDrink(d);
                        result1.setText(d.toString() + " has been added to order");
                        result1.setVisible(true);
                        drinkMenuLayout.setOnMouseClicked(event -> result1.setVisible(false));
                    }
                });
            }
        }

        DrinkBox drink1 = new DrinkBox(new ImageView(new Image("Images/Pepsi.png")), "Pepsi");
        DrinkBox drink2 = new DrinkBox(new ImageView(new Image("Images/Orange.jpg")), "Orange");
        DrinkBox drink3 = new DrinkBox(new ImageView(new Image("Images/RootBeer.jpg")), "Root Beer");
        DrinkBox drink4 = new DrinkBox(new ImageView(new Image("Images/SierraMist.png")), "Sierra Mist");
        DrinkBox drink5 = new DrinkBox(new ImageView(new Image("Images/DietPepsi.png")), "Diet Pepsi");
        DrinkBox drink6 = new DrinkBox(new ImageView(new Image("Images/DietOrange.jpg")), "Diet Orange");
        DrinkBox drink7 = new DrinkBox(new ImageView(new Image("Images/DietRootBeer.jpg")), "Diet Root Beer");
        DrinkBox drink8 = new DrinkBox(new ImageView(new Image("Images/Lemonade.jpg")), "Lemonade");
        Button view = new Button("View Order");
        view.setFont(Font.font("Calibiri", 20));
        view.setStyle("-fx-background-color: #f09609;");

        AnchorPane.setTopAnchor(drinks, 50.0);
        AnchorPane.setLeftAnchor(drinks, 200.0);

        AnchorPane.setTopAnchor(drink1, 150.0);
        AnchorPane.setLeftAnchor(drink1, 180.0);
        AnchorPane.setTopAnchor(drink2, 150.0);
        AnchorPane.setLeftAnchor(drink2, 390.0);
        AnchorPane.setTopAnchor(drink3, 150.0);
        AnchorPane.setLeftAnchor(drink3, 610.0);
        AnchorPane.setTopAnchor(drink4, 150.0);
        AnchorPane.setLeftAnchor(drink4, 820.0);

        AnchorPane.setTopAnchor(drink5, 300.0);
        AnchorPane.setLeftAnchor(drink5, 180.0);
        AnchorPane.setTopAnchor(drink6, 300.0);
        AnchorPane.setLeftAnchor(drink6, 390.0);
        AnchorPane.setTopAnchor(drink7, 300.0);
        AnchorPane.setLeftAnchor(drink7, 610.0);
        AnchorPane.setTopAnchor(drink8, 300.0);
        AnchorPane.setLeftAnchor(drink8, 820.0);
        AnchorPane.setTopAnchor(view, 450.0);
        AnchorPane.setLeftAnchor(view, 550.0);
        AnchorPane.setTopAnchor(result1, 425.0);
        AnchorPane.setLeftAnchor(result1, 550.0);

        drinkMenuLayout.getCenter().getChildren().addAll(upperborder, drinks, drink1, drink2, drink3, drink4, drink5,
                drink6, drink7, drink8, view, result1);

        view.setOnAction(e-> {
            if (Main.user == null) {
                Text result = new Text("Please sign in to order a drink");
                AnchorPane.setTopAnchor(result, 500.0);
                AnchorPane.setLeftAnchor(result, 800.0);
                result.setFont(Font.font("Calibri", 16));
                result.setStroke(Color.RED);
                drinkMenuLayout.getCenter().getChildren().add(result);
                drinkMenuLayout.setOnMouseClicked(event -> drinkMenuLayout.getCenter().getChildren().remove(result));
            } else {
                CustomPane confirmationLayout = makeConfirmation(primaryStage);

                confirmation = new Scene(confirmationLayout, 1200, 675);
                primaryStage.setScene(confirmation);
            }
        });


        return drinkMenuLayout;
    }

    /**
     * Private method to build and setup the sides menu page
     * @param primaryStage stage for the window
     * @return CustomPane representing the sides menu
     */
    private CustomPane makeSidesMenu(Stage primaryStage) {
        CustomPane sideMenuLayout = new CustomPane();
        homeAndAbout(sideMenuLayout, primaryStage);

        Label sides = new Label("SIDES");
        sides.setFont(Font.font("Calibri", FontWeight.BOLD, 28));
        Line upperBorder = new Line(150, 100, 1050, 100);

        Text result1 = new Text();
        result1.setVisible(false);

        class SideBox extends HBox {
            ImageView pic;
            String name;
            private SideBox(ImageView pic, String name) {
                this.pic = pic;
                this.name = name;
                this.setSpacing(10);

                this.pic = pic;
                pic.setFitHeight(120);
                pic.setFitWidth(100);
                this.name = name;
                Text type = new Text(name);
                type.setFont(Font.font("Calibri", FontWeight.BOLD, 14));

                Text price = new Text();
                if (name.equals("Bread Sticks"))
                    price.setText("$2.00");
                else if (name.contains("Chocolate Chip"))
                    price.setText("$4.00");
                else
                    price.setText("$2.00");
                price.setFont(Font.font("Calibri", 14));
                Button addition = new Button("\tADD\t");
                addition.setFont(Font.font("Calibri", 18));
                addition.setStyle("-fx-background-color: #f09609; -fx-text-fill: white;");
                Text blank = new Text("\n");
                VBox list = new VBox(type, price, blank, addition);
                list.setSpacing(5);
                list.setPadding(new Insets(5, 5, 5, 5));

                this.getChildren().addAll(pic, list);
                this.setStyle("-fx-border-color: lightgray;");

                addition.setOnAction(e -> {
                        if (Main.user == null) {
                            Text result = new Text("Please sign in to order a drink");
                            AnchorPane.setTopAnchor(result, 500.0);
                            AnchorPane.setLeftAnchor(result, 800.0);
                            result.setFont(Font.font("Calibri", 16));
                            result.setStroke(Color.RED);
                            sideMenuLayout.getCenter().getChildren().add(result);
                            sideMenuLayout.setOnMouseClicked(event -> sideMenuLayout.getCenter().getChildren().remove(result));
                        } else {
                            SIDE_TYPE choice;
                            if (name.equals("Bread Sticks"))
                                choice = SIDE_TYPE.BREAD_STICKS;
                            else if (name.equals("Bread Bites"))
                                choice = SIDE_TYPE.BREAD_BITES;
                            else
                                choice = SIDE_TYPE.COOKIE;

                            Side s = new Side(choice, 1);
                            Main.orderSide(s);
                            result1.setText(s.toString() + " has been added to order");
                            result1.setVisible(true);
                            sideMenuLayout.setOnMouseClicked(event -> result1.setVisible(false));
                        }
                });
            }
        }

        SideBox side1 = new SideBox(new ImageView(new Image("Images/BreadSticks.jpg")), "Bread Sticks");
        SideBox side2 = new SideBox(new ImageView(new Image("Images/BreadBites.jpg")), "Bread Bites");
        SideBox side3 = new SideBox(new ImageView(new Image("Images/Cookie.jpg")), "Chocolate Chip\nCookie");

        Button submit = new Button("View Order");
        submit.setFont(Font.font("Calibiri", 20));
        submit.setStyle("-fx-background-color: #f09609;");

        AnchorPane.setTopAnchor(sides, 50.0);
        AnchorPane.setLeftAnchor(sides, 200.0);

        AnchorPane.setTopAnchor(side1, 150.0);
        AnchorPane.setLeftAnchor(side1, 300.0);
        AnchorPane.setTopAnchor(side2, 150.0);
        AnchorPane.setLeftAnchor(side2, 600.0);
        AnchorPane.setTopAnchor(side3, 300.0);
        AnchorPane.setLeftAnchor(side3, 300.0);
        AnchorPane.setTopAnchor(submit, 450.0);
        AnchorPane.setLeftAnchor(submit, 550.0);
        AnchorPane.setTopAnchor(result1, 425.0);
        AnchorPane.setLeftAnchor(result1, 550.0);


        sideMenuLayout.getCenter().getChildren().addAll(upperBorder, sides, side1, side2, side3, submit, result1);

        submit.setOnAction(e -> {
            if (Main.user == null) {
                Text result = new Text("Please sign in to order a side");
                AnchorPane.setTopAnchor(result, 500.0);
                AnchorPane.setLeftAnchor(result, 800.0);
                result.setFont(Font.font("Calibri", 16));
                result.setStroke(Color.RED);
                sideMenuLayout.getCenter().getChildren().add(result);
                sideMenuLayout.setOnMouseClicked(event -> sideMenuLayout.getCenter().getChildren().remove(result));
            } else {
                CustomPane confirmationLayout = makeConfirmation(primaryStage);

                confirmation = new Scene(confirmationLayout, 1200, 675);
                primaryStage.setScene(confirmation);
            }
        });

        return sideMenuLayout;
    }

    /**
     * private method to build and setup the shopping cart review page
     * @param primaryStage stage for the window
     * @return CustomPane representing the cart review
     */
    private CustomPane makeConfirmation(Stage primaryStage) {
        CustomPane confirmationLayout = new CustomPane();
        homeAndAbout(confirmationLayout, primaryStage);

        Label cart = new Label("MY CART");
        cart.setFont(Font.font("Calibri",FontWeight.BOLD, 28));
        Line upperBorder = new Line(150, 100, 1050, 100);

        VBox orderList = new VBox();
        orderList.setSpacing(5);
        Text subPrice = new Text();

        class Listing extends HBox {
            private Section type = new Section();
            private Section description = new Section();
            private Section quantity = new Section();
            private Section price = new Section();
            private Section undo = new Section();
            private Button remove = new Button("X");

            private Listing() {
                Text typeColumn = new Text("Type");
                typeColumn.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
                Text descColumn = new Text("Item Description");
                descColumn.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
                Text quantColumn = new Text("Quantity");
                quantColumn.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
                Text priceColumn = new Text("Price");
                priceColumn.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
                type.getChildren().add(typeColumn);
                description.getChildren().add(descColumn);
                quantity.getChildren().add(quantColumn);
                price.getChildren().add(priceColumn);
                build();
                this.getChildren().remove(undo);
            }
            private Listing(Pizza p) {
                type.getChildren().add(new Text("Pizza"));
                description.getChildren().add(new Text(p.toString()));
                quantity.getChildren().add(new Text("1"));
                price.getChildren().add(new Text("$" +String.format("%.2f", p.calculatePrice())));
                remove.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                remove.setOnAction(event -> {
                    for (int i = 0; i < Main.order.getPizzas().size(); i++)
                        if (Main.order.getPizzas().get(i).toString().equals(p.toString())) {
                            Main.order.removePizza(Main.order.getPizzas().get(i));
                            refresh();
                            break;
                        }
                });
                undo.setPrefWidth(50);
                undo.getChildren().add(remove);
                build();
            }
            private Listing(Drink d) {
                type.getChildren().add(new Text("Drink"));
                description.getChildren().add(new Text(d.toString()));
                quantity.getChildren().add(new Text(String.valueOf(d.getCount())));
                price.getChildren().add(new Text("$"+String.format("%.2f", (double)d.getCount())));
                remove.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                remove.setOnAction(event -> {
                    for (int i = 0; i < Main.order.getDrinks().size(); i++)
                        if (Main.order.getDrinks().get(i).toString().equals(d.toString())) {
                            Main.order.removeDrink(Main.order.getDrinks().get(i));
                            refresh();
                            break;
                        }
                });
                undo.setPrefWidth(50);
                undo.getChildren().add(remove);
                build();
            }
            private Listing(Side s) {
                type.getChildren().add(new Text("Side"));
                description.getChildren().add(new Text(s.toString()));
                quantity.getChildren().add(new Text(String.valueOf(s.getCount())));
                price.getChildren().add(new Text("$"+String.format("%.2f",s.getPrice())));
                remove.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                remove.setOnAction(event -> {
                    for (int i = 0; i < Main.order.getSides().size(); i++)
                        if (Main.order.getSides().get(i).toString().equals(s.toString())) {
                            Main.order.removeSide(Main.order.getSides().get(i));
                            refresh();
                            break;
                        }
                });
                undo.getChildren().add(remove);
                undo.setPrefWidth(50);
                build();
            }

            private void refresh() {
                Text tx = (Text)this.type.getChildren().get(0);
                Text desc = (Text)this.description.getChildren().get(0);
                Text quant = (Text)this.quantity.getChildren().get(0);
                Text pr = (Text)this.price.getChildren().get(0);
                boolean goodValue = false;
                if (tx.getText().equals("Pizza")) {
                    for (Pizza p: Main.order.getPizzas()) {
                        if (p.toString().equals(desc.getText()))
                            goodValue = true;
                    }
                    if (!goodValue)
                        orderList.getChildren().remove(this);
                } else if (tx.getText().equals("Drink")) {
                    for (Drink d: Main.order.getDrinks()) {
                        if (desc.getText().contains(d.toString())) {
                            goodValue = true;
                            quant.setText(String.valueOf(d.getCount()));
                            pr.setText(String.format("$%.2f",d.price*d.getCount()));
                        }
                    }
                    if (!goodValue)
                        orderList.getChildren().remove(this);
                } else {
                    for (Side s: Main.order.getSides()) {
                        if (desc.getText().contains(s.toString())) {
                            goodValue = true;
                            quant.setText(String.valueOf(s.getCount()));
                            pr.setText(String.format("$%.2f",s.getPrice()));
                        }
                    }
                    if (!goodValue)
                        orderList.getChildren().remove(this);

                }
                subPrice.setText("$" +String.format("%.2f", Main.order.getSubTotal()));
            }
            private void build() {
                this.getChildren().addAll(type, description, quantity, price, undo);
            }
            class Section extends VBox{
                private Section() {
                    this.setSpacing(5);
                    this.setPadding(new Insets(5, 5, 5, 5));
                    this.setStyle("-fx-border-color: lightgray;");
                    this.setAlignment(Pos.CENTER_LEFT);
                    this.setPrefWidth(250);
                    for (Node n : this.getChildren()) {
                        ((Text) n).setFont(Font.font("Calibri", 12));
                        ((Text) n).setWrappingWidth(200);
                    }
                }
            }
        }

        orderList.getChildren().add(new Listing());

        if (!Main.order.getPizzas().isEmpty())
            for(Pizza p : Main.order.getPizzas())
                orderList.getChildren().add(new Listing(p));
        if (!Main.order.getSides().isEmpty())
            for(Side s : Main.order.getSides())
                orderList.getChildren().add(new Listing(s));
        if (!Main.order.getDrinks().isEmpty())
            for(Drink d : Main.order.getDrinks())
                orderList.getChildren().add(new Listing(d));

        Label subT = new Label("SubTotal:\t");
        subPrice.setText("$" +String.format("%.2f", Main.order.getSubTotal()));
        HBox pricing = new HBox(subPrice);
        pricing.setStyle("-fx-border-color: lightgray;");
        pricing.setPrefWidth(250);
        pricing.setPadding(new Insets(5, 5, 5, 5));
        subPrice.setFont(Font.font("Calibri", 12));
        subT.setFont(Font.font("Calibri", 12));

        Button backToShop = new Button("Continue Shopping");
        Button toCheckout = new Button("  Checkout  ");
        backToShop.setStyle("-fx-background-color: #f09609; -fx-text-fill: white;");
        backToShop.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
        toCheckout.setStyle("-fx-background-color: #f09609; -fx-text-fill: white;");
        toCheckout.setFont(Font.font("Calibri", FontWeight.BOLD, 16));

        ScrollPane sp = new ScrollPane();
        sp.setContent(orderList);
        sp.setVmax(400);
        sp.setPrefHeight(300);

        AnchorPane.setTopAnchor(cart, 50.0);
        AnchorPane.setLeftAnchor(cart, 175.0);
        AnchorPane.setTopAnchor(sp, 100.0);
        AnchorPane.setLeftAnchor(sp, 100.0);
        AnchorPane.setBottomAnchor(pricing, 50.0);
        AnchorPane.setLeftAnchor(pricing, 850.0);
        AnchorPane.setBottomAnchor(subT, 55.0);
        AnchorPane.setRightAnchor(subT, 350.0);

        AnchorPane.setBottomAnchor(toCheckout, 0.0);
        AnchorPane.setRightAnchor(toCheckout, 100.0);
        AnchorPane.setBottomAnchor(backToShop, 0.0);
        AnchorPane.setLeftAnchor(backToShop, 100.0);

        confirmationLayout.getCenter().getChildren().addAll(cart, upperBorder, sp, pricing, subT, toCheckout,
                backToShop);

        backToShop.setOnAction(e -> primaryStage.setScene(pizzaMenu));
        toCheckout.setOnAction(e -> {
            CustomPane checkoutLayout = makeCheckout(primaryStage);

            checkOut = new Scene(checkoutLayout, 1200, 675);
            primaryStage.setScene(checkOut);
        });

        return confirmationLayout;
    }

    /**
     * Private method to build and setup the checkout page
     * @param primaryStage stage for the window
     * @return CustomPane representing the checkout page
     */
    private CustomPane makeCheckout(Stage primaryStage) {
        CustomPane checkLayout = new CustomPane();
        homeAndAbout(checkLayout, primaryStage);

        Label checkout = new Label("CHECKOUT");
        checkout.setFont(Font.font("Calibri",FontWeight.BOLD, 28));
        Line upperBorder = new Line(150, 100, 1050, 100);
        Line firstBorder = new Line(400, 125, 400, 500);
        Line secondBorder = new Line(800, 125, 800, 500);
        // Payment Section
        VBox paymentSection = new VBox(), shippingSection = new VBox(), totalSection = new VBox();
        paymentSection.setPrefWidth(350);
        paymentSection.setSpacing(10);

        Text paymentTitle = new Text("Payment Information");
        paymentTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
        Label cardNumber = new Label("Card Number");
        Label cardName = new Label("Name on the card");
        Label expDate = new Label("Expiration Date");
        Label csv = new Label("CSV");
        TextField cardNumberField = new TextField();
        TextField cardNameField = new TextField();
        TextField expDateField = new TextField();
        TextField csvField = new TextField();
        Label orr = new Label("OR");
        CheckBox person = new CheckBox("In Person");

        Text result = new Text();
        result.setStroke(Color.RED);
        result.setVisible(false);

        paymentSection.getChildren().addAll(paymentTitle, cardNumber, cardNumberField, cardName, cardNameField, expDate,
                expDateField, csv, csvField, orr, person, result);
        //Shipping Section
        shippingSection.setPrefWidth(350);
        shippingSection.setSpacing(10);

        Text shippingTitle = new Text("Delivery Information");
        shippingTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
        Label city = new Label("City");
        Label street = new Label("Steet Address");
        TextField cityField = new TextField();
        TextField streetField = new TextField();
        Label or = new Label("OR");
        CheckBox pickup = new CheckBox("Pick up in Store");

        Text result1 = new Text();
        result1.setStroke(Color.RED);
        result1.setVisible(false);


        shippingSection.getChildren().addAll(shippingTitle, city, cityField, street, streetField, or, pickup, result1);
        // Cart Total Section
        totalSection.setPrefWidth(350);
        totalSection.setSpacing(10);

        Text totalTitle = new Text("Cart Total");
        totalTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
        Text subTotPrice = new Text("SUB TOTAL\t\t$" + String.format("%.2f", Main.order.getSubTotal()));
        Text taxPrice = new Text("TAX\t\t\t\t$" + String.format("%.2f", 0.06*Main.order.getSubTotal()));
        Text finalPrice = new Text("FINAL PRICE\t\t$" + String.format("%.2f", Main.order.getFinalPrice()));
        Button submitOrder = new Button("Order Now");

        submitOrder.setFont(Font.font("Calibri", 36));
        submitOrder.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-border-color: black;");

        Text finalResult = new Text();
        finalResult.setStroke(Color.RED);
        finalResult.setVisible(false);

        submitOrder.setOnAction(e -> {

            if (!person.isSelected() && (cardNameField.getText().isEmpty() || cardNumberField.getText().isEmpty() ||
                    expDateField.getText().isEmpty() || csvField.getText().isEmpty())){
                result.setText("Please fill all fields");
                checkLayout.setOnMouseClicked(event -> result.setVisible(false));
            } else if (person.isSelected()){
                result.setText("Payment expected in person");
                result.setStroke(Color.BLACK);
            }
            else if (cardNumberField.getText().length() != 16) {
                result.setText("Card number is the wrong length");
                checkLayout.setOnMouseClicked(event -> result.setVisible(false));
            }else if (csvField.getText().length() != 3) {
                result.setText("CSV is the wrong length");
                checkLayout.setOnMouseClicked(event -> result.setVisible(false));
            } else if (!Pattern.matches("[a-zA-Z ]+",cardNameField.getText())) {
                result.setText("Name should not contain numbers");
                checkLayout.setOnMouseClicked(event -> result.setVisible(false));
            } else {
                result.setText("The prototype is assuming that these are valid");
                result.setStroke(Color.BLACK);
            }
            result.setVisible(true);


            if (!pickup.isSelected() && (cityField.getText().isEmpty() || streetField.getText().isEmpty())) {
                result1.setText("Please fill in all fields");
                checkLayout.setOnMouseClicked(event -> result1.setVisible(false));
            } else if (pickup.isSelected()) {
                result1.setText("Please come to the store to pick it up");
                result1.setStroke(Color.BLACK);
            } else {
                result1.setText("The prototype is assuming these are valid");
                result1.setStroke(Color.BLACK);
            }
            result1.setVisible(true);


            if (!result.getStroke().equals(Color.BLACK)) {
                finalResult.setText("Please fill out the payment section");
                checkLayout.setOnMouseClicked(event -> finalResult.setVisible(false));
            } else if (!result1.getStroke().equals(Color.BLACK)) {
                finalResult.setText("Please fill out the address section");
                checkLayout.setOnMouseClicked(event -> finalResult.setVisible(false));
            } else {
                finalResult.setText("Order submitted successfully");
                finalResult.setStroke(Color.BLACK);
                finalResult.setFont(Font.font("Calibri", 16));
                Button toReceipt = new Button("View Receipt");
                toReceipt.setStyle("-fx-background-color: #f09609; -fx-text-fill: white;");
                String payment1, add1;
                if (!person.isSelected()) {
                    payment1 = "XXXXXXXXXXXX" + cardNumberField.getText().substring(12, 16) + "\n" + cardNameField.getText();
                } else {
                    payment1 = "No card";
                }
                if (!pickup.isSelected()) {
                    add1 = streetField.getText();
                } else {
                    add1 = "Pickup";
                }
                toReceipt.setOnAction(event -> {
                    CustomPane receiptLayout = makeReceipt(primaryStage, payment1, add1);

                    receipt = new Scene(receiptLayout, 1200, 675);
                    primaryStage.setScene(receipt);
                });
                totalSection.getChildren().add(toReceipt);
                Main.submit();
            }
            finalResult.setVisible(true);
        });

        totalSection.getChildren().addAll(totalTitle, subTotPrice, taxPrice, finalPrice, submitOrder, finalResult);

        AnchorPane.setTopAnchor(checkout, 50.0);
        AnchorPane.setLeftAnchor(checkout, 200.0);
        AnchorPane.setTopAnchor(paymentSection, 150.0);
        AnchorPane.setLeftAnchor(paymentSection, 25.0);
        AnchorPane.setTopAnchor(shippingSection, 150.0);
        AnchorPane.setLeftAnchor(shippingSection, 425.0);
        AnchorPane.setTopAnchor(totalSection, 150.0);
        AnchorPane.setLeftAnchor(totalSection, 825.0);

        checkLayout.getCenter().getChildren().addAll(checkout, upperBorder, firstBorder, secondBorder, paymentSection,
                shippingSection, totalSection);

        return checkLayout;
    }

    /**
     * Private method to create the order confirmation / receipt
     * @param primaryStage stage for the window
     * @param payment last 4 of card number and name on card
     * @param address street address
     * @return CustomPane representing the receipt page
     */
    private CustomPane makeReceipt(Stage primaryStage, String payment, String address) {
        CustomPane receiptLayout = new CustomPane();
        homeAndAbout(receiptLayout, primaryStage);

        Label receipt = new Label("ORDER SUMMARY");
        receipt.setFont(Font.font("Calibri",FontWeight.BOLD, 28));
        Line upperBorder = new Line(150, 100, 1050, 100);

        Label items = new Label("Items:");
        Label price = new Label("Price:");
        Label pay = new Label("Payment:");
        Label ship = new Label("Delivering to:");
        Label conf = new Label("Confirmation Number:");
        Text numItems = new Text();
        Text finalPrice = new Text(String.format("%.2f", Main.order.getFinalPrice()));
        Text payInfo;
        Text shipInfo;
        Text confNum = new Text();

        if (!payment.equals("No card")) {
            payInfo = new Text(payment);
        } else {
            payInfo = new Text("In person");
        }
        if (!address.equals("In Store")) {
            shipInfo = new Text(address);
        } else {
            shipInfo = new Text("Picking up");
        }

        byte num = 0;
        for (Pizza p : Main.order.getPizzas())
            ++num;
        for (Drink d : Main.order.getDrinks())
            num += d.getCount();
        for (Side s : Main.order.getSides())
            num += s.getCount();

        numItems.setText(String.valueOf(num));
        int orderNum = (int)(Math.random() * 100000);
        confNum.setText(String.format("%07d", orderNum));
        confNum.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        conf.setFont(Font.font("Calibri", 14));

        VBox itemBox = new VBox(10, items, numItems);
        VBox priceBox = new VBox(10, price, finalPrice);
        VBox payBox = new VBox(10, pay, payInfo);
        VBox shipBox = new VBox(10, ship, shipInfo);
        itemBox.setPrefWidth(250);
        priceBox.setPrefWidth(250);
        payBox.setPrefWidth(250);
        shipBox.setPrefWidth(250);

        HBox data = new HBox(itemBox, priceBox, payBox, shipBox);

        AnchorPane.setTopAnchor(receipt, 50.0);
        AnchorPane.setLeftAnchor(receipt, 200.0);
        AnchorPane.setTopAnchor(data, 150.0);
        AnchorPane.setLeftAnchor(data, 100.0);
        AnchorPane.setTopAnchor(conf, 400.0);
        AnchorPane.setLeftAnchor(conf, 525.0);
        AnchorPane.setTopAnchor(confNum, 450.0);
        AnchorPane.setLeftAnchor(confNum, 550.0);

        receiptLayout.getCenter().getChildren().addAll(receipt, upperBorder, data, conf, confNum);

        return receiptLayout;
    }

}