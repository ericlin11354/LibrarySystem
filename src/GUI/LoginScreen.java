package GUI;

import GUI.RealBookInfoScreen;

/**
 * This is the JPanel for the login screen.
 *
 * @author 069949345 (Natalie)
 */
public class LoginScreen extends javax.swing.JPanel {

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
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

        welcome = new javax.swing.JLabel();
        searchByTitle = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        bookBarcode = new javax.swing.JLabel();
        barcodeGoesHere = new javax.swing.JTextField();
        scanDirectly = new javax.swing.JLabel();
        leaveReview = new javax.swing.JLabel();
        IDNumber = new javax.swing.JLabel();
        studentIDCode = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        welcome.setFont(new java.awt.Font("Lucida Fax", 0, 24)); // NOI18N
        welcome.setText("Welcome to the NHS Library Book Database!");

        searchByTitle.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        searchByTitle.setText("Search by Title:");

        bookBarcode.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        bookBarcode.setText("Book Barcode:");

        scanDirectly.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        scanDirectly.setText("Or, scan the barcode of a book directly:");

        leaveReview.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        leaveReview.setText("Want to leave a review? Scan your Student ID!");

        IDNumber.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        IDNumber.setText("ID Number:");

        searchButton.setText("Search!");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bookBarcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(barcodeGoesHere, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(welcome)
                        .addGap(19, 19, 19))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(searchByTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(IDNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentIDCode, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(leaveReview))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(scanDirectly)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchByTitle))
                .addGap(18, 18, 18)
                .addComponent(scanDirectly, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookBarcode)
                    .addComponent(barcodeGoesHere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(leaveReview)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDNumber))
                .addGap(39, 39, 39)
                .addComponent(searchButton)
                .addGap(91, 91, 91))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String title = searchBar.getText();
        String bar = barcodeGoesHere.getText();
        String id = studentIDCode.getText();
        
    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDNumber;
    private javax.swing.JTextField barcodeGoesHere;
    private javax.swing.JLabel bookBarcode;
    private javax.swing.JLabel leaveReview;
    private javax.swing.JLabel scanDirectly;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchByTitle;
    private javax.swing.JTextField studentIDCode;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
