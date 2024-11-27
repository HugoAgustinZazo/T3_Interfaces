package org.example.t3_eventos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_1_button extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Haz click aqui");
        Label label1 = new Label();

        button.setOnAction(actionEvent -> {
            label1.setText("Gracias por hacer click");
            button.setDisable(true);
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
        vBox.getChildren().add(button);
        vBox.getChildren().add(label1);


        Scene scene =new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
