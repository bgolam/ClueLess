/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author Chris
 */
import javax.swing.*;
import java.util.Scanner;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
public class Player{
    Scanner scan = new Scanner(System.in);
    public NoteBook noteBook = new NoteBook();
    private int[] position;
    private String name;
    private boolean justMoved;
    private boolean hasSuggested;
    private boolean movedBySuggestion;
    private String currentRoom;
    private boolean inPlay;
    private int turn;
    
    public String[] roomCards;
    public String[] suspectCards;
    public String[] weaponCards;
    int numRoomCards;
    int numSuspectCards;
    int numWeaponCards;
    
    //sets starting position based on characterIndex
    //characterIndex is saved as turn, for use in figuring out which character the player represents
    //also initializes private variables

    Player(String givenName, int characterIndex)
    {
        this.position = new int[2];
        this.name = givenName;
        this.justMoved = false;
        this.hasSuggested = false;
        this.movedBySuggestion = false;
        this.inPlay = true;
        this.turn = characterIndex;
        
        this.roomCards = new String[9];
        this.suspectCards = new String[6];
        this.weaponCards = new String[6];
        
        for(int i = 0; i < 9; i++)
        {
            if(i<6)
            {
                this.roomCards[i] = "null";
                this.suspectCards[i] = "null";
                this.weaponCards[i] = "null";
            }
            else
            {
                this.roomCards[i] = "null";
            }
        }
        this.numRoomCards = 0;
        this.numSuspectCards = 0;
        this.numWeaponCards = 0;
        
        switch(name)
        {
            case "Mrs Scarlet":
                this.position[0] = 4;
                this.position[1] = 6;
                this.currentRoom = "startScarlet";
                break;
            case "Prof Plumb":
                this.position[0] = 0;
                this.position[1] = 4;
                this.currentRoom = "startPlumb";
                break;
            case "Mrs Peacock":
                this.position[0] = 0;
                this.position[1] = 2;
                this.currentRoom = "startPeacock";
                break;
            case "Mr Green":
                this.position[0] = 2;
                this.position[1] = 0;
                this.currentRoom = "startGreen";
                break;
            case "Mrs White":
                this.position[0] = 4;
                this.position[1] = 0;
                this.currentRoom = "startWhite";
                break;
            case "Col Mustard":
                this.position[0] = 6;
                this.position[1] = 4;
                this.currentRoom = "startMustard";
                break;
        }
    }
    
    int getTurn()
    {
        return turn;
    }
    
    String getName()
    {
        return this.name;
    }
    
    void setName(String s)
    {
        this.name = s;
    }
    
    boolean getInPlay()
    {
        return this.inPlay;
    }
    
    void setInPlay(boolean b)
    {
        this.inPlay = b;
    }
    
    String getCurrentRoom()
    {
        return this.currentRoom;
    }
    
    int[] getPosition()
    {
        return this.position;
    }
    
    //checks that adjacent spaces are either rooms, or unnocupied hallways
    boolean canMove(GameBoardGui gameboard, String direction)
    {
        if(this.currentRoom.startsWith("start"))
        {
            switch(direction)
            {
                case ("right"):
                    return this.currentRoom.equals("startPlumb")||this.currentRoom.equals("startPeacock");
                case ("left"):
                    return this.currentRoom.equals("startMustard");
                case ("up"):
                    return this.currentRoom.equals("startGreen")||this.currentRoom.equals("startWhite");
                case ("down"):
                    return this.currentRoom.equals("startScarlet");
                case("passage"):
                    return false;
            }
        }
        
        switch (direction)
        {
            case ("right"):
                return (gameboard.isRoom(this.position[0]+1,this.position[1]))||(gameboard.isHallway(this.position[0]+1,this.position[1])&&!gameboard.isOccupied(this.position[0]+1,this.position[1]));
            case ("left"):
                return (gameboard.isRoom(this.position[0]-1,this.position[1]))||(gameboard.isHallway(this.position[0]-1,this.position[1])&&!gameboard.isOccupied(this.position[0]-1,this.position[1]));
            case ("up"):
                return (gameboard.isRoom(this.position[0],this.position[1]+1))||(gameboard.isHallway(this.position[0],this.position[1]+1)&&!gameboard.isOccupied(this.position[0],this.position[1]+1));
            case ("down"):
                return (gameboard.isRoom(this.position[0],this.position[1]-1))||(gameboard.isHallway(this.position[0],this.position[1]-1)&&!gameboard.isOccupied(this.position[0],this.position[1]-1));
            case("passage"):
                return gameboard.hasPassage(this.position[0],this.position[1]);
            default: 
                return false;
        }
    }
    
    //uses setPosition, moves one space in the direction given, or takes passage if direction=passage
    void move(GameBoardGui board, String direction)
    {
        switch(direction)
        {
            case("left"):
                this.setPosition(board, this.position[0]-1, this.position[1]);
                break;
            case("right"):
                this.setPosition(board, this.position[0]+1, this.position[1]);
                break;
            case("up"):
                this.setPosition(board, this.position[0], this.position[1]+1);
                break;
            case("down"):
                this.setPosition(board, this.position[0], this.position[1]-1);
                break;
            case("passage"):
                if(this.position[0]==this.position[1])
                {
                    this.setPosition(board, 6-this.position[0], 6-this.position[1]);
                    break;
                }
                else
                {
                    this.setPosition(board, this.position[1], this.position[0]);
                    break;
                }
        }
    }
    
    //moves player to given coordinates
    void setPosition(GameBoardGui board, int x, int y)
    {
        board.setOccupied(this.position[0],this.position[1],false);
        this.position[0] = x;
        this.position[1] = y;
        board.setOccupied(x,y,true);
        this.currentRoom = board.getRoom(x,y);
    }
    
    //used for what options the player has for remainder of turn
    boolean getJustMoved()
    {
        return this.justMoved;
    }
    
    void setJustMoved(boolean b)
    {
        this.justMoved = b;
    }
    
    void addRoomCard(String card)
    {
        this.roomCards[this.numRoomCards] = card;
        this.numRoomCards++;
    }
    
    void addSuspectCard(String card)
    {
        this.suspectCards[this.numSuspectCards] = card;
        this.numSuspectCards++;
    }
    
    void addWeaponCard(String card)
    {
        this.weaponCards[this.numWeaponCards] = card;
        this.numWeaponCards++;
    }

    //player can suggest if they were moved by a suggestion before turn, or if they moved into room during turn
    boolean canSuggest()
    {
        return (this.movedBySuggestion||(this.justMoved&&!this.hasSuggested)&&!this.currentRoom.equals("hallway"));
    }
    
    //gotta move suspected player to room
    //also need to move suspected weapon piece to room once that's made
    void suggest(Deck deck, Player[] dudes, int rotation)
    {
        String scene = this.currentRoom;
        
        System.out.println("Who did it?\n1: Miss Scarlet\n2: Professor Plumb\n3: Mrs. Peacock\n4: Mr. Green\n5: Mrs. White\n6: Col. Mustard");
        int suspectIndex = scan.nextInt();
        while(suspectIndex<1||suspectIndex>6)
        {
            System.out.println("Try again.");
            suspectIndex = scan.nextInt();
        }
        String suspect = deck.getSuspectCard(suspectIndex-1);
        
        
        
        
        
        //gotta move suspect to room too
        
        
        
        
        
        System.out.println("What did they do it with?\n1: Knife\n2: Rope\n3: Wrench\n4: Candlestick\n5: Revolver\n6: Lead Pipe");
        int weaponIndex = scan.nextInt();
        while(weaponIndex<1||weaponIndex>6)
        {
            System.out.println("Try again");
            weaponIndex = scan.nextInt();
        }
        String weapon = deck.getWeaponCard(weaponIndex-1);
        
        boolean cardFound = false;
        int count = 0;
        String[] foundCards = new String[3];
        foundCards[0] = "";
        foundCards[1] = "";
        foundCards[2] = "";
        
        int nextPlayer;
        if(rotation==0)
        {
            nextPlayer = dudes.length-1;
        }
        else
        {
            nextPlayer = rotation-1;
        }
        
        int index = nextPlayer;
        int failedAttempts = 0;
        while(!cardFound&&!dudes[index].getName().equals(this.name))
        {
            for(String card: dudes[index].roomCards)
            {
                if (!card.equals("null")&&card.equals(scene))
                {
                    cardFound = true;
                    foundCards[count] = card;
                    count++;
                    break;
                }
            }
            for(String card: dudes[index].suspectCards)
            {
                if (!card.equals("null")&&card.equals(suspect))
                {
                    cardFound = true;
                    foundCards[count] = card;
                    count++;
                    break;
                }
            }
            for(String card: dudes[index].weaponCards)
            {
                if (!card.equals("null")&&card.equals(weapon))
                {
                    cardFound = true;
                    foundCards[count] = card;
                    count++;
                    break;
                }
            }
            
            if(!cardFound)
            {
                if(index==0)
                {
                    index = dudes.length-1;
                }
                else index--;
                
                failedAttempts++;
                if(failedAttempts==dudes.length-1)
                    cardFound=true;
            }
        }
        if(count==1)
        {
            for(int i = 0; i < 3; i++)
            {
                if(!foundCards[i].equals(""))
                {
                    System.out.println(dudes[index].getName() + " says: I can disprove " + foundCards[i]);
                }
            }
        }
        else if (count>1)
        {
            int moreCounting = 1;
            System.out.println(dudes[index].getName() + ", which card do you want to show?");
            for(int i = 0; i < 3; i++)
            {
                if(!foundCards[i].equals(""))
                {
                    System.out.println(moreCounting + ": " + foundCards[i]);
                    moreCounting++;
                }
            }
            int choice = scan.nextInt();
            while(choice!=1&&choice!=2&&choice!=3)
            {
                System.out.println("Try again.");
                choice = scan.nextInt();
            }
            switch (choice)
            {
                case 1:
                    System.out.println(dudes[index] + " says: I can disprove " + foundCards[0]);
                    break;
                case 2:
                    System.out.println(dudes[index] + " says: I can disprove " + foundCards[1]);
                    break;
                case 3:
                    System.out.println(dudes[index] + " says: I can disprove " + foundCards[2]);
                    break;
            }
        }
        this.hasSuggested = true;
    }
    
    //used by canSuggest
    void setMovedBySuggestion(boolean b)
    {
        this.movedBySuggestion = b;
    }
    
    //used by canSuggest
    void setHasSuggested(boolean b)
    {
        this.hasSuggested = b;
    }
    
    void viewRules()
    {
        System.out.println("THIS IS WHERE RULES GO");
    }
    
    void viewCards()
    {
        System.out.println("Room Cards:");
        for(int i = 0; i < 9; i++)
        {
            if(!this.roomCards[i].equals("null"))
            {
                System.out.println(this.roomCards[i]);
            }
        }
        System.out.println("\nSuspect Cards:");
        for(int i = 0; i < 6; i++)
        {
            if(!this.suspectCards[i].equals("null"))
            {
                System.out.println(this.suspectCards[i]);
            }
        }
        System.out.println("\nWeapon Cards:");
        for(int i = 0; i < 6; i++)
        {
            if(!this.weaponCards[i].equals("null"))
            {
                System.out.println(this.weaponCards[i]);
            }
        }
    }
    
    //prompts player for guess at confidential cards
    //if the guess is right, game over and player wins
    //if the guess is wrong, player is removed from play
    boolean accuse(Deck deck)
    {
        System.out.println("Where did it happen?\n1: Conservatory\n2: Library\n3: Study\n4: Ballroom\n5: Billiard Room\n6: Hall\n7: Kitchen\n8: Dining Room\n9: Lounge");
        int roomIndex = scan.nextInt();
        while(roomIndex<1||roomIndex>9)
        {
            System.out.println("Try again.");
            roomIndex = scan.nextInt();
        }
        String room = deck.getSuspectCard(roomIndex-1);
        
        
        System.out.println("Who did it?\n1: Miss Scarlet\n2: Professor Plumb\n3: Mrs. Peacock\n4: Mr. Green\n5: Mrs. White\n6: Col. Mustard");
        int suspectIndex = scan.nextInt();
        while(suspectIndex<1||suspectIndex>6)
        {
            System.out.println("Try again.");
            suspectIndex = scan.nextInt();
        }
        String suspect = deck.getSuspectCard(suspectIndex-1);
        
        System.out.println("What did they do it with?\n1: Knife\n2: Rope\n3: Wrench\n4: Candlestick\n5: Revolver\n6: Lead Pipe");
        int weaponIndex = scan.nextInt();
        while(weaponIndex<1||weaponIndex>6)
        {
            System.out.println("Try again");
            weaponIndex = scan.nextInt();
        }
        String weapon = deck.getWeaponCard(weaponIndex-1);
        
        return room.equals(deck.getConfidentialCard(0))&&suspect.equals(deck.getConfidentialCard(1))&&weapon.equals(deck.getConfidentialCard(2));
    }
}
