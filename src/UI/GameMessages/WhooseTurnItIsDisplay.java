package UI.GameMessages;

import domain.entities.Player;
import domain.entities.eventsystem.IEventListener;

import javax.swing.*;

public class WhooseTurnItIsDisplay extends JTextField  implements IEventListener {
    Player[] playersArray;
    int currentIndex = 0;
    @Override
    public void OnEventRaised() {
        setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        setForeground(getCurrentPlayer().get_playerColor());
        setText(String.format("Vez do %s", getCurrentPlayer().GetPlayerName()));

        AddOneToIndex();
    }

    private void AddOneToIndex(){
        currentIndex++;

        if(currentIndex >= playersArray.length)
            currentIndex = 0;
    }
    private Player getCurrentPlayer(){
        return playersArray[currentIndex];
    }

    public void setPlayersArray(Player[] playersArray) {
        this.playersArray = playersArray;
    }
}
