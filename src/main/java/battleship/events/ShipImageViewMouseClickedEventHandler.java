package battleship.events;

import battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ShipImageViewMouseClickedEventHandler implements EventHandler<MouseEvent> {

    ShipImageView view;

    public ShipImageViewMouseClickedEventHandler(ShipImageView view) {
        this.view = view;
    }

    public void handle(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            view.HandleMouseButtonPrimary(event.getSceneX(), event.getSceneY());
        }
        else if (event.getButton() == MouseButton.SECONDARY) {
            view.HandleMouseButtonSecondary(event.getSceneX(), event.getSceneY());
        }
        event.consume();
    }
}
