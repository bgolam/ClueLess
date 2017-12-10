/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author J40688
 */
public class SuggestGui extends javax.swing.JFrame {

    private String picture;
    
    String character;
    String room;
    String weapon;
    String deck[];
    public SuggestGui() {
        
        deck = TurnGui.addPlayer1.deck.getConfidentialCards();
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

        jPanel1 = new javax.swing.JPanel();
        personImageSuggest = new javax.swing.JLabel();
        characterBoxsuggest = new javax.swing.JComboBox<>();
        roomImageSuggest = new javax.swing.JLabel();
        roomBoxsuggest = new javax.swing.JComboBox<>();
        weaponImagesuggest = new javax.swing.JLabel();
        weaponBoxsuggest = new javax.swing.JComboBox<>();
        suggest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        personImageSuggest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Characters/Col Mustard.jpg"))); // NOI18N

        characterBoxsuggest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Col Mustard", "Mrs Scarlet", "Mr Green", "Mrs Peacock", "Mrs White", "Prof Plumb" }));
        characterBoxsuggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                characterBoxsuggestActionPerformed(evt);
            }
        });

        roomImageSuggest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rooms/Ballroom.jpg"))); // NOI18N

        roomBoxsuggest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ballroom", "Billiard Room", "Conservatory", "Dining Room", "Hall", "Kitchen", "Library", "Lounge", "Study" }));
        roomBoxsuggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomBoxsuggestActionPerformed(evt);
            }
        });

        weaponImagesuggest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Weapons/Candle Stick.jpg"))); // NOI18N

        weaponBoxsuggest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Candle Stick", "Knife", "Lead Pipe", "Revolver", "Rope", "Wrench" }));
        weaponBoxsuggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weaponBoxsuggestActionPerformed(evt);
            }
        });

        suggest.setText("Suggest");
        suggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suggestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(personImageSuggest, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roomImageSuggest, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(characterBoxsuggest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roomBoxsuggest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weaponBoxsuggest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weaponImagesuggest, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(suggest, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roomImageSuggest)
                    .addComponent(personImageSuggest)
                    .addComponent(weaponImagesuggest))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(characterBoxsuggest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomBoxsuggest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weaponBoxsuggest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(suggest, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void characterBoxsuggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_characterBoxsuggestActionPerformed
        picture = (String)characterBoxsuggest.getSelectedItem();
        personImageSuggest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Characters/" + picture + ".jpg")));
    }//GEN-LAST:event_characterBoxsuggestActionPerformed

    private void roomBoxsuggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomBoxsuggestActionPerformed
        picture = (String)roomBoxsuggest.getSelectedItem();
        roomImageSuggest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rooms/" + picture + ".jpg")));
    }//GEN-LAST:event_roomBoxsuggestActionPerformed

    private void weaponBoxsuggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weaponBoxsuggestActionPerformed
       picture = (String)weaponBoxsuggest.getSelectedItem();
       weaponImagesuggest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Weapons/" + picture + ".jpg")));
    }//GEN-LAST:event_weaponBoxsuggestActionPerformed

    private void suggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suggestActionPerformed
        character = (String)characterBoxsuggest.getSelectedItem();
        room = (String)roomBoxsuggest.getSelectedItem();
        weapon = (String)weaponBoxsuggest.getSelectedItem();

        if(room.equals(deck[0]) && character.equals(deck[1]) && weapon.equals(deck[2]))
        {
            Winner winner = new Winner(TurnGui.addPlayer1);
            winner.setVisible(true);
        }
        
        else
        {
            WrongAnswer wrong = new WrongAnswer();
            wrong.setVisible(true);
            wrong.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setVisible(false);
            
        }
    }//GEN-LAST:event_suggestActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> characterBoxsuggest;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel personImageSuggest;
    private javax.swing.JComboBox<String> roomBoxsuggest;
    private javax.swing.JLabel roomImageSuggest;
    private javax.swing.JButton suggest;
    private javax.swing.JComboBox<String> weaponBoxsuggest;
    private javax.swing.JLabel weaponImagesuggest;
    // End of variables declaration//GEN-END:variables
}
