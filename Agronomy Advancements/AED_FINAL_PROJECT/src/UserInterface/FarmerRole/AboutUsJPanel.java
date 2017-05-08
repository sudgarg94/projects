/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FarmerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FarmerOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.SignUpJPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author kkgarg
 */
public class AboutUsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AboutUsJPanel
     */
    private JPanel userProcessContainer;
    private FarmerOrganization farmerOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private BufferedImage image1;
    private Image image2;
    
    public AboutUsJPanel(JPanel userProcessContainer, UserAccount account, FarmerOrganization farmerOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.farmerOrganization = farmerOrganization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        this.setSize(1200, 800);
        backgroundImage("/resources/imgs/HP2.jpg");
        settingText();
        //try1();
    }
    private void backgroundImage(String str)
    {
        try {
            image1 = ImageIO.read(AboutUsJPanel.class.getResource(str));
            image2 = image1.getScaledInstance(1200,800,Image.SCALE_SMOOTH);
        }
        catch (IOException ex) 
            {
                Logger.getLogger(SignUpJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

        public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            // Draw the background image.
            g.drawImage(image2, 0, 0, this);
        }
        
        public void try1()
        {
        final String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eu nulla urna. Donec sit amet risus nisl, a porta enim. Quisque luctus, ligula eu scelerisque gravida, tellus quam vestibulum urna, ut aliquet sapien purus sed erat. Pellentesque consequat vehicula magna, eu aliquam magna interdum porttitor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed sollicitudin sapien non leo tempus lobortis. Morbi semper auctor ipsum, a semper quam elementum a. Aliquam eget sem metus.";
        final String html1 = "<html><body style='width: ";
        final String html2 = "px'>";

        Runnable r = new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(
                        null, new JLabel(html1 + "200" + html2 + s));
                JOptionPane.showMessageDialog(
                        null, new JLabel(html1 + "300" + html2 + s));
            }
        };
        SwingUtilities.invokeLater(r);
        }
        
        private void settingText(){
            final String st = "Agriculture is the backbone of the Indian Economy\"- said Mahatma Gandhi six decades ago. "
                    + "Even today, the situation is still the same, with almost the entire economy being sustained by agriculture, which is the mainstay of the villages. "
                    + "It contributes 16% of the overall GDP and accounts for employment of approximately 52% of the Indian population. "
                    + "Rapid growth in agriculture is essential not only for self-reliance but also to earn valuable foreign exchange. " 
                    + "Indian farmers are second to none in production and productivity despite of the fact that millions are marginal and small farmers. "
                    + "They adopt improved agriculture technology as efficiently as farmers in developed countries. "
                    + "It is felt that with provision of timely and adequate inputs such as fertilizers, seeds, pesticides and by making available affordable agricultural credit/crop insurance, "
                    + "Indian farmers are going to ensure food and nutritional security to the Nation. It is envisaged to make available relevant information and services to the farming community and"
                    + "private sector through the use of information and communication technologies, to supplement the existing delivery channels provided for by the department. "
                    + "Farmers’ Portal is an endeavour in this direction to create one stop shop for meeting all informational needs relating to Agriculture, Animal Husbandry and Fisheries sectors production, sale/storage of an Indian farmer. "
                    + "With this Indian Farmer will not be required to sift through maze of websites created for specific purposes. Once in the Farmers’ Portal, a farmer will be able to get all relevant information on specific subjects around "
                    + "his village/block/district or state. This information will be delivered in the form of text, SMS, email and audio/video in the language he or she understands. These levels can be easily reached through the Map of India "
                    + "placed on the Home page. Farmers will also be able to ask specific queries as well as give valuable feedback through the Feedback module specially developed for the purpose.";
            //String myString = "Hello. How are you ? \n I am doing well \n next line \n again something \n again";
            //final String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eu nulla urna. Donec sit amet risus nisl, a porta enim. Quisque luctus, ligula eu scelerisque gravida, tellus quam vestibulum urna, ut aliquet sapien purus sed erat. Pellentesque consequat vehicula magna, eu aliquam magna interdum porttitor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed sollicitudin sapien non leo tempus lobortis. Morbi semper auctor ipsum, a semper quam elementum a. Aliquam eget sem metus.";
            final String html1 = "<html><body style='width: ";
            final String html2 = "px' style='line-height: 250%'>";
            //jLabel2.setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            jLabel2.setText(html1 + "700" + html2 + st);
            jLabel2.setFont(new Font("Arial", Font.BOLD,16));
            jLabel2.setForeground(Color.DARK_GRAY);
            
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ABOUT US");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/agronomyAdvancement.JPG"))); // NOI18N

        jLabel2.setMaximumSize(new java.awt.Dimension(1200, 1000));
        jLabel2.setMinimumSize(new java.awt.Dimension(1200, 900));

        backBtn.setText("<<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backBtn)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(348, 348, 348))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
