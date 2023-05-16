package tests.unit.entities.eventmanager;

import domain.entities.Player;
import domain.entities.eventsystem.EventManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashMap;

public class EventManagerShould {
    EventListenerMock listenerMock;
    EventListenerMock listenerMock2;

    PlayerEventListenerMock playerEventListenerMock1;
    PlayerEventListenerMock playerEventListenerMock2;

    Player playerMock;

    @BeforeEach
    public void SetupTests(){
        listenerMock  = new EventListenerMock();

        listenerMock2  = new EventListenerMock();

        EventManager.AllEventsMap = new HashMap<>();


        playerEventListenerMock1 = new PlayerEventListenerMock();
        playerEventListenerMock2 = new PlayerEventListenerMock();
        playerMock = new Player(1, Color.BLUE);

        EventManager.AllPlayerEventsMap = new HashMap<>();
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

    @Test
    public void Create_Player_Event(){
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_UM_EVENTO_QUE_AINDA_NAO_EXISTE");

        Assertions.assertTrue(EventManager.AllPlayerEventsMap.containsKey("PL_UM_EVENTO_QUE_AINDA_NAO_EXISTE"));
    }

    @Test
    public void Create_Player_Event_Only_Once(){
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_UM_EVENTO_QUE_AINDA_NAO_EXISTE");
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_UM_EVENTO_QUE_AINDA_NAO_EXISTE");

        Assertions.assertEquals(1, EventManager.AllPlayerEventsMap.size());
    }

    @Test
    public void Turn_Player_Mock1_Flag_On(){
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_Teste");

        EventManager.SubscribeInPlayerEvent("PL_Teste", playerEventListenerMock1);
        EventManager.RaiseAnPlayerEvent("PL_Teste", playerMock);

        Assertions.assertTrue(playerEventListenerMock1.hasBeenCalledFlag);
        Assertions.assertSame(playerMock ,playerEventListenerMock1.player);
    }

    @Test
    public void Remove_Mock1_From_HashMap(){
        EventManager.CreatePlayerEventIfItDoesNotExists("PL_Teste");

        EventManager.SubscribeInPlayerEvent("PL_Teste", playerEventListenerMock1);
        EventManager.UnsubscribeInPlayerEvent("PL_Teste", playerEventListenerMock1);

        Assertions.assertEquals(0,EventManager.AllPlayerEventsMap.get("PL_Teste").size());
    }

}
