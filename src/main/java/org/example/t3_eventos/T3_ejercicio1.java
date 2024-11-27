package org.example.t3_eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class T3_ejercicio1 extends Application {
    private int contador = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        Button button = new Button("Sumar contador");
        Button button1 = new Button("Reiniciar contador");
        Label label1 = new Label("0");

        button.setOnAction(actionEvent -> {
            contador++;
            label1.setText((contador)+"");
        });
        button1.setOnAction(actionEvent -> {
            label1.setText("0");
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
        vBox.getChildren().add(button1);
        vBox.getChildren().add(label1);
        vBox.setSpacing(10);

        Scene scene =new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
