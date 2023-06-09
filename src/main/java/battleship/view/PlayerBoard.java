package battleship.view;

import battleship.controller.GameRules;
import battleship.controller.ShipRules;
import battleship.model.Player;
import battleship.model.Shot;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PlayerBoard extends BorderPane {

    private Player player;
    private OceanPane ocean;
    private FleetPane fleet;

    public PlayerBoard(Player player, GameRules rules) {
        this.player = player;
        this.player.setPlayerBoard(this);

        Label label = new Label(player.getName());
        label.setAlignment(Pos.CENTER);
        this.setTop(label);

        ocean = new OceanPane(player, rules);
        this.setCenter(ocean);

        fleet = new FleetPane(player, rules);
        this.setBottom(fleet);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void removeShip(ShipRules ship) {
        ocean.getChildren().remove(ship.getView());
    }

    public void updateMessage(String message) {
        fleet.updateMessage(message);
    }

    public void updateNumShips(int count) {
        fleet.updateNumShips(count);
    }

    public void addExplosion(Shot shot)
    {
        ocean.addExplosion(shot);
    }

    public void addPlop(Shot shot)
    {
        ocean.addPlop(shot);
    }
}
