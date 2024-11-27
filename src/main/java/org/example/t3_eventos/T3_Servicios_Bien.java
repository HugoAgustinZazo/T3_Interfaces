package org.example.t3_eventos;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T3_Servicios_Bien extends Application {

    class Service extends javafx.concurrent.Service {

        @Override
        protected Task createTask() {
            return new Task() {
                @Override
                protected String call() throws Exception {

                    Thread.sleep(3000);
                    return "PROCESO TERMINADO";
                }
            };
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    int num = 0;

    @Override
    public void start(Stage primaryStage) {


        Button b1 = new Button("CONSULTA A BASE DE DATOS");
        Label l1 = new Label();
        Button b2 = new Button("INCREMENTAR CONTADOR");
        Label l2 = new Label("0");
        ProgressIndicator p1 = new ProgressIndicator();
        p1.setVisible(false);
        b1.setOnAction(e -> {
            p1.setVisible(true);
            l1.setText("PROCESO COMENZANDO...");
            Service se1 = new Service();
            se1.start();
            se1.setOnSucceeded(a -> {
                l1.setText((String) se1.getValue());
            });

        });
        b2.setOnAction(e -> {
            num++;
            l2.setText(String.valueOf(num));


        });

        VBox vBox = new VBox(b1, l1,p1, b2, l2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        vBox.getChildren().addAll();
        Scene escena = new Scene(vBox, 500, 500);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
