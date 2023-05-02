package domain.entities;

import java.awt.*;
import java.util.HashMap;

public class Player {
    private String _playerName;
    private Color _playerColor;
    private HashMap<String, Block> _dominatedBlocksHashMap;

    public Player(String _playerName, Color _playerColor) {
        this._playerName = _playerName;
        this._playerColor = _playerColor;
        this._dominatedBlocksHashMap = new HashMap<>();
    }

    public void AddBlockToDominatedHashMap(Block block){
        this._dominatedBlocksHashMap.put(block.get_blockName(), block);
        block.set_isDominated(true);
    }

    public void AddBlockToDominatedHashMap(String blockName, Block block){
        this._dominatedBlocksHashMap.put(blockName, block);
        block.set_isDominated(true);
    }

    public String get_playerName() {
        return _playerName;
    }

    public void set_playerName(String _playerName) {
        this._playerName = _playerName;
    }

    public Color get_playerColor() {
        return _playerColor;
    }

    public void set_playerColor(Color _playerColor) {
        this._playerColor = _playerColor;
    }

    public HashMap<String, Block> get_dominatedBlocksHashMap() {
        return _dominatedBlocksHashMap;
    }
}
