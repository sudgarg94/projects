/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.awt.Image;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author kkgarg
 */
public class MarketWorkRequest {
    
    private UserAccount sender;
    //private UserAccount receiver;//
    private String status;
    private String cropName;
    private int quantity;
    private double ratePerKg;
    private Date dateRequested;
    //private Date dateResolved;// 
    private String senderAddressLine1;
    private String senderAddressLine2;
    private int senderZipcode;
    //private String receiverAddressLine1;//
    //private String receiverAddressLine2;//
    //private int receiverZipcode;//
    private long senderContactInfo;
    //private long receiverContactInfo;//
    private ImageIcon cropImage;
    private String cropDesc;
    //private String vendorRemarks;//
    
    private MarketOrderDirectory marketOrderDirectory;

    public MarketWorkRequest() {
        dateRequested = new Date();
        marketOrderDirectory = new MarketOrderDirectory();
    }
    
    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRatePerKg() {
        return ratePerKg;
    }

    public void setRatePerKg(double ratePerKg) {
        this.ratePerKg = ratePerKg;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getSenderAddressLine1() {
        return senderAddressLine1;
    }

    public void setSenderAddressLine1(String senderAddressLine1) {
        this.senderAddressLine1 = senderAddressLine1;
    }

    public String getSenderAddressLine2() {
        return senderAddressLine2;
    }

    public void setSenderAddressLine2(String senderAddressLine2) {
        this.senderAddressLine2 = senderAddressLine2;
    }

    public int getSenderZipcode() {
        return senderZipcode;
    }

    public void setSenderZipcode(int senderZipcode) {
        this.senderZipcode = senderZipcode;
    }

    public long getSenderContactInfo() {
        return senderContactInfo;
    }

    public void setSenderContactInfo(long senderContactInfo) {
        this.senderContactInfo = senderContactInfo;
    }

    public ImageIcon getCropImage() {
        return cropImage;
    }

    public void setCropImage(ImageIcon cropImage) {
        this.cropImage = cropImage;
    }

    public String getCropDesc() {
        return cropDesc;
    }

    public void setCropDesc(String cropDesc) {
        this.cropDesc = cropDesc;
    }

    public MarketOrderDirectory getMarketOrderDirectory() {
        return marketOrderDirectory;
    }
    
    
    
    @Override
    public String toString(){
       return this.getSender().getFarmer().getFarmerName();
    }
    
}
