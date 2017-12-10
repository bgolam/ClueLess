/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author musa-
 */
public class MainMenuGui extends javax.swing.JFrame {

    public AddPlayerGui addPlayer1 = new AddPlayerGui();
    public Rules rules1 = new Rules();
    public GameBoardGui gameBoard = new GameBoardGui();
    
    public MainMenuGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageHolder = new javax.swing.JPanel();
        gameImage = new javax.swing.JLabel();
        buttonHolder = new javax.swing.JPanel();
        addPlayer = new javax.swing.JButton();
        viewRules = new javax.swing.JButton();
        startGame = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 100));

        gameImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ClueGame.jpg"))); // NOI18N

        javax.swing.GroupLayout imageHolderLayout = new javax.swing.GroupLayout(imageHolder);
        imageHolder.setLayout(imageHolderLayout);
        imageHolderLayout.setHorizontalGroup(
            imageHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        imageHolderLayout.setVerticalGroup(
            imageHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        buttonHolder.setBackground(new java.awt.Color(0, 0, 0));

        addPlayer.setBackground(new java.awt.Color(0, 0, 0));
        addPlayer.setFont(new java.awt.Font("Bernard MT Condensed", 0, 18)); // NOI18N
        addPlayer.setForeground(new java.awt.Color(0, 50, 255));
        addPlayer.setText("Add Player");
        addPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerActionPerformed(evt);
            }
        });

        viewRules.setBackground(new java.awt.Color(0, 0, 0));
        viewRules.setFont(new java.awt.Font("Bernard MT Condensed", 0, 18)); // NOI18N
        viewRules.setForeground(new java.awt.Color(0, 50, 255));
        viewRules.setText("View Rules");
        viewRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRulesActionPerformed(evt);
            }
        });

        startGame.setBackground(new java.awt.Color(0, 0, 0));
        startGame.setFont(new java.awt.Font("Bernard MT Condensed", 0, 18)); // NOI18N
        startGame.setForeground(new java.awt.Color(0, 50, 255));
        startGame.setText("Start Game");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(0, 0, 0));
        exit.setFont(new java.awt.Font("Bernard MT Condensed", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 50, 255));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonHolderLayout = new javax.swing.GroupLayout(buttonHolder);
        buttonHolder.setLayout(buttonHolderLayout);
        buttonHolderLayout.setHorizontalGroup(
            buttonHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonHolderLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(addPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewRules)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonHolderLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addPlayer, exit, startGame, viewRules});

        buttonHolderLayout.setVerticalGroup(
            buttonHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonHolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewRules)
                    .addComponent(startGame)
                    .addComponent(exit))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        buttonHolderLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addPlayer, exit, startGame, viewRules});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void viewRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRulesActionPerformed
        
        rules1.setVisible(true);
        rules1.setDefaultCloseOperation(HIDE_ON_CLOSE);
       
    }//GEN-LAST:event_viewRulesActionPerformed

    private void addPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerActionPerformed

       addPlayer1.setVisible(true);
       addPlayer1.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_addPlayerActionPerformed

    public AddPlayerGui player()
    {
        return addPlayer1; 
    }
    
    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameActionPerformed
    
  
        this.setVisible(false);
        
        
        TurnGui turn = new TurnGui(addPlayer1);
       
   
    }//GEN-LAST:event_startGameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        MainMenuGui mainMenu = new MainMenuGui();
        mainMenu.setVisible(true);
      
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayer;
    private javax.swing.JPanel buttonHolder;
    private javax.swing.JButton exit;
    private javax.swing.JLabel gameImage;
    private javax.swing.JPanel imageHolder;
    private javax.swing.JButton startGame;
    private javax.swing.JButton viewRules;
    // End of variables declaration//GEN-END:variables
}
