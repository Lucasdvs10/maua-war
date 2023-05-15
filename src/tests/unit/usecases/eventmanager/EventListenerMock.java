package tests.unit.usecases.eventmanager;

import domain.entities.eventsystem.IEventListener;

public class EventListenerMock implements IEventListener {
    public boolean hasBeenCalledFlag = false;

    @Override
    public void OnEventRaised() {
        hasBeenCalledFlag = true;
    }

    public EventListenerMock() {

    }
}
