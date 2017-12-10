/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Chris
 */
public class GameBoard {
    
    //gameboard implemented as matrix
    //(0,0) represents bottem left space
    private static String[][] boardMatrix;
    private static boolean[][] occupancyMatrix;
    
    //sets each coordinate on the board
    GameBoard()
    {
        boardMatrix = new String[7][7];
        boardMatrix[1][1] = "Conservatory";
        boardMatrix[1][3] = "Library";
        boardMatrix[1][5] = "Study";
        boardMatrix[3][1] = "Ballroom";
        boardMatrix[3][3] = "Billiard Room";
        boardMatrix[3][5] = "Hall";
        boardMatrix[5][1] = "Kitchen";
        boardMatrix[5][3] = "Dining Room";
        boardMatrix[5][5] = "Lounge";
        
        boardMatrix[0][0] = "null";
        boardMatrix[0][1] = "null";
        boardMatrix[0][3] = "null";
        boardMatrix[0][5] = "null";
        boardMatrix[0][6] = "null";
        boardMatrix[6][0] = "null";
        boardMatrix[6][1] = "null";
        boardMatrix[6][2] = "null";
        boardMatrix[6][3] = "null";
        boardMatrix[6][5] = "null";
        boardMatrix[6][6] = "null";
        
        boardMatrix[0][0] = "null";
        boardMatrix[1][0] = "null";
        boardMatrix[3][0] = "null";
        boardMatrix[5][0] = "null";
        boardMatrix[6][0] = "null";
        boardMatrix[0][6] = "null";
        boardMatrix[1][6] = "null";
        boardMatrix[2][6] = "null";
        boardMatrix[3][6] = "null";
        boardMatrix[5][6] = "null";
        boardMatrix[6][6] = "null";
        
        boardMatrix[2][2] = "null";
        boardMatrix[2][4] = "null";
        boardMatrix[4][2] = "null";
        boardMatrix[4][4] = "null";
        
        
        boardMatrix[2][1] = "hallway";
        boardMatrix[2][3] = "hallway";
        boardMatrix[2][5] = "hallway";
        boardMatrix[4][1] = "hallway";
        boardMatrix[4][3] = "hallway";
        boardMatrix[4][5] = "hallway";
        boardMatrix[1][2] = "hallway";
        boardMatrix[1][4] = "hallway";
        boardMatrix[3][2] = "hallway";
        boardMatrix[3][4] = "hallway";
        boardMatrix[5][2] = "hallway";
        boardMatrix[5][4] = "hallway";
        
        boardMatrix[0][2] = "startPeacock";
        boardMatrix[0][4] = "startPlumb";
        boardMatrix[2][0] = "startGreen";
        boardMatrix[4][0] = "startWhite";
        boardMatrix[6][4] = "startMustard";
        boardMatrix[4][6] = "startScarlet";
        
        occupancyMatrix = new boolean[7][7];
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                occupancyMatrix[i][j] = false;
            }
        }
        
        occupancyMatrix[0][2] = true;
        occupancyMatrix[0][4] = true;
        occupancyMatrix[2][0] = true;
        occupancyMatrix[4][0] = true;
        occupancyMatrix[6][4] = true;
        occupancyMatrix[4][6] = true;
    }
    
    boolean isHallway(int x, int y)
    {
        return boardMatrix[x][y].equals("hallway");
    }
    
    boolean isRoom(int x, int y)
    {
        switch(boardMatrix[x][y])
        {
            case ("Study"):
                return true;
            case ("Library"):
                return true;   
            case ("Conservatory"):
                return true;
            case ("Hall"):
                return true;
            case ("Billiard Room"):
                return true;
            case ("Ballroom"):
                return true;
            case ("Lounge"):
                return true;
            case ("Dining Room"):
                return true;
            case ("Kitchen"):
                return true;
            default:
                return false;
        }
    }
    
    boolean isOccupied(int x, int y)
    {
        return occupancyMatrix[x][y];
    }
    
    void setOccupied(int x, int y, boolean b)
    {
        occupancyMatrix[x][y] = b;
    }
    
    boolean hasPassage(int x, int y)
    {
        return(x==1||x==5)&&(y==1||y==5);
    }
    
    String getRoom(int x, int y)
    {
        return boardMatrix[x][y];
    }
}
