package org.example.t3_eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_checkbox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CheckBox rd = new CheckBox("Opcion 1");
        CheckBox rd2 = new CheckBox("Opcion 2");
        CheckBox rd3 = new CheckBox("Opcion 3");


        Button button = new Button("Submit");

        Label label = new Label();

        button.setOnAction(actionEvent -> {
            if (rd.isSelected()) {
                label.setText("Uds ha seleccionado la " + rd.getText());
                if (rd2.isSelected()) {
                    label.setText("Uds ha seleccionado la " + rd.getText() + " y la " + rd2.getText());
                } else if (rd3.isSelected()) {
                    label.setText("Uds ha seleccionado la " + rd.getText() + " y la " + rd3.getText());
                } else if (rd.isSelected() && rd2.isSelected() && rd3.isSelected()) {
                    label.setText("Ha seleccionado todas las opciones");
                }
            }else if (rd2.isSelected()) {
                label.setText("Uds ha seleccionado la " + rd2.getText());
                if (rd.isSelected()) {
                    label.setText("Uds ha seleccionado la " + rd2.getText() + " y la " + rd.getText());
                } else if (rd3.isSelected()) {
                    label.setText("Uds ha seleccionado la " + rd2.getText() + " y la " + rd3.getText());
                } else if (rd.isSelected() && rd2.isSelected() && rd3.isSelected()) {
                    label.setText("Ha seleccionado todas las opciones");

                }
            }else if(rd3.isSelected()) {
                    label.setText("Uds ha seleccionado la " + rd3.getText());
                    if (rd2.isSelected()) {
                        label.setText("Uds ha seleccionado la " + rd3.getText() + " y la " + rd2.getText());
                    } else if (rd.isSelected()) {
                        label.setText("Uds ha seleccionado la " + rd3.getText() + " y la " + rd.getText());
                    } else if (rd.isSelected() && rd2.isSelected() && rd3.isSelected()) {
                        label.setText("Ha seleccionado todas las opciones");

                    }
                }
            else
                label.setText("Ninguna opcion ha sido seleccionada");
        });

        VBox vBox = new VBox();

        vBox.getChildren().addAll(rd,rd2,rd3,button,label);
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
