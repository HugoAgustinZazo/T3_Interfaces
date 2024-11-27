package org.example.t3_eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_ejercicio2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        RadioButton rd = new RadioButton("Opcion 1");
        RadioButton rd2 = new RadioButton("Opcion 2");

        Button button = new Button("Submit");

        Label label = new Label();

        button.setOnAction(actionEvent -> {
            if(rd.isSelected()){
                label.setText("Uds ha seleccionado la "+rd.getText());
            }else if(rd2.isSelected()){
                label.setText("Uds ha seleccionado la " +rd2.getText());
            }else
                label.setText("Ninguna opcion ha sido seleccionada");
        });

        VBox vBox = new VBox();

        vBox.getChildren().addAll(rd,rd2,button,label);
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
