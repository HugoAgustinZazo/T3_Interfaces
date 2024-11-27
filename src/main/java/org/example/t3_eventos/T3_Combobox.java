package org.example.t3_eventos;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_Combobox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ComboBox comboBox1 = new ComboBox();
        comboBox1.getItems().addAll("Opcion1","Opcion2","Opcion3");

        Button button = new Button("Submit");
        Label label = new Label();

        button.setOnAction(actionEvent -> {
            if(comboBox1.getValue()==null){
            label.setText("Elija una opcion");
            }else {
                label.setText("Ud ha seleccionado " + comboBox1.getValue());
            }

        });
        VBox vBox = new VBox();
        vBox.getChildren().addAll(comboBox1,button,label);
        vBox.setSpacing(10);
        Scene scene = new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
