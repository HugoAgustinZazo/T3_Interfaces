package org.example.t3_eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class T3_label extends Application {
    static int contador = 12;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label label1 = new Label("Haz click sobre este texto");
        Label label2 = new Label();

        label1.setOnMouseClicked(mouseEvent -> {
            label1.setFont(new Font(contador+=5));
        });

        label1.setOnMouseEntered( mouseEvent -> {
            FileInputStream imagen = null;
            try {
                imagen = new FileInputStream("Real-Madrid-Logo.png");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Image imagenRe = new Image(imagen);
            ImageView foto = new ImageView(imagenRe);
            label1.setGraphic(foto);
            foto.setFitWidth(80);
            foto.setFitHeight(40);

        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label1,label2);
        vBox.setSpacing(10);
        Scene scene = new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
