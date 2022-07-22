module com.pdftools.toolspdf {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.pdftools.toolspdf to javafx.fxml;
    exports com.pdftools.toolspdf;
}