/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MarketRole;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CropTestResultQueue;
import Business.WorkQueue.MarketOrder;
import Business.WorkQueue.MarketWorkRequest;
import UserInterface.SignUpJPanel;
import UserInterface.SystemAdminRole.ManageNetworkJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author prash
 */
public class RequestMarketJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestMarketJPanel
     */
    private JPanel userProcessContainer;
    private MarketWorkRequest request;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Image image2;

    public RequestMarketJPanel(JPanel userProcessContainer, MarketWorkRequest request, UserAccount userAccount, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        backgroundImage("/resources/imgs/HP2.jpg");
    }
    
    private void backgroundImage(String str){
        try {
            BufferedImage image1 = ImageIO.read(ManageNetworkJPanel.class.getResource(str));
            image2 = image1.getScaledInstance(1200,800,Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            Logger.getLogger(SignUpJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the background image.
    g.drawImage(image2, 0, 0, this);
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        vendorAddL1TextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        vendorNameTxtField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        vendorAddLine2TextField = new javax.swing.JTextField();
        vendorZipcodeJTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        vendorContactJTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        vendorRemarksJTextArea = new javax.swing.JTextArea();
        submitJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        orderQuantityTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Address Line2:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Zip Code:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Address Line1:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Buyer's  Name:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Please Fill In The Below Details");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Contact No:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Remarks(if any)");

        vendorRemarksJTextArea.setColumns(20);
        vendorRemarksJTextArea.setRows(5);
        jScrollPane2.setViewportView(vendorRemarksJTextArea);

        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submitJButton.setText("Place Order");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Order Quantity(kg)");

        orderQuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderQuantityTextFieldActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/agronomyAdvancement.JPG"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 1327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(backJButton)
                        .addGap(244, 244, 244)
                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(orderQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(vendorAddLine2TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(vendorAddL1TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(vendorZipcodeJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(vendorContactJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(vendorNameTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(195, 195, 195)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(vendorNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendorAddL1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(vendorAddLine2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(vendorZipcodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(vendorContactJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitJButton)
                    .addComponent(backJButton))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MarketWorkAreaJPanel marketWorkAreaJPanel = (MarketWorkAreaJPanel) component;
        marketWorkAreaJPanel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        try
        {
            String vendorName = vendorNameTxtField.getText();
            if(vendorName.length()==0){
                JOptionPane.showMessageDialog(null, "Please Enter Vendor's Name");
                return;
            }
            String vendorAddressLine1 = vendorAddL1TextField.getText();
            if(vendorAddressLine1.length()==0){
                JOptionPane.showMessageDialog(null, "Please Enter Line 1");
                return;
            }
            String vendorAddressLine2 = vendorAddLine2TextField.getText();
            if(vendorAddressLine2.length()==0){
                JOptionPane.showMessageDialog(null, "Please Enter Line 2");
                return;
            }
            int  vendorZipCode= Integer.parseInt(vendorZipcodeJTextField.getText());
            long vendorContact = Long.parseLong(vendorContactJTextField.getText());
            String vendorRemarks = vendorRemarksJTextArea.getText();
            if(vendorRemarks.length()==0){
                JOptionPane.showMessageDialog(null, "Please Enter Remarks");
                return;
            }
            int quantity = Integer.parseInt(orderQuantityTextField.getText());
            
            if(quantity>request.getQuantity()){
                
                JOptionPane.showMessageDialog(null, "Current Available Quantity is: "+request.getQuantity());
            }
          else{
                
            MarketOrder order = request.getMarketOrderDirectory().addOrder();
            
            order.setBuyer(userAccount);
            order.setBuyerAddressLine1(vendorAddressLine1);
            order.setBuyerAddressLine2(vendorAddressLine2);
            order.setBuyerContactInfo(vendorContact);
            order.setBuyerZipcode(vendorZipCode);
            order.setBuyerRemarks(vendorRemarks);
            order.setOrderQuantity(quantity);
            
            order.setDateOrdered(new Date());
            
            request.setQuantity(request.getQuantity()-quantity);
            
            //Work
            if(request.getQuantity()==0){
                request.setStatus("Completed");
                }
            }
            JOptionPane.showMessageDialog(null, "Order Submitted! Farmer Is Notified");
            vendorNameTxtField.setText("");
            vendorAddL1TextField.setText("");
            vendorAddLine2TextField.setText("");
            vendorZipcodeJTextField.setText("");
            vendorContactJTextField.setText("");
            vendorRemarksJTextArea.setText("");
            orderQuantityTextField.setText("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please Make Valid Entries!!");
        }
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void orderQuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderQuantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderQuantityTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField orderQuantityTextField;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField vendorAddL1TextField;
    private javax.swing.JTextField vendorAddLine2TextField;
    private javax.swing.JTextField vendorContactJTextField;
    private javax.swing.JTextField vendorNameTxtField;
    private javax.swing.JTextArea vendorRemarksJTextArea;
    private javax.swing.JTextField vendorZipcodeJTextField;
    // End of variables declaration//GEN-END:variables
}