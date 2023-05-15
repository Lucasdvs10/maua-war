package domain.usecase;

import domain.usecase.eventsystem.EventManager;
import domain.usecase.eventsystem.IEventListener;

public class ManageRoundsUseCase implements IEventListener {
    private int _currentRound;

    public int GoToNextRound(){
        this._currentRound++;
        EventManager.RaiseAnEvent("NEXT_ROUND");
        return this._currentRound;
    }

    public int get_currentRound() {
        return _currentRound;
    }

    public ManageRoundsUseCase(){
        this._currentRound = 0;
        EventManager.CreateEventIfItDoesNotExists("NEXT_ROUND");
    }
    public ManageRoundsUseCase(int _currentRound) {
        EventManager.CreateEventIfItDoesNotExists("NEXT_ROUND");

        if(_currentRound > 0)
            this._currentRound = _currentRound;
    }

    @Override
    public void OnEventRaised() {
        GoToNextRound();
    }
}
