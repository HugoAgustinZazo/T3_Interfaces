package org.example.t3_eventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class T3_Tablas extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TableView tableView =new TableView<>();

        TableColumn tableColumn1=new TableColumn<>("Nombre");
        TableColumn tableColumn2=new TableColumn<>("Apellido");
        TableColumn tableColumn3=new TableColumn<>("Fecha");
        tableView.resizeColumn(tableColumn1,10);
        tableView.resizeColumn(tableColumn2,10);
        tableView.resizeColumn(tableColumn3,10);
        tableView.setTableMenuButtonVisible(true);
        tableView.getColumns().addAll(tableColumn1,tableColumn2,tableColumn3);


        tableColumn1.setCellValueFactory(new PropertyValueFactory("n"));
        tableColumn2.setCellValueFactory(new PropertyValueFactory("a"));
        tableColumn3.setCellValueFactory(new PropertyValueFactory("f"));

        Persona p1= new Persona("Bertrug", "Yildrim", LocalDate.parse("1970-06-11"));
        Persona p2= new Persona("Enes", "Unal", LocalDate.parse("1970-06-11"));
        Persona p3= new Persona("Arda", "Guller", LocalDate.parse("1970-06-11"));
        Persona p4= new Persona("Arda", "Turam", LocalDate.parse("1970-06-11"));
        tableView.getItems().addAll(p1,p2,p3,p4);

        StackPane stackPane=new StackPane();
        stackPane.setPadding(new Insets(10));
        stackPane.getChildren().add(tableView);
        Scene escena=new Scene(stackPane ,500,500);
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    public class Persona{
        String nombre;
        String apellidos;
        LocalDate fecha;

        public Persona(String nombre, String apellidos, LocalDate fecha) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fecha = fecha;
        }

        public String getN() {
            return nombre;
        }

        public String getA() {
            return apellidos;
        }

        public LocalDate getF() {
            return fecha;
        }
    }}
