module com.example.planning {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.planning to javafx.fxml;
    exports com.example.planning;

    exports vue;
}