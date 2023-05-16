package domain.entities.eventsystem;

import domain.entities.Player;

public interface IPlayerEventListener {
    void OnPlayerEventRaised(Player player);
}
