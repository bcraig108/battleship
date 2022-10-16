module battleship {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens org.robodad.battleship to javafx.fxml;
    exports org.robodad.battleship;
}