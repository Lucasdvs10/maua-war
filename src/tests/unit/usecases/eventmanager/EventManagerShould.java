package tests.unit.usecases.eventmanager;

import domain.usecase.eventsystem.EventManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class EventManagerShould {
    EventListenerMock listenerMock;
    EventListenerMock listenerMock2;

    @BeforeEach
    public void SetupTests(){
        listenerMock  = new EventListenerMock();

        listenerMock2  = new EventListenerMock();

        EventManager.AllEventsMap = new HashMap<>();
    }

    @Test
    public void Create_An_Event(){
        EventManager.CreateEventIfItDoesNotExists("Meu Unico Evento");

        Assertions.assertEquals(1, EventManager.AllEventsMap.size());
        Assertions.assertNotNull(EventManager.AllEventsMap.get("Meu Unico Evento"));
    }

    @Test
    public void Not_Create_An_Event_If_It_Already_Exists(){
        EventManager.CreateEventIfItDoesNotExists("Meu Unico Evento");
        EventManager.CreateEventIfItDoesNotExists("Meu Unico Evento");

        Assertions.assertEquals(1, EventManager.AllEventsMap.size());
        Assertions.assertNotNull(EventManager.AllEventsMap.get("Meu Unico Evento"));
    }

    @Test
    public void Add_Mock_Listeners_To_List(){
        EventManager.CreateEventIfItDoesNotExists("Meu Unico Evento");

        EventManager.SubscribeInEvent("Meu Unico Evento", listenerMock);
        EventManager.SubscribeInEvent("Meu Unico Evento", listenerMock2);

        Assertions.assertEquals(2, EventManager.AllEventsMap.get("Meu Unico Evento").size());
    }

    @Test
    public void Remove_Mock_Listeners_From_List(){
        EventManager.CreateEventIfItDoesNotExists("Meu Unico Evento");

        EventManager.SubscribeInEvent("Meu Unico Evento", listenerMock);
        EventManager.SubscribeInEvent("Meu Unico Evento", listenerMock2);


        EventManager.UnsubscribeInEvent("Meu Unico Evento", listenerMock);
        EventManager.UnsubscribeInEvent("Meu Unico Evento", listenerMock2);

        Assertions.assertEquals(0, EventManager.AllEventsMap.get("Meu Unico Evento").size());
    }

    @Test
    public void Turn_Mock_Flag_To_True_When_Raise_Event(){
        EventManager.CreateEventIfItDoesNotExists("Meu Unico Evento");

        EventManager.SubscribeInEvent("Meu Unico Evento", listenerMock);

        EventManager.RaiseAnEvent("Meu Unico Evento");

        Assertions.assertTrue(listenerMock.hasBeenCalledFlag);
    }


    @Test
    public void Turn_Only_Mock2_Flag_To_True(){
        EventManager.CreateEventIfItDoesNotExists("Meu Unico Evento");
        EventManager.CreateEventIfItDoesNotExists("Meu Outro Evento");

        EventManager.SubscribeInEvent("Meu Unico Evento", listenerMock);
        EventManager.SubscribeInEvent("Meu Outro Evento", listenerMock2);

        EventManager.RaiseAnEvent("Meu Outro Evento");

        Assertions.assertFalse(listenerMock.hasBeenCalledFlag);
        Assertions.assertTrue(listenerMock2.hasBeenCalledFlag);
    }
}
