module com.example.javafx_task {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_task to javafx.fxml;
    exports com.example.javafx_task;
}