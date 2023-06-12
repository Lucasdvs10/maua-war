package UI.UIEntitites;

import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IEventListener;
import domain.usecase.ManageRoundsUseCase;


public class RoundCounterDisplay extends javax.swing.JTextField implements IEventListener {
    ManageRoundsUseCase roundsUseCase;
    @Override
    public void OnEventRaised() {
        setText(String.format("Round: %d", roundsUseCase.get_currentRound()));
    }

    public RoundCounterDisplay(ManageRoundsUseCase useCase) {
        roundsUseCase = useCase;
        EventManager.SubscribeInEvent("EV_NEXT_ROUND", this);
        setText(String.format("Round: %d", roundsUseCase.get_currentRound()));
    }
}
