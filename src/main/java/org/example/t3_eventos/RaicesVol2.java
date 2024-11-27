package org.example.t3_eventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaicesVol2 extends Application {
    Scene escena;
    static ArrayList<Persona> alumnos2 = new ArrayList<>();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        ComboBox comboBox=new ComboBox<>();
        Label l1=new Label("2023-2024");
        Label l2=new Label("2024-2025");
        comboBox.getItems().addAll(l1,l2);
        comboBox.setMinHeight(68);
        Label l3=new Label("Año Academico: ");
        Label l4 = new Label("");


        Button b1=new Button();
        Button b2=new Button();
        Button b3=new Button();

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(b3,b1,b2);
        FileInputStream imagen = new FileInputStream("tick.jpg");
        Image imagenRe = new Image(imagen);
        ImageView foto = new ImageView(imagenRe);
        foto.setFitWidth(40);
        foto.setFitHeight(40);


        b1.setGraphic(foto);
        b1.setText("Guardar");
        b1.setContentDisplay(ContentDisplay.TOP);
        FileInputStream imagen1 = new FileInputStream("cruz.jpg");
        Image imagenRe1 = new Image(imagen1);
        ImageView foto1 = new ImageView(imagenRe1);
        foto1.setFitWidth(40);
        foto1.setFitHeight(40);
        b2.setGraphic(foto1);
        b2.setText("Cancelar");
        b2.setContentDisplay(ContentDisplay.TOP);

        FileInputStream imagen2 = new FileInputStream("re.png");
        Image imagenRe2 = new Image(imagen2);
        ImageView foto2 = new ImageView(imagenRe2);
        foto2.setFitWidth(40);
        foto2.setFitHeight(40);
        b3.setGraphic(foto2);
        b3.setText("Recargar");
        b3.setContentDisplay(ContentDisplay.TOP);


        DatePicker datePicker1=new DatePicker();
   datePicker1.setMinHeight(68);
   datePicker1.setMinWidth(100);

        VBox vBox=new VBox();
        vBox.setSpacing(10);
        FlowPane flowFotos = new FlowPane();
        flowFotos.setHgap(10);
        flowFotos.setVgap(10);
        flowFotos.setPrefWrapLength(800);

        List<String> alumnos = Arrays.asList(
                "Agustín Zazo Hugo",
                "Baltasar Méndez Liberto",
                "Brihuega García Marco",
                "Cals González Alejandro",
                "Castillo Quintanar Daniel",
                "Cazorla Asensio Víctor",
                "Corral Tejero Félix",
                "Cózar Esteban Marcos",
                "Goujón Guitérrez Diego",
                "Hernández Gómez Javier",
                "Jaén Martín Celia",
                "Moreno Jiménez Matías",
                "Pérez Mínguez Iván",
                "Pérez Navarro Alberto",
                "Ponce Plaza Sergio",
                "Pordomingo Fernández Jorge",
                "Ramos Mejías Marco",
                "Rodríguez García Mario",
                "Rodríguez Ruescas Adrián",
                "Strohush Loyish Alejandro"

        );

        int j=0;
        for(int i=0;i<alumnos.size();i++){
           if(i<9) {
               VBox vBoxFoto = crearAlumno(j + "" + (i+1) + ".jpg",alumnos.get(i));
               flowFotos.getChildren().add(vBoxFoto);


           }else {
               VBox vBoxFoto = crearAlumno((i+1)+ ".jpg",alumnos.get(i));
               flowFotos.getChildren().add(vBoxFoto);

           }

        }
        b3.setOnAction(actionEvent -> {
            for(Persona p : alumnos2){
                if(p.getRd1().isSelected()){
                    p.getRd1().setSelected(false);
                }else
                if(p.getRd2().isSelected()){
                    p.getRd2().setSelected(false);
                }else
                if(p.getRd3().isSelected()){
                    p.getRd3().setSelected(false);
                }
            }

            if(datePicker1.getValue()!=null){
                datePicker1.setValue(null);
            }
        });

        b2.setOnAction(actionEvent -> {
            primaryStage.close();
        });
        b1.setOnAction(e->{
            TableView tableView =new TableView<>();
            Button volver = new Button("VOLVER");
            TableColumn tableColumn1=new TableColumn<>("Nombre");
            TableColumn tableColumn2=new TableColumn<>("tipo de falta");
            TableColumn tableColumn3=new TableColumn<>("Fecha");
            tableView.resizeColumn(tableColumn1,100);
            tableView.resizeColumn(tableColumn2,10);
            tableView.resizeColumn(tableColumn3,10);
            tableView.setTableMenuButtonVisible(true);
            tableView.getColumns().addAll(tableColumn1,tableColumn2,tableColumn3);


            tableColumn1.setCellValueFactory(new PropertyValueFactory("n"));
            tableColumn2.setCellValueFactory(new PropertyValueFactory("a"));
            tableColumn3.setCellValueFactory(new PropertyValueFactory("f"));

            for(Persona p : alumnos2) {
                String falta = "";
                if(p.getRd1().isSelected()){
                    falta="I";
                }else if(p.getRd2().isSelected()){
                    falta="J";
                }else if(p.getRd3().isSelected()){
                    falta="R";
                }
                if(datePicker1.getValue()!=null){

                    p.setFecha(LocalDate.parse(datePicker1.getValue().toString()));
                }
                p.setFalta(falta);
                tableView.getItems().add(p);
            }
            volver.setOnAction(actionEvent->{
                primaryStage.setScene(escena);
                primaryStage.show();
            });
            VBox vBox1 = new VBox();
            vBox1.getChildren().add(volver);
            vBox1.setSpacing(20);
            StackPane st = new StackPane();
            st.getChildren().add(volver);
            SplitPane splitPane = new SplitPane();
            splitPane.setPadding(new Insets(10));
            splitPane.getItems().addAll(tableView,st);
            Scene escena2=new Scene(splitPane ,800,800);
            primaryStage.setScene(escena2);
            primaryStage.show();

        });


        flowFotos.setHgap(50);
        flowFotos.setVgap(50);
        HBox hBox3 = new HBox();
        hBox2.setSpacing(10);
        hBox3.getChildren().addAll(l3,comboBox,datePicker1);
        hBox3.setSpacing(10);
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(hBox3,hBox2);
        hBox1.setSpacing(180);
        vBox.getChildren().addAll(hBox1,l4,flowFotos);

        HBox hBox=new HBox();
        hBox.setSpacing(10);

        hBox.setAlignment(Pos.TOP_CENTER);
        VBox vbox2 = new VBox();
        vbox2.getChildren().add(vBox);

        vbox2.setPadding(new Insets(10));


        escena=new Scene(vbox2,800,800);
        primaryStage.setScene(escena);
        primaryStage.show();

    }
    public VBox crearAlumno(String nombreImagen, String nombre) throws FileNotFoundException {

            RadioButton rd1 = new RadioButton("I");
            RadioButton rd2 = new RadioButton("J");
            RadioButton rd3 = new RadioButton("R");

        Persona p = new Persona(nombre,"",LocalDate.parse(LocalDate.now().toString()),rd1,rd2,rd3);
        alumnos2.add(p);
        VBox vBox=new VBox();

        FileInputStream imagen = new FileInputStream(nombreImagen);
        Image imagenRe = new Image(imagen);
        ImageView foto = new ImageView(imagenRe);
        foto.setFitWidth(75);
        foto.setFitHeight(75);
        Label l1=new Label(nombre);
        vBox.setSpacing(10);



        ToggleGroup group = new ToggleGroup();
        p.getRd1().setToggleGroup(group);
        p.getRd2().setToggleGroup(group);
        p.getRd3().setToggleGroup(group);

        HBox hBoxRadioButtons = new HBox(1);

        hBoxRadioButtons.getChildren().addAll(p.getRd1(),p.getRd2(),p.getRd3());
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(foto, l1,hBoxRadioButtons);
        vBox.setMaxSize(100,100);
        vBox.setMinSize(100,100);
        return  vBox;
    }
    public class Persona{
        String nombre;
        String falta;
        LocalDate fecha;
        RadioButton rd1;
        RadioButton rd2;
        RadioButton rd3;


        public Persona(String nombre,String falta,LocalDate fecha,RadioButton rd1, RadioButton rd2, RadioButton rd3) {
            this.nombre = nombre;
            this.falta = falta;
            this.fecha = fecha;
            this.rd1 = rd1;
            this.rd2 = rd2;
            this.rd3 = rd3;
        }

        public String getFalta() {
            return falta;
        }

        public void setFalta(String falta) {
            this.falta = falta;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public RadioButton getRd1() {
            return rd1;
        }

        public void setRd1(RadioButton rd1) {
            this.rd1 = rd1;
        }

        public RadioButton getRd2() {
            return rd2;
        }

        public void setRd2(RadioButton rd2) {
            this.rd2 = rd2;
        }

        public RadioButton getRd3() {
            return rd3;
        }

        public void setRd3(RadioButton rd3) {
            this.rd3 = rd3;
        }

        public String getN() {
            return nombre;
        }

        public String getA() {
            return falta;
        }

        public LocalDate getF() {
            return fecha;
        }

    }

}
