package battleship.controller;

import java.util.ArrayList;
import java.util.List;

import battleship.model.Result;
import battleship.model.Shot;
import battleship.model.Constants.ShipType;
import battleship.model.Constants.ShotResult;
import battleship.view.PlayerBoard;

/**
 * This class contains the rules for each player's fleet
 */
public class FleetRules {
    
    /** This list of rules for each ship in the fleet */
    private List<ShipRules> ships;

    /** A reference the the player's board */
    private PlayerBoard board;

    /**
     * The constructor, create a list to hold the rules for each ship
     */
    public FleetRules() {
        ships = new ArrayList<>();
    }

    /**
     * Add a ship to the player's fleet
     * @param shipRules - the rules for the ship to be added
     */
    public void add(ShipRules shipRules) {
        ships.add(shipRules);
    }

    /**
     * Set the player's board
     * @param board the player's board
     */
    public void setPlayerBoard(PlayerBoard board) {
        this.board = board;
    }

    /**
     * Handle an opponent's shot, checking each ship in the fleet to determine
     * if it was hit, sunk or missed, return the result
     * @param shot - the opponent's shot
     * @return the result of the shot
     */
    public Result handleShot(Shot shot) {
        // for each ship in the fleet
        for (ShipRules shipRules : ships) {
            // check whether the ship was sunk, hit or missed
            Result result = shipRules.handleShot(shot);

            switch (result.getResult()) {
            case SUNK:
                // remove the ship from the fleet
                ships.remove(shipRules);

                // remove the ship icon from the board, update the messages
                board.removeShip(shipRules);
                board.updateMessage(shot + ": " + shipRules.getName() + " sunk!");
                board.updateNumShips(ships.size());

                return result;  // break the loop, ship is sunk
            case HIT:
                // update the message on the board
                board.updateMessage(shot + ": " + shipRules.getName() + " hit!");

                return result;  // break the loop, ship is hit
            case MISS:
            default:
                // update the message on the board
                board.updateMessage(shot + ": Miss!");
            }
        }
 
        // all ships in fleet were missed
        return new Result(ShotResult.MISS, ShipType.NONE);
    }

    /**
     * @return the fleet's state - if there are no more ships, the player loses
     */
    public boolean isLost() {
        return ships.isEmpty();        
    }
}
