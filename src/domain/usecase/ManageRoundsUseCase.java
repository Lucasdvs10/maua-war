package domain.usecase;

import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IEventListener;

public class ManageRoundsUseCase implements IEventListener {
    private int _currentRound;

    public int GoToNextRound(){
        this._currentRound++;
        EventManager.RaiseAnEvent("NEXT_ROUND");
        return this._currentRound;
    }

    @Override
    public void OnEventRaised() {
        GoToNextRound();
    }

    public int get_currentRound() {
        return _currentRound;
    }

    public ManageRoundsUseCase(){
        this._currentRound = 0;
        EventManager.CreateEventIfItDoesNotExists("NEXT_ROUND");
    }
    public ManageRoundsUseCase(String eventToSubscribe){
        this._currentRound = 0;
        EventManager.CreateEventIfItDoesNotExists("NEXT_ROUND");
        EventManager.SubscribeInEvent(eventToSubscribe, this);
    }
    public ManageRoundsUseCase(int _currentRound) {
        EventManager.CreateEventIfItDoesNotExists("NEXT_ROUND");

        if(_currentRound > 0)
            this._currentRound = _currentRound;
    }

}
