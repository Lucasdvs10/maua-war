package domain.entities;

import java.awt.*;
import java.util.HashMap;

public class Player {
    private int _playerID;
    private Color _playerColor;
    private HashMap<String, Block> _dominatedBlocksHashMap;

    public Player(int playerIndex, Color _playerColor) {
        this.set_playerID(playerIndex);
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

    public String GetPlayerName(){
        return String.format("Jogador %d", this._playerID);
    }
    public int get_playerID() {
        return _playerID;
    }

    public void set_playerID(int _playerID) {
        if(_playerID <= 0){
            this._playerID = 0;
            return;
        }
        this._playerID = _playerID;
    }

    public void set_dominatedBlocksHashMap(HashMap<String, Block> _dominatedBlocksHashMap) {
        this._dominatedBlocksHashMap = _dominatedBlocksHashMap;
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
