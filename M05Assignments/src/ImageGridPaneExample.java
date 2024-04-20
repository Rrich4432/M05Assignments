import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageGridPaneExample extends Application {

    private static final String[] imageFileNames = {
            "flag2.gif",
            "flag7.gif",
            "flag6.gif",
            "flag1.gif"
    };

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane to hold the images
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Display images from the file names
        for (int i = 0; i < imageFileNames.length; i++) {
            Image image = new Image(getClass().getResourceAsStream(imageFileNames[i]));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200); // Adjust the width of the image view
            imageView.setPreserveRatio(true); // Maintain aspect ratio
            gridPane.add(imageView, i % 2, i / 2);
        }

        // Create a scene and set it on the stage
        Scene scene = new Scene(gridPane, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 14.1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
