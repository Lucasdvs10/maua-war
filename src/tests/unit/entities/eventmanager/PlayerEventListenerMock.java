package tests.unit.entities.eventmanager;

import domain.entities.Player;
import domain.entities.eventsystem.IPlayerEventListener;

public class PlayerEventListenerMock implements IPlayerEventListener {
    public boolean hasBeenCalledFlag = false;
    public Player player;
    @Override
    public void OnPlayerEventRaised(Player player) {
        hasBeenCalledFlag = true;
        this.player = player;
    }

    public PlayerEventListenerMock(){

    }
}
