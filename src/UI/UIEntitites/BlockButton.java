package UI.UIEntitites;

import domain.entities.Block;
import domain.entities.Player;
import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IPlayerEventListener;

import javax.swing.*;

public class BlockButton extends JButton implements IPlayerEventListener {
    private Block _blockEntity;

    public Block get_blockEntity() {
        return _blockEntity;
    }

    public void set_blockEntity(Block _blockEntity) {
        this._blockEntity = _blockEntity;
    }

    public BlockButton(Block _blockEntity) {
        this._blockEntity = _blockEntity;

    }

    @Override
    public void OnPlayerEventRaised(Player player) {
//        _blockEntity.ApplyDamage(1);
//
//        if(_blockEntity.get_currentLife() <= 0){
//            _blockEntity.set_isDominated(true);
//            _blockEntity.set_playerWhoDominated(player);
//
//            EventManager.RaiseAnPlayerEvent("PL_DOMINATED_A_BLOC", player);
//
//            if(_blockEntity.get_playerWhoDominated() != null)
//                setBackground(_blockEntity.get_playerWhoDominated().get_playerColor());
//
//        }
    }
}
