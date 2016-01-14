package algernon2;

import java.util.HashMap;
import java.util.Map;

public enum MazeSpace {
	EMPTY(' '), 
	WALL('X'), 
	FLOWER('*'), 
	START('S'), 
	CHEESE('C'), 
	UP_ARROW('U'), 
	DOWN_ARROW('D'), 
	LEFT_ARROW('L'), 
	RIGHT_ARROW('R');
	
	private char symbol;
	
	MazeSpace(char symbol){
		this.symbol = symbol;
	}
	
	char getSymbol() {
		return symbol;
	}
	
    private static Map<Character, MazeSpace> symbolToSpaceMap;
    
    public static MazeSpace getMazeSpace(char c) {
        if (symbolToSpaceMap == null) {
            initMapping();
        }
        return symbolToSpaceMap.get(c);
    }
 
    private static void initMapping() {
    	symbolToSpaceMap = new HashMap<Character, MazeSpace>();
        for (MazeSpace space : values()) {
        	symbolToSpaceMap.put(space.symbol, space);
        }
    }

}
