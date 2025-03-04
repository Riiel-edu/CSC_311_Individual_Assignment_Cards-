module com.example.csc_311_individual_assignment_cards {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;


    opens com.example.csc_311_individual_assignment_cards to javafx.fxml;
    exports com.example.csc_311_individual_assignment_cards;
}