/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FarmerRole;

import Business.WorkQueue.CropTestResultQueue;
import Business.WorkQueue.WorkRequest;
import UserInterface.SignUpJPanel;
import UserInterface.SystemAdminRole.ManageNetworkJPanel;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class ViewResultJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewResultJPanel
     */
    private JPanel userProcessContainer;
    private CropTestResultQueue request;
    private Image image2;
    

    public ViewResultJPanel(JPanel userProcessContainer, CropTestResultQueue request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        backgroundImage("/resources/imgs/HP2.jpg");
        populateDetails();
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

    public void populateDetails()
    {
      researchResultTextField.setText(request.getMessage());
      cropTxtFld.setText(request.getPlannedCropType());
      String resolveDate = String.valueOf(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(request.getResolveDate()));
      resolveDateTextField.setText(resolveDate);
      
      //ACTUAL VALUES:
       
     actualBlkTxtFld.setText(String.valueOf(request.getActualBulkDensity()));
     actualElectricalTxtFld.setText(String.valueOf(request.getActualElectricalConductivity()));
     actualNitrateTxtFld.setText(String.valueOf(request.getActualNitrateLevel()));
     actualPhTxtFld.setText(String.valueOf(request.getActualSoilPH()));
     actualWaterTxtFld.setText(String.valueOf(request.getActualWaterContent()));
     actualOrganicCarbonTextField.setText(String.valueOf(request.getActualOrganicCarbon()));
     actualCNRatioTextField.setText(String.valueOf(request.getActualCarbonNitrogenRatio()));
     actualAluminiumSaturationTextField.setText(String.valueOf(request.getActualAluminiumSaturation()));
     actualCalciumCarbonateContentTextField.setText(String.valueOf(request.getActualCalciumCarbonateContent()));
     
     //EXPECTED VALUES:
     expectedBlkTxtFld.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedBulkDensity()));
     expectedElectricalTxtFld.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedElectricalConductivity()));
     expectedNitrateTxtFld.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedNitrateLevel()));
     expectedPhTxtFld.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedSoilPH()));
     expectedWaterTxtFld.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedWaterContent()));
     expectedOrganicCarbonTextField.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedOrganicCarbon()));
     expectedCNRatioTextField.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedCarbonNitrogenRatio()));
     expectedAluminiumSaturationTextField.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedAluminiumSaturation()));
     expectedCalciumCarbonateContentTextField.setText(String.valueOf(request.getCrop().getSoilParameter().getExpectedCalciumCarbonateContent()));
     
     
     //SETTING REMARKS:   
     pHRemarkTxtFld.setText(request.getCrop().getSoilParameter().getRemarksSoilPH());
     blkRemarkTxtFld.setText(request.getCrop().getSoilParameter().getRemarksBulkDensity());
     electricalRemarkTxtFld.setText(request.getCrop().getSoilParameter().getRemarksElectricalConductivity());
     nitrateRemarkTxtFld.setText(request.getCrop().getSoilParameter().getRemarksNitrateLevel());
     waterRemarkTxtFld.setText(request.getCrop().getSoilParameter().getRemarksWaterContent());
     organicCarbonRemarksTextField.setText(request.getCrop().getSoilParameter().getRemarksOrganicCarbon());
     carbonNitrogenlRemarkTxtFld1.setText(request.getCrop().getSoilParameter().getRemarksCarbonNitrogenRatio());
     aluminiumlRemarkTxtFld3.setText(request.getCrop().getSoilParameter().getRemarksAluminiumSaturation());
     calciumCarbRemarkTxtFld4.setText(request.getCrop().getSoilParameter().getRemarksCalciumCarbonateContent());
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actualBlkTxtFld = new javax.swing.JTextField();
        actualPhTxtFld = new javax.swing.JTextField();
        actualNitrateTxtFld = new javax.swing.JTextField();
        actualWaterTxtFld = new javax.swing.JTextField();
        actualElectricalTxtFld = new javax.swing.JTextField();
        expectedElectricalTxtFld = new javax.swing.JTextField();
        electricalRemarkTxtFld = new javax.swing.JTextField();
        blkRemarkTxtFld = new javax.swing.JTextField();
        pHRemarkTxtFld = new javax.swing.JTextField();
        nitrateRemarkTxtFld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        waterRemarkTxtFld = new javax.swing.JTextField();
        cropTxtFld = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        expectedBlkTxtFld = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        expectedPhTxtFld = new javax.swing.JTextField();
        expectedNitrateTxtFld = new javax.swing.JTextField();
        expectedWaterTxtFld = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        actualOrganicCarbonTextField = new javax.swing.JTextField();
        actualAluminiumSaturationTextField = new javax.swing.JTextField();
        actualCalciumCarbonateContentTextField = new javax.swing.JTextField();
        actualCNRatioTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        expectedOrganicCarbonTextField = new javax.swing.JTextField();
        expectedAluminiumSaturationTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        expectedCalciumCarbonateContentTextField = new javax.swing.JTextField();
        expectedCNRatioTextField = new javax.swing.JTextField();
        researchResultTextField = new javax.swing.JTextField();
        carbonNitrogenlRemarkTxtFld1 = new javax.swing.JTextField();
        aluminiumlRemarkTxtFld3 = new javax.swing.JTextField();
        calciumCarbRemarkTxtFld4 = new javax.swing.JTextField();
        organicCarbonRemarksTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        resolveDateTextField = new javax.swing.JTextField();

        actualBlkTxtFld.setEnabled(false);

        actualPhTxtFld.setEnabled(false);

        actualNitrateTxtFld.setEnabled(false);

        actualWaterTxtFld.setEnabled(false);

        actualElectricalTxtFld.setEnabled(false);

        expectedElectricalTxtFld.setEnabled(false);

        electricalRemarkTxtFld.setEnabled(false);

        blkRemarkTxtFld.setEnabled(false);

        pHRemarkTxtFld.setEnabled(false);

        nitrateRemarkTxtFld.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Bulk Density:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("pH:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nitrate Level:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Water Content:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Electrical Conductivity:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("For Crop: ");

        waterRemarkTxtFld.setEnabled(false);

        cropTxtFld.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Expected:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Remarks:");

        expectedBlkTxtFld.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Actual:");

        expectedPhTxtFld.setEnabled(false);

        expectedNitrateTxtFld.setEnabled(false);

        expectedWaterTxtFld.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        actualOrganicCarbonTextField.setEnabled(false);

        actualAluminiumSaturationTextField.setEnabled(false);

        actualCalciumCarbonateContentTextField.setEnabled(false);

        actualCNRatioTextField.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Organic Carbon:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("C/N Ratio:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Aluminium Saturation:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("CalciumCarbonate:");

        expectedOrganicCarbonTextField.setEnabled(false);
        expectedOrganicCarbonTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expectedOrganicCarbonTextFieldActionPerformed(evt);
            }
        });

        expectedAluminiumSaturationTextField.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Result:");

        expectedCalciumCarbonateContentTextField.setEnabled(false);

        expectedCNRatioTextField.setEnabled(false);

        researchResultTextField.setEnabled(false);
        researchResultTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researchResultTextFieldActionPerformed(evt);
            }
        });

        carbonNitrogenlRemarkTxtFld1.setEnabled(false);

        aluminiumlRemarkTxtFld3.setEnabled(false);

        calciumCarbRemarkTxtFld4.setEnabled(false);

        organicCarbonRemarksTextField.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Your Result Is Ready");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Date Completed");

        resolveDateTextField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel12)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(researchResultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(actualBlkTxtFld)
                                    .addComponent(actualPhTxtFld)
                                    .addComponent(actualNitrateTxtFld)
                                    .addComponent(actualElectricalTxtFld)
                                    .addComponent(actualWaterTxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(jLabel16)
                                    .addComponent(actualOrganicCarbonTextField)
                                    .addComponent(actualCNRatioTextField)
                                    .addComponent(actualAluminiumSaturationTextField)
                                    .addComponent(actualCalciumCarbonateContentTextField))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(expectedAluminiumSaturationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(expectedCNRatioTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(expectedOrganicCarbonTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(expectedBlkTxtFld, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(expectedPhTxtFld, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(expectedNitrateTxtFld, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(expectedElectricalTxtFld, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(expectedWaterTxtFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                                    .addComponent(expectedCalciumCarbonateContentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resolveDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                            .addComponent(carbonNitrogenlRemarkTxtFld1)
                            .addComponent(electricalRemarkTxtFld)
                            .addComponent(pHRemarkTxtFld)
                            .addComponent(nitrateRemarkTxtFld)
                            .addComponent(blkRemarkTxtFld)
                            .addComponent(waterRemarkTxtFld)
                            .addComponent(calciumCarbRemarkTxtFld4)
                            .addComponent(organicCarbonRemarksTextField)
                            .addComponent(aluminiumlRemarkTxtFld3))
                        .addGap(419, 419, 419))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(28, 28, 28)
                                .addComponent(cropTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cropTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(blkRemarkTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pHRemarkTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(nitrateRemarkTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(waterRemarkTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(electricalRemarkTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(organicCarbonRemarksTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(carbonNitrogenlRemarkTxtFld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(aluminiumlRemarkTxtFld3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(calciumCarbRemarkTxtFld4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(expectedBlkTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(expectedPhTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(expectedNitrateTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(expectedWaterTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(expectedElectricalTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualBlkTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualPhTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualNitrateTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualWaterTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualElectricalTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(actualOrganicCarbonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expectedOrganicCarbonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(actualCNRatioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(expectedCNRatioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(actualAluminiumSaturationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(expectedAluminiumSaturationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(actualCalciumCarbonateContentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expectedCalciumCarbonateContentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(researchResultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(resolveDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addGap(0, 141, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void researchResultTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_researchResultTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_researchResultTextFieldActionPerformed

    private void expectedOrganicCarbonTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expectedOrganicCarbonTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expectedOrganicCarbonTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actualAluminiumSaturationTextField;
    private javax.swing.JTextField actualBlkTxtFld;
    private javax.swing.JTextField actualCNRatioTextField;
    private javax.swing.JTextField actualCalciumCarbonateContentTextField;
    private javax.swing.JTextField actualElectricalTxtFld;
    private javax.swing.JTextField actualNitrateTxtFld;
    private javax.swing.JTextField actualOrganicCarbonTextField;
    private javax.swing.JTextField actualPhTxtFld;
    private javax.swing.JTextField actualWaterTxtFld;
    private javax.swing.JTextField aluminiumlRemarkTxtFld3;
    private javax.swing.JTextField blkRemarkTxtFld;
    private javax.swing.JTextField calciumCarbRemarkTxtFld4;
    private javax.swing.JTextField carbonNitrogenlRemarkTxtFld1;
    private javax.swing.JTextField cropTxtFld;
    private javax.swing.JTextField electricalRemarkTxtFld;
    private javax.swing.JTextField expectedAluminiumSaturationTextField;
    private javax.swing.JTextField expectedBlkTxtFld;
    private javax.swing.JTextField expectedCNRatioTextField;
    private javax.swing.JTextField expectedCalciumCarbonateContentTextField;
    private javax.swing.JTextField expectedElectricalTxtFld;
    private javax.swing.JTextField expectedNitrateTxtFld;
    private javax.swing.JTextField expectedOrganicCarbonTextField;
    private javax.swing.JTextField expectedPhTxtFld;
    private javax.swing.JTextField expectedWaterTxtFld;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nitrateRemarkTxtFld;
    private javax.swing.JTextField organicCarbonRemarksTextField;
    private javax.swing.JTextField pHRemarkTxtFld;
    private javax.swing.JTextField researchResultTextField;
    private javax.swing.JTextField resolveDateTextField;
    private javax.swing.JTextField waterRemarkTxtFld;
    // End of variables declaration//GEN-END:variables
}
