package org.robodad.battleship.events;

import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseClickedEventHandler implements EventHandler<MouseEvent> {

    ShipImageView view;

    public MouseClickedEventHandler(ShipImageView view) {
        this.view = view;
    }

    public void handle(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY) {
            if (view.getOrientation() == Orientation.HORIZONTAL) {
                view.setRotate(90.0);
                view.setOrientation(Orientation.VERTICAL);
            }
            else {
                view.setRotate(0.0);
                view.setOrientation(Orientation.HORIZONTAL);
            }
        }
        event.consume();
        System.out.println("MouseClickedEventHandler.handle()");
    }
}
