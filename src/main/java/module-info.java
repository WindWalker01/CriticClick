module org.example.criticclick {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens org.example.criticclick to javafx.fxml;
    exports org.example.criticclick;
    exports org.example.criticclick.controller;
    opens org.example.criticclick.controller to javafx.fxml;
}