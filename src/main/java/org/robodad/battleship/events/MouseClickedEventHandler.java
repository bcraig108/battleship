package org.robodad.battleship.events;

import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseClickedEventHandler implements EventHandler<MouseEvent> {

    ShipImageView view;

    public MouseClickedEventHandler(ShipImageView view) {
        this.view = view;
    }

    public void handle(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY) {
            view.HandleMouseButtonSecondary(event.getSceneX(), event.getSceneY());
        }
        event.consume();
        System.out.println("MouseClickedEventHandler.handle()");
    }
}
