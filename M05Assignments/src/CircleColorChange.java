import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleColorChange extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, Color.WHITE); // Create a circle with white color
        circle.setStroke(Color.BLACK); // Add black border to the circle

        // Event handler for mouse press
        circle.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) { // Check if left mouse button is pressed
                circle.setFill(Color.BLACK); // Change circle color to black
            }
        });

        // Event handler for mouse release
        circle.setOnMouseReleased(event -> {
            if (event.getButton() == MouseButton.PRIMARY) { // Check if left mouse button is released
                circle.setFill(Color.WHITE); // Change circle color to white
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(circle);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 15.7");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
