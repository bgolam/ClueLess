/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
public class WeaponPiece {
    private int[] position;
    private String name;

    //needs set starting positions
    //one weapon in each peripheral room, probably
    
    
    int[] getPosition()
    {
        return position;
    }

    //to move weapon piece when used in suggestion
    void setPosition(int x, int y)
    {
        position[0] = x;
        position[1] = y;
    }
    
    String getName()
    {
        return name;
    }
    
    void setName(String s)
    {
        name = s;
    }
}