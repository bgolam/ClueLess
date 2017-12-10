/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j40688
 */
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class AddPlayerGui extends javax.swing.JFrame {
    
    public Deck deck; //Creates deck
    private Random rand = new Random(); //Generate random numbers
    private GameBoardGui board; //Game Board to play on
    private Pawn[] pawns = new Pawn[6];//Holds pawns in game
    private int pawnCount = 0;
    public Player[] oldPlayers = new Player[6];
    
    public int turn = 0;
    public boolean turnComplete;
    public boolean gameInSession;
    public Player winner; //Declare the winner
    public Player currentPlayer;
    
    //Whether the character is a pawn or not
    private boolean[] isPawn = new boolean[6];
    
    //Counts the number of players in the game
    public int playerCount = 0;
    
    //Holds all the current players in the game
    public Player[] players = new Player[6];
    
    public void initializeDeck()
    {
        deck = new Deck();
        deck.setConfidentialCards();
        try {
        	distributeCards(); 
        } catch (Exception E) {
        	System.out.println("Add Player Before Clicking 'Start Game'");
        	System.out.println("Game Will Exit Now");
        	System.exit(0);
        }
    }

    //Distribute cards to the users randomly. 
    public void distributeCards()
    {
        int count = 0;
        int x;
        
        while (count < 8)
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
        
        while(count < 5)
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
        
        while(count < 5)
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
    
    public void initializeBoard()
    {
        board = new GameBoardGui();
    }
    
    //Creates pawns for in game use
    public void makePawns()
    {
        for(int i = 0; i < 6; i++)
        {
            if (isPawn[i])
            {
                pawns[pawnCount] = new Pawn(i + 1);
                pawnCount++;
            }
        }
    }
    
    public void startGame()
    {
        players = new Player[playerCount];
        
        for(int i = 0; i < playerCount; i++)
        {
            players[i] = oldPlayers[i];
        }
        
        initializeDeck();
        initializeBoard();
        makePawns();
        
       
        //figure out who goes first
        int min = 6;
        int first = 0;
        for(int i = 0; i < players.length; i++)
        {
            if(players[i].getTurn() < min)
            {
                min = players[i].getTurn();
                first = i;
            }
        }
        turn = first;
        
        gameInSession = true;
        turnComplete = false;
        
    }
    
    //If no players are left in play, game over with everyone losing
    //If one player is left in play, game over with them as the winner
    //NEED GUI FOR THIS
    public boolean checkForGameOver()
    {
        int weener = -1;
        int count = 0;
        
        for (int i = 0; i < players.length; i++)
        {
            if(players[i] != null)
            {
                weener = i; 
                count++;
            }
        }
        
        if (count == 0)
        {
            return true;
        }
        
        else if(count == 1)
        {
            winner = players[weener];
            return true;
        }
        
        return false;
    }
    
    public int whoseTurnIsIt(int lastPlayerIndex)
    {
        int next;
        
        if(lastPlayerIndex == 0)
        {
            next = players.length - 1;
        }
        
        else
        {
            next = lastPlayerIndex - 1;
        }
        
        return next;
    }
    
    //Gives the player options for their turn, implements choices
    
    public void turn()
    {
        turnComplete = false;
        currentPlayer = players[turn];
        currentPlayer.setJustMoved(false);
        currentPlayer.setHasSuggested(false);
        
    }
    
    public AddPlayerGui() {
        initComponents();
        
        for (int i = 0; i < 6; i ++)
        {
            isPawn[i] = true;
        }
        
        for(int i = 0; i < players.length; i++)
        {
            players[i] = new Player("-empty-", i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pickCharacter = new javax.swing.JLabel();
        scarlett = new javax.swing.JLabel();
        mustard = new javax.swing.JLabel();
        green = new javax.swing.JLabel();
        pickScarlet = new javax.swing.JButton();
        pickMustard = new javax.swing.JButton();
        pickGreen = new javax.swing.JButton();
        peacock = new javax.swing.JLabel();
        white = new javax.swing.JLabel();
        plumb = new javax.swing.JLabel();
        pickPeacock = new javax.swing.JButton();
        pickWhite = new javax.swing.JButton();
        pickPlumb = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setLocation(new java.awt.Point(600, 200));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        pickCharacter.setBackground(new java.awt.Color(0, 255, 204));
        pickCharacter.setFont(new java.awt.Font("Harrington", 0, 24)); // NOI18N
        pickCharacter.setForeground(new java.awt.Color(255, 255, 255));
        pickCharacter.setText("    PICK YOUR CHARACTER!");
        pickCharacter.setOpaque(true);

        scarlett.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Characters/Mrs Scarlet.jpg"))); // NOI18N

        mustard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Characters/Col Mustard.jpg"))); // NOI18N

        green.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Characters/Mr Green.jpg"))); // NOI18N

        pickScarlet.setBackground(new java.awt.Color(0, 51, 204));
        pickScarlet.setText("Pick");
        pickScarlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickScarletActionPerformed(evt);
            }
        });

        pickMustard.setBackground(new java.awt.Color(0, 51, 204));
        pickMustard.setText("Pick");
        pickMustard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickMustardActionPerformed(evt);
            }
        });

        pickGreen.setBackground(new java.awt.Color(0, 51, 204));
        pickGreen.setText("Pick");
        pickGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickGreenActionPerformed(evt);
            }
        });

        peacock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Characters/Mrs Peacock.jpg"))); // NOI18N

        white.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Characters/Mrs White.jpg"))); // NOI18N

        plumb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Characters/Prof Plumb.jpg"))); // NOI18N

        pickPeacock.setBackground(new java.awt.Color(0, 51, 204));
        pickPeacock.setText("Pick");
        pickPeacock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickPeacockActionPerformed(evt);
            }
        });

        pickWhite.setBackground(new java.awt.Color(0, 51, 204));
        pickWhite.setText("Pick");
        pickWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickWhiteActionPerformed(evt);
            }
        });

        pickPlumb.setBackground(new java.awt.Color(0, 51, 204));
        pickPlumb.setText("Pick");
        pickPlumb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickPlumbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scarlett)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mustard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(green))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(peacock)
                        .addGap(6, 6, 6)
                        .addComponent(white)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plumb)))
                .addGap(0, 11, Short.MAX_VALUE))
            .addComponent(pickCharacter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pickPeacock)
                .addGap(40, 40, 40)
                .addComponent(pickWhite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pickPlumb)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pickScarlet)
                .addGap(43, 43, 43)
                .addComponent(pickMustard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pickGreen)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pickCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mustard)
                    .addComponent(scarlett)
                    .addComponent(green))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pickScarlet)
                    .addComponent(pickMustard)
                    .addComponent(pickGreen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(white)
                    .addComponent(peacock)
                    .addComponent(plumb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pickPeacock)
                        .addComponent(pickWhite))
                    .addComponent(pickPlumb))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void pickScarletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickScarletActionPerformed

        oldPlayers[playerCount] = new Player("Mrs Scarlet", playerCount); //Player pcked Mrs Scarlet
        isPawn[playerCount] = false; //Real player
        pickScarlet.setEnabled(false); //Can't have two of the same
        playerCount++; //Number of real players
        this.setVisible(false); //Close picking player window
       
    }//GEN-LAST:event_pickScarletActionPerformed

    private void pickMustardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickMustardActionPerformed
  
        oldPlayers[playerCount] = new Player("Col Mustard", playerCount);
        isPawn[playerCount] = false;
        pickMustard.setEnabled(false);
  
        
        playerCount++;
        this.setVisible(false);
        
    }//GEN-LAST:event_pickMustardActionPerformed

    private void pickGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickGreenActionPerformed
        
        oldPlayers[playerCount] = new Player("Mr Green", playerCount);
        isPawn[playerCount] = false;
        pickGreen.setEnabled(false);

        
        playerCount++;
        this.setVisible(false);
         
    }//GEN-LAST:event_pickGreenActionPerformed

    private void pickPeacockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickPeacockActionPerformed

        oldPlayers[playerCount] = new Player("Mrs Peacock", playerCount);
        isPawn[playerCount] = false;
        pickPeacock.setEnabled(false);
        
        
        playerCount++;
        this.setVisible(false);
         
    }//GEN-LAST:event_pickPeacockActionPerformed

    private void pickWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickWhiteActionPerformed
   
        oldPlayers[playerCount] = new Player("Mrs White", playerCount);
        isPawn[playerCount] = false;
        pickWhite.setEnabled(false);
        
        
        playerCount++;
        this.setVisible(false);
         
    }//GEN-LAST:event_pickWhiteActionPerformed

    private void pickPlumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickPlumbActionPerformed
     
        oldPlayers[playerCount] = new Player("Prof Plumb", playerCount);
        isPawn[playerCount] = false;
        pickPlumb.setEnabled(false);
        
        playerCount++;
        this.setVisible(false);
         
    }//GEN-LAST:event_pickPlumbActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel green;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel mustard;
    private javax.swing.JLabel peacock;
    private javax.swing.JLabel pickCharacter;
    private javax.swing.JButton pickGreen;
    private javax.swing.JButton pickMustard;
    private javax.swing.JButton pickPeacock;
    private javax.swing.JButton pickPlumb;
    private javax.swing.JButton pickScarlet;
    private javax.swing.JButton pickWhite;
    private javax.swing.JLabel plumb;
    private javax.swing.JLabel scarlett;
    private javax.swing.JLabel white;
    // End of variables declaration//GEN-END:variables
}
