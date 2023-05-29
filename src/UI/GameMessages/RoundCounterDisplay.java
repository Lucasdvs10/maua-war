package UI.GameMessages;

import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IEventListener;
import domain.usecase.ManageRoundsUseCase;


public class RoundCounterDisplay implements IEventListener {
    ManageRoundsUseCase roundsUseCase;
    @Override
    public void OnEventRaised() {
        ShowMessage(String.format("Round: %d", roundsUseCase.get_currentRound()));
    }

    public RoundCounterDisplay(ManageRoundsUseCase useCase) {
        roundsUseCase = useCase;
        EventManager.SubscribeInEvent("EV_NEXT_ROUND", this);
    }

    public void ShowMessage(String messageString) {
        System.out.println(messageString);
    }

}
