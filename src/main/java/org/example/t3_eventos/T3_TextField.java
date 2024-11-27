package org.example.t3_eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_TextField extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Write your name");
        Button button1 = new Button("and click hear");
        Label label1 = new Label();
        TextField tf = new TextField();

        button1.setOnAction(actionEvent -> {
            label1.setText("hola "+tf.getText());
        });

        /*
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label1.setText("Gracias por hacer click");
            }
        });
*/

        VBox vBox = new VBox();
        vBox.getChildren().add(label);
        vBox.getChildren().add(tf);
        vBox.getChildren().add(button1);
        vBox.getChildren().add(label1);
        vBox.setSpacing(10);

        Scene scene =new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
