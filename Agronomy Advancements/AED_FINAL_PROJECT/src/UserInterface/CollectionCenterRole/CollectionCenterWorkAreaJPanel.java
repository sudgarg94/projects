/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CollectionCenterRole;

import Business.Enterprise.Enterprise;
import Business.Organization.CollectionCenterOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CropTestResultQueue;
import Business.WorkQueue.WorkRequest;
import UserInterface.SignUpJPanel;
import UserInterface.SystemAdminRole.ManageNetworkJPanel;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

/**
 *
 * @author Lenovo
 */
public class CollectionCenterWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CollectionCenterWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private CollectionCenterOrganization collectionCenterOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Image image2;
    
    
    public CollectionCenterWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, CollectionCenterOrganization collectionCenterOrganization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.collectionCenterOrganization = collectionCenterOrganization;
        this.enterprise = enterprise;
        this.userAccount = account;
        backgroundImage("/resources/imgs/HP2.jpg");
        populateTable();
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

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)collectionCenterJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : collectionCenterOrganization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getFarmer().getFarmerName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
        }
    }
    
    public static String[] getLatLongPositions(String address) throws Exception
  {
    int responseCode = 0;
    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
    URL url = new URL(api);
    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
    httpConnection.connect();
    responseCode = httpConnection.getResponseCode();
    if(responseCode == 200)
    {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
      Document document = builder.parse(httpConnection.getInputStream());
      XPathFactory xPathfactory = XPathFactory.newInstance();
      XPath xpath = xPathfactory.newXPath();
      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
      String status = (String)expr.evaluate(document, XPathConstants.STRING);
      if(status.equals("OK"))
      {
         expr = xpath.compile("//geometry/location/lat");
         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
         expr = xpath.compile("//geometry/location/lng");
         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
         return new String[] {latitude, longitude};
      }
      else
      {
         throw new Exception("Error from the API - response status: "+status);
      }
    }
    return null;
  }
    
     private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) 
     {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}

		return (dist);
	}
     private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
     private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        collectionCenterJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        assignToMeJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        viewRequestBtn = new javax.swing.JButton();
        senderZipcodeJTextField = new javax.swing.JTextField();
        senderAddLine2TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        plannedCropTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        senderAddL1TextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        farmerNameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ccAddL1TextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ccZipcodeJTextField1 = new javax.swing.JTextField();
        ccAddLine2TextField1 = new javax.swing.JTextField();
        calculateDistanceJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        distanceJTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setEnabled(false);

        collectionCenterJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Requested Date", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(collectionCenterJTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Collection Center Request Table");

        assignToMeJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        assignToMeJButton.setText("Assign to Me");
        assignToMeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMeJButtonActionPerformed(evt);
            }
        });

        processJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        viewRequestBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewRequestBtn.setText("View Request Details");
        viewRequestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestBtnActionPerformed(evt);
            }
        });

        senderZipcodeJTextField.setEnabled(false);

        senderAddLine2TextField.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("AddressLine 2");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Farmer's Name:");

        messageJTextField.setEnabled(false);
        messageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageJTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Message:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Planned Crop:");

        plannedCropTextField.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Address Line 1:");

        senderAddL1TextField.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Zip Code:");

        farmerNameTextField.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("AddressLine 2");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Address Line 1:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Zip Code:");

        calculateDistanceJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        calculateDistanceJButton.setText("Calculate Distance");
        calculateDistanceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateDistanceJButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Distance:");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/agronomyAdvancement.JPG"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Farmer Details");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Fill In Collection Center Location Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 1327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewRequestBtn)
                                .addGap(343, 343, 343)
                                .addComponent(assignToMeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(farmerNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(senderZipcodeJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(senderAddLine2TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(senderAddL1TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(plannedCropTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel10))
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ccAddL1TextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                                    .addComponent(ccAddLine2TextField1)
                                                    .addComponent(ccZipcodeJTextField1)))
                                            .addComponent(jLabel12)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                                .addComponent(distanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(calculateDistanceJButton)))
                                    .addComponent(messageJTextField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(processJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignToMeJButton)
                    .addComponent(viewRequestBtn))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(plannedCropTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(farmerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(senderAddL1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(ccAddL1TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(ccAddLine2TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(ccZipcodeJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(senderAddLine2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculateDistanceJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(senderZipcodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(distanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addComponent(processJButton)
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignToMeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = collectionCenterJTable.getSelectedRow();
        
        if (selectedRow < 0){            
            JOptionPane.showMessageDialog(null, "Please Select a  Row");
            return;
        }
        
        WorkRequest request = (WorkRequest)collectionCenterJTable.getValueAt(selectedRow, 0);
        if(request.getStatus().equals("Pending with Collection Center"))
        {
            request.setReceiver(userAccount);
            request.setStatus("Processing Pickup");
            populateTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Request already assigned");
        }
    }//GEN-LAST:event_assignToMeJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = collectionCenterJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        
        CropTestResultQueue request = (CropTestResultQueue)collectionCenterJTable.getValueAt(selectedRow, 0);
        if(request.getStatus().equals("Processing Pickup"))
        {
            request.setStatus("Sample Collected");
            RequestLabStudyJPanel requestLabStudyJPanel = new RequestLabStudyJPanel(userProcessContainer, request, userAccount, enterprise);
            userProcessContainer.add("requestLabStudyJPanel", requestLabStudyJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
            populateTable();
        }
        else{
                JOptionPane.showMessageDialog(null, "Please assign a valid request");
        }
        
    }//GEN-LAST:event_processJButtonActionPerformed

    private void messageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageJTextFieldActionPerformed

    private void viewRequestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = collectionCenterJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please Select a  Row");
            return;
        }
        
        CropTestResultQueue request = (CropTestResultQueue)collectionCenterJTable.getValueAt(selectedRow, 0);
        plannedCropTextField.setText(request.getPlannedCropType());
        farmerNameTextField.setText(String.valueOf(request.getSender()));
        senderAddL1TextField.setText(request.getFarmerAddressLine1());
        senderAddLine2TextField.setText(request.getFarmerAddressLine2());
        senderZipcodeJTextField.setText(String.valueOf(request.getFarmerAddressZip()));
        messageJTextField.setText(request.getMessage());
        
        
    }//GEN-LAST:event_viewRequestBtnActionPerformed

    private void calculateDistanceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateDistanceJButtonActionPerformed
        // TODO add your handling code here:
        String ccAddLine1 = ccAddL1TextField1.getText();
        String ccAddLine2 = ccAddLine2TextField1.getText();
        String ccZipCode = ccZipcodeJTextField1.getText();
        
        int selectedRow = collectionCenterJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please Select a  Row");
            return;
        }
        
        CropTestResultQueue request = (CropTestResultQueue)collectionCenterJTable.getValueAt(selectedRow, 0);
        
        try {
            String cclatLongs[] = getLatLongPositions(ccZipCode);
            String farmerlatlongs[] = request.getFarmerLatLongs();
            double latlong0 = Double.parseDouble(farmerlatlongs[0]);
            double latlong1 = Double.parseDouble(farmerlatlongs[1]);
            double latlongs0 = Double.parseDouble(cclatLongs[0]);
            double latlongs1 = Double.parseDouble(cclatLongs[1]);
            Double distance = distance(latlong0 ,latlong1, latlongs0, latlongs1, "K");
            Double roundedDistance = Math.round(distance*100.0)/100.0;
            String distanceInKm = String.valueOf(roundedDistance);
            distanceJTextField.setText(distanceInKm+" Km");
            
        } catch (Exception ex) {
            Logger.getLogger(CollectionCenterWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_calculateDistanceJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignToMeJButton;
    private javax.swing.JButton calculateDistanceJButton;
    private javax.swing.JTextField ccAddL1TextField1;
    private javax.swing.JTextField ccAddLine2TextField1;
    private javax.swing.JTextField ccZipcodeJTextField1;
    private javax.swing.JTable collectionCenterJTable;
    private javax.swing.JTextField distanceJTextField;
    private javax.swing.JTextField farmerNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JTextField plannedCropTextField;
    private javax.swing.JButton processJButton;
    private javax.swing.JTextField senderAddL1TextField;
    private javax.swing.JTextField senderAddLine2TextField;
    private javax.swing.JTextField senderZipcodeJTextField;
    private javax.swing.JButton viewRequestBtn;
    // End of variables declaration//GEN-END:variables
}
