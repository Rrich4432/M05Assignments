import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextColorPicker extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create sliders for red, green, blue, and opacity
        Slider redSlider = createSlider("Red", 0, 255, 0);
        Slider greenSlider = createSlider("Green", 0, 255, 0);
        Slider blueSlider = createSlider("Blue", 0, 255, 0);
        Slider opacitySlider = createSlider("Opacity", 0, 100, 100);

        // Create a text object
        Text text = new Text("Color Picker");
        text.setFont(Font.font(24));

        // Bind the fill property of the text to the slider values
        text.fillProperty().bind(
                javafx.beans.binding.Bindings.createObjectBinding(() ->
                        Color.rgb((int) redSlider.getValue(), (int) greenSlider.getValue(),
                                (int) blueSlider.getValue(), opacitySlider.getValue() / 100.0),
                        redSlider.valueProperty(), greenSlider.valueProperty(),
                        blueSlider.valueProperty(), opacitySlider.valueProperty()));

        // Create a VBox to hold the sliders and text
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                redSlider, greenSlider, blueSlider, opacitySlider, text);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 16.17");
        primaryStage.show();
    }

    private Slider createSlider(String label, double min, double max, double initialValue) {
        Slider slider = new Slider(min, max, initialValue);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(5);
        Label sliderLabel = new Label(label);
        sliderLabel.setLabelFor(slider);
        return slider;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
