import java.util.Scanner;
import java.util.Random;
public class ClueLess {

    static String[] characters = {"Mrs Scarlet", "Professor Plumb", "Mrs. Peacock", "Mr. Green", "Mrs. White", "Col. Mustard"};
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static GameBoardGui board;
    static Deck deck;
    static String[] playerList;
    static Player[] players;
    static Player winner;
    static int playerCount;
    static Player currentPlayer;
    static boolean[] isPawn;
    static Pawn[] pawns;
    static int pawnCount;
    static int turn;
    static boolean turnComplete;
    static boolean gameInSession;
    
    //starts up game lobby
    //options are add player, view rules, start game, exit
    static void gameLobby()
    {
        boolean inMenu = true;
        playerList = new String[6];
        players = new Player[6];
        isPawn = new boolean[6];
        pawns = new Pawn[6];
        playerCount = 0;
        pawnCount = 0;
        
        for(int i = 0; i < 6; i++)
        {
            isPawn[i] = true;
            playerList[i] = "-empty-";
        }
  
        while(inMenu)
        {
            System.out.println("Players");
            for(int i = 0; i < 6; i++)
            {
                System.out.println((i+1) + ": " + playerList[i]);
            }
        
            System.out.println("\nMenu\n1: Add Player\n2: View Rules\n3: Start Game\n4: Exit");
        
            int input = scan.nextInt();
            
            while(input<1||input>4)
            {
                System.out.println("Try again.");
                input = scan.nextInt();
            }
            
            switch (input)
            {
                case 1:
                    addPlayer();
                    break;
                case 2:
                    System.out.println("THIS IS WHERE RULES GO");
                    System.out.println("Return to menu? (y)");
                    String in = scan.next();
                    String playerName = "default";
                    while(!in.equals("y"))
                    {
                        System.out.println("THIS IS WHERE RULES GO");
                        System.out.println("Return to menu? (y)");
                        in = scan.next();
                    }
                    if (in.equals("y"))
                    {
                        break;
                    }
                    break;
                case 3: 
                    if(playerCount==0)
                    {
                        System.out.println("You didn't even pick a character, dummy");
                        System.exit(0);
                    }
                    inMenu = false;
                    Player[] oldPlayers = players;
                    players = new Player[playerCount];
                    for(int i = 0; i < playerCount; i++)
                    {
                        players[i] = oldPlayers[i];
                    }
                    startGame();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
    
    //adds player to game
    //unused characters are saved as pawns to be used during the game
    static void addPlayer()
    {
        System.out.println("Pick a character");
        for(int i = 0; i < 6; i++)
        {
            if (isPawn[i]==true)
                {
                    System.out.println((i+1) + ": " + characters[i]);    
                }
        }
        int decision = scan.nextInt()-1;
        while(decision<0||decision>5 || isPawn[decision]==false)
        {
            System.out.println("Try again.");
            decision = scan.nextInt()-1;
        }
        System.out.println("Want to name your character? (y/n)");
        String input = scan.next();
        String playerName = "default";
        while(!input.equals("y")&&!input.equals("n"))
        {
            System.out.println("y / n");
            input = scan.next();
        }
        if (input.equals("y"))
        {
            System.out.println("What do you want to name your character?");
            scan.nextLine();
            playerName = scan.nextLine();
        }
        else if(input.equals("n"))
        {
            playerName = characters[decision];
        }
        playerList[playerCount] = playerName;
        players[playerCount] = new Player(playerName, decision+1);
        playerCount++;
        isPawn[decision] = false;
    }
    
    //Creates an instance of the deck, sets confidential cards, gives cards to players
    static void initializeDeck()
    {
        deck = new Deck();
        deck.setConfidentialCards();
        distributeCards();
    }
    
    //even splits remaining 18 cards amongst players
    //randomly chosen to give to each player
    static void distributeCards()
    {
        int count = 0;
        int x;
        while(count<8)
        {
            x = rand.nextInt(9);
            if(!deck.getRoomCard(x).equals("null"))
            {
                players[count%playerCount].addRoomCard(deck.getRoomCard(x));
                count++;
                deck.removeRoomCard(x);
            }
        }
        count = 0;
        while(count<5)
        {
            x = rand.nextInt(6);
            if(!deck.getSuspectCard(x).equals("null"))
            {
                players[count%playerCount].addSuspectCard(deck.getSuspectCard(x));
                count++;
                deck.removeSuspectCard(x);
            }
        }
        count = 0;
        while(count<5)
        {
            x = rand.nextInt(6);
            if(!deck.getWeaponCard(x).equals("null"))
            {
                players[count%playerCount].addWeaponCard(deck.getWeaponCard(x));
                count++;
                deck.removeWeaponCard(x);
            }
        }
    }
    
    //creates an instance of the gameboard, for player movement
    static void initializeBoard()
    {
        board = new GameBoardGui();
    }
    
    //makes pawns out of unused characters
    static void makePawns()
    {
        for(int i = 0; i < 6; i++)
        {
            if (isPawn[i])
            {
                pawns[pawnCount] = new Pawn(i+1);
                pawnCount++;
            }
        }
    }
    
    //need makeWeaponPieces thing
    
    //does the initialzation stuff
    //decides which player is going first, and starts turn rotation
    static void startGame()
    {
        initializeDeck();
        initializeBoard();
        makePawns();
        
        //figure out who goes first
        int min = 6;
        int first = 0;
        for(int i = 0; i < players.length; i++)
        {
            if (players[i].getTurn()<min)
            {
                min = players[i].getTurn();
                first = i;
            }
        }
        turn = first;
        
        gameInSession = true;
        turnComplete = false;
    }
    
    //if no players are left in play, game over with eveyone losing
    //if one player is left in play, game over with them as the winner
    static boolean checkForGameOver()
    {
        int weener = -1;
        int count = 0;
        for(int i = 0; i < players.length; i++)
        {
            if(players[i]!=null)
            {
                weener = i;
                count++;
            }
        }
        if(count==0)
            return true;
        else if(count==1)
        {
            winner = players[weener];
            return true;
        }
        return false;
    }
    
    //increments turn rotation
    static int whoseTurnIsIt(int lastPlayerIndex)
    {
        int next;
        if(lastPlayerIndex==0)
        {
            next = players.length-1;
        }
        else
        {
            next = lastPlayerIndex-1;
        }
        
        return next;
    }
    
    //gives player options for their turn, implements choices
    static void turn()
    {
        turnComplete = false;
        currentPlayer = players[turn];
        currentPlayer.setJustMoved(false);
        currentPlayer.setHasSuggested(false);
        while(!turnComplete)
        {
            System.out.println("\nIt is " + currentPlayer.getName() + "'s turn.");
            System.out.println("You are in the " + currentPlayer.getCurrentRoom());
            System.out.println("1: View Rules\n2: View Cards\n3: Accuse\n4: End Turn");
            
            String[] options = new String[9];
            options[0] = "Rules";
            options[1] = "Cards";
            options[2] = "Accuse";
            options[3] = "End";
            
            int count = 4;
            if(currentPlayer.canSuggest())
            {
                System.out.println(count+1 + ": Make a Suggestion");
                options[4] = "Suggest";
                count++;
            }
            currentPlayer.setMovedBySuggestion(false);
            
            if(!currentPlayer.getJustMoved())
            {
                if(currentPlayer.canMove(board, "left"))
                {
                    System.out.println(count+1 + ": Move Left");
                    options[count] = "left";
                    count++;
                }
                if(currentPlayer.canMove(board, "right"))
                {
                    System.out.println(count+1 + ": Move Right");
                    options[count] = "right";
                    count++;
                }
                if(currentPlayer.canMove(board, "up"))
                {
                    System.out.println(count+1 + ": Move Up");
                    options[count] = "up";
                    count++;
                }
                if(currentPlayer.canMove(board, "down"))
                {
                    System.out.println(count+1 + ": Move Down");
                    options[count] = "down";
                    count++;
                }
                if(currentPlayer.canMove(board, "passage"))
                {
                    System.out.println(count+1 + ": Take the Secret Passage");
                    options[count] = "passage";
                    count++;
                }
            }
            
            int input = scan.nextInt();
            while (input < 1 || input > count+1)
            {
                System.out.println("Try again:");
                input = scan.nextInt();
            }
            switch(options[input-1])
            {
                case "Rules":
                    currentPlayer.viewRules();
                    break;
                case "Cards":
                    currentPlayer.viewCards();
                    break;
                case "Accuse":
                    if(currentPlayer.accuse(deck))
                    {
                        gameInSession = false;
                        winner = currentPlayer;
                    }
                    else
                    {
                        currentPlayer.setInPlay(false);
                    }
                    turnComplete = true;
                    break;
                case "End":
                    turnComplete = true;
                    break;
                case "Suggest": 
                    currentPlayer.suggest(deck, players, turn);
                    turnComplete = true;
                    break;
                case "left":
                    currentPlayer.move(board, "left");
                    currentPlayer.setJustMoved(true);
                    break;
                case "right":
                    currentPlayer.move(board, "right");
                    currentPlayer.setJustMoved(true);
                    break;
                case "up":
                    currentPlayer.move(board, "up");
                    currentPlayer.setJustMoved(true);
                    break;
                case "down":
                    currentPlayer.move(board, "down");
                    currentPlayer.setJustMoved(true);
                    break;
                case "passage":
                    currentPlayer.move(board, "passage");
                    currentPlayer.setJustMoved(true);
                    break;
            }
        }
    }
    
    //start game lobby
    //eventually someone picks start game from the game lobby, which sets gameInSession = true
    //while gameInSession, player takes a turn, game checks for winner, next player takes turn, etc
    //if someone makes a correct accusation or everyone is out of play, gameInSession = false
    public static void main(String[] args) {
        
        gameLobby();
        while(gameInSession)
        {
            turn();
            
            if(checkForGameOver())
                gameInSession = false;
            else
                turn = whoseTurnIsIt(turn);
        }
        
        if(winner==null)
        {
            System.out.println("Y'all are bad at clue.");
        }
        else 
        {
            System.out.println("Game Over! " + winner.getName() + " Wins!");
        }
    }
    
}
