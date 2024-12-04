module org.example.crticclick {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.crticclick to javafx.fxml;
    exports org.example.crticclick;
}