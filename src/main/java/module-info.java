module org.example.t3_eventos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.t3_eventos to javafx.fxml;
    exports org.example.t3_eventos;
}