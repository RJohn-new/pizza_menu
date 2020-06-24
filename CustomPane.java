import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * Custom template layout for the UI pages
 */
public class CustomPane extends VBox{

    private HBox topOfPage = new HBox(10);
    private AnchorPane centerOfPage = new AnchorPane();
    private HBox bottomOfPage = new HBox(10);

    Button goHome = new Button("Home");
    Button goToAbout = new Button("About");
    Button goToPizza = new Button("Pizza");
    Button goToDrink = new Button("Drinks");
    Button goToSides = new Button("Sides");
    Button loggedStatus = new Button("Sign In/Sign out");

    /**
     *  Constructor for the page template
     */
    public CustomPane() {
        Insets inset = new Insets(5,5,5,5);
        this.setPadding(inset);
        this.getChildren().add(topOfPage);
        this.getChildren().add(centerOfPage);
        this.getChildren().add(bottomOfPage);
        topOfPage.setPadding(inset);
        centerOfPage.setPadding(inset);
        centerOfPage.setPrefSize(1200, 500);
        topOfPage.setAlignment(Pos.CENTER);

        ImageView topLeft = new ImageView(new Image("Images/momandpop.png"));
        topLeft.setFitWidth(400);
        topLeft.setX(0.0);

        HBox centerButtons = new HBox(goHome, goToAbout);
        centerButtons.setPrefWidth(450);
        centerButtons.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(centerButtons, Priority.ALWAYS);

        Region blank = new Region();
        blank.setPrefWidth(75);
        HBox.setHgrow(blank, Priority.ALWAYS);
        Region rightBlank = new Region();
        HBox.setHgrow(rightBlank, Priority.ALWAYS);

        topOfPage.getChildren().addAll(topLeft, blank, centerButtons, rightBlank, loggedStatus);

        AnchorPane.setLeftAnchor(goToPizza, 530.0);
        AnchorPane.setTopAnchor(goToPizza, 5.0);
        AnchorPane.setLeftAnchor(goToDrink, 575.0);
        AnchorPane.setTopAnchor(goToDrink, 5.0);
        AnchorPane.setLeftAnchor(goToSides, 625.0);
        AnchorPane.setTopAnchor(goToSides, 5.0);

        goHome.setFont(Font.font("Arial Black", 18));
        goToAbout.setFont(Font.font("Arial Black", 18));
        goToPizza.setFont(Font.font("Calibri", 14));
        goToDrink.setFont(Font.font("Calibri", 14));
        goToSides.setFont(Font.font("Calibri", 14));
        goToPizza.setStyle("-fx-background-color: #f09609;");
        goToDrink.setStyle("-fx-background-color: #f09609;");
        goToSides.setStyle("-fx-background-color: #f09609;");
        loggedStatus.setFont(Font.font("Arial Black", 14));
        loggedStatus.setStyle("-fx-background-color: #f09609;");


        Rectangle banner = new Rectangle(50, 50, Color.rgb(240,150,9));
        banner.widthProperty().bind(this.widthProperty().subtract(10));
        centerOfPage.getChildren().add(banner);

        Line bar = new Line(-20, 50, 1200, 50);
        bottomOfPage.getChildren().add(bar);

        centerOfPage.getChildren().add(goToPizza);
        centerOfPage.getChildren().add(goToDrink);
        centerOfPage.getChildren().add(goToSides);
    }

    /**
     * @return the HBox at the bottom of the page
     */
    public AnchorPane getCenter() {
        return centerOfPage;
    }
}

