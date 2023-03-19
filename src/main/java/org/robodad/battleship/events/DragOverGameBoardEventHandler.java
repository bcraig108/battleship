package org.robodad.battleship.events;

import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

// public class DragOverGameBoardEventHandler implements EventHandler<DragEvent> {

//     /**
//      * handle - This method handes a drag event by highlighting the drop
//      */
//     public void handle(DragEvent event) {
//         /* data is dragged over the target */
//         /* accept it only if it is not dragged from the same node 
//          * and if it has a string data */
//         if (event.getGestureSource() != board && event.getDragboard().hasImage()) {
//             /* allow for moving */
//             event.acceptTransferModes(TransferMode.MOVE);

//             ShipImageView ship = (ShipImageView)event.getGestureSource();
//             System.out.println("DragOver " + ship.getCells());
//         }
        
//         event.consume();
//     }
// }
