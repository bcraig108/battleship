module battleship {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens battleship to javafx.fxml;
    exports battleship;
}