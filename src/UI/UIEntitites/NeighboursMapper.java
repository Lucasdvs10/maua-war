package UI.UIEntitites;

import domain.entities.Block;

import java.util.HashMap;

public class NeighboursMapper {
    HashMap<String, Block[]> _neighboursMap;

    public NeighboursMapper(Block[] allBlocksArray){
        InitializeNeighboursHashMap(allBlocksArray);
    }

    public HashMap<String, Block[]> get_neighboursMap() {
        return _neighboursMap;
    }

    public void InitializeNeighboursHashMap(Block[] allBlocksArray){
        _neighboursMap = new HashMap<>();

        _neighboursMap.put("Bloco J", new Block[]{
                allBlocksArray[2],
                allBlocksArray[10],
        });


        _neighboursMap.put("Bloco R", new Block[]{
                allBlocksArray[3],
                allBlocksArray[10],
        });


        _neighboursMap.put("Ginasio", new Block[]{
                allBlocksArray[0],
                allBlocksArray[8],
        });


        _neighboursMap.put("Bloco H", new Block[]{
                allBlocksArray[1],
                allBlocksArray[9],
                allBlocksArray[6],
                allBlocksArray[7],
        });


        _neighboursMap.put("Bloco F", new Block[]{
                allBlocksArray[8],
                allBlocksArray[7],
                allBlocksArray[5],
        });


        _neighboursMap.put("Bloco E", new Block[]{
                allBlocksArray[4],
                allBlocksArray[11],
        });


        _neighboursMap.put("Bloco S", new Block[]{
                allBlocksArray[3],
                allBlocksArray[7],
                allBlocksArray[11],
        });


        _neighboursMap.put("Bloco W", new Block[]{
                allBlocksArray[9],
                allBlocksArray[4],
                allBlocksArray[11],
                allBlocksArray[6],
                allBlocksArray[3],
        });


        _neighboursMap.put("Bloco G", new Block[]{
                allBlocksArray[2],
                allBlocksArray[9],
                allBlocksArray[4],
        });


        _neighboursMap.put("Bloco V", new Block[]{
                allBlocksArray[8],
                allBlocksArray[7],
                allBlocksArray[3],
        });


        _neighboursMap.put("Bloco L", new Block[]{
                allBlocksArray[0],
                allBlocksArray[1],
        });

        _neighboursMap.put("Bloco A", new Block[]{
                allBlocksArray[5],
                allBlocksArray[6],
                allBlocksArray[7]
        });

    }
}
