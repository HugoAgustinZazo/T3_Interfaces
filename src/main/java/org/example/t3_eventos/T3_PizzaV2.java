package org.example.t3_eventos;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class T3_PizzaV2 extends Application {
    static int contador = 0;
    Scene sc1;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();

        Button button1 = new Button("Pizza Price Calculator");
        Button button = new Button("order it");
        Button volver = new Button("Back");
        VBox vBox3 = new VBox();
        Label label1 = new Label();
        Font font4 = new Font("Times New Roman",20);
        label1.setFont(font4);
        Label label2 = new Label("");
        Label label3 = new Label("");

        VBox vBox1 = new VBox();

        CheckBox checkBox1 = new CheckBox("Extra Chesse:$1");
        CheckBox checkBox2 = new CheckBox("Pepperoni:$2");
        CheckBox checkBox3 = new CheckBox("Sausage:$3");
        CheckBox checkBox = new CheckBox("Tip: $");
        vBox1.getChildren().add(checkBox1);
        vBox1.getChildren().add(checkBox2);
        vBox1.getChildren().add(checkBox3);


        VBox vBox2 = new VBox();
        TextField tf = new TextField("0");
        tf.setMaxSize(50,20);
        tf.setDisable(true);
        HBox hBox = new HBox();

        hBox.getChildren().addAll(checkBox,tf);
        CheckBox checkBox4 = new CheckBox("Green Pepper:$4");
        CheckBox checkBox5 = new CheckBox("Onion:$5");
        CheckBox checkBox6 = new CheckBox("Anchovies:$6");

        checkBox.setOnAction(actionEvent ->{
            if(tf.isDisable()){
                tf.setDisable(false);
            }else {
                tf.setDisable(true);
                tf.setText("0");
            }


                }
                );
        button1.setOnAction(actionEvent -> {
            if(checkBox1.isSelected()){
                contador+=1;
            }
            if(checkBox2.isSelected()){
                contador+=2;

            }if(checkBox3.isSelected()){
                contador+=3;

            }if(checkBox4.isSelected()){
                contador+=4;

            }if(checkBox5.isSelected()){
                contador+=5;
            }
            if(checkBox6.isSelected()){
                contador+=6;

            }if(checkBox.isSelected()){
                contador+=Integer.parseInt(tf.getText());
            }else {
                label1.setText("No has seleccionado nada");
            }
            if(!checkBox1.isSelected()&&!checkBox2.isSelected()&&!checkBox3.isSelected()&&!checkBox4.isSelected()&&!checkBox5.isSelected()&&!checkBox6.isSelected()){
                label1.setText("Elige algun ingrediente");
            }else {
                label1.setText("Pizza Cost: $" + contador);
                contador = 0;
            }
            });

        button.setOnAction(actionEvent -> {
            BorderPane bp = new BorderPane();
            Label label4 = new Label("Order Received. Please Wait...");
            VBox vBox4 = new VBox();
            vBox4.getChildren().add(volver);
            vBox4.setSpacing(10);
            vBox4.setAlignment(Pos.BOTTOM_CENTER);
            bp.setBottom(vBox4);
            bp.setCenter(label4);

            Scene Scene2 = new Scene(bp,300,300);
            primaryStage.setScene(Scene2);
            primaryStage.setTitle("T3_Pedido hecho");
            primaryStage.show();


            });

        volver.setOnAction(actionEvent -> {

            primaryStage.setScene(sc1);
            primaryStage.setTitle("T2_checkbox_ejercicio");
            primaryStage.show();

        });


        vBox3.getChildren().addAll(button,label1);
        vBox2.getChildren().add(checkBox4);
        vBox2.getChildren().add(checkBox5);
        vBox2.getChildren().add(checkBox6);
        vBox2.getChildren().add(hBox);
        vBox3.setSpacing(10);
        vBox3.setAlignment(Pos.BOTTOM_CENTER);

        borderPane.setCenter(button1);
        borderPane.setBottom(vBox3);
        borderPane.setTop(label2);
        borderPane.setLeft(vBox1);
        borderPane.setRight(vBox2);

        borderPane.setBackground(Background.fill(Paint.valueOf("#d8beda")));

        BorderPane.setAlignment(label1, Pos.CENTER);
        sc1 = new Scene(borderPane,500,500);
        primaryStage.setScene(sc1);
        primaryStage.setTitle("T2_checkbox_ejercicio");
        primaryStage.show();

    }
}
