module com.example.realsnakeleader {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.realsnakeleader to javafx.fxml;
    exports com.example.realsnakeleader;
}