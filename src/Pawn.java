public class Pawn {
    private int[] position;
    private String name;
    private String[] names = {"Miss Scarlet", "Professor Plumb", "Mrs. Peacock", "Mr. Green", "Mrs. White", "Col. Mustard"};
    
    //sets  starting position based on which character the pawn represents
    Pawn(int characterIndex)
    {
        position = new int[2];
        switch(characterIndex)
        {
            case 1:
                position[0] = 4;
                position[1] = 6;
                break;
            case 2:
                position[0] = 0;
                position[1] = 4;
                break;
            case 3:
                position[0] = 0;
                position[1] = 2;
                break;
            case 4:
                position[0] = 2;
                position[1] = 0;
                break;
            case 5:
                position[0] = 4;
                position[1] = 0;
                break;
            case 6:
                position[0] = 6;
                position[1] = 4;
                break;
        }
        name = names[characterIndex-1];
    }

    int[] getPosition()
    {
        return position;
    }

    //used for when pawn is called as a suspect in a suggestion
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
