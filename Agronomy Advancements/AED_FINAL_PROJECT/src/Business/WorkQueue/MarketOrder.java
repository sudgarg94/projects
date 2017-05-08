/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class MarketOrder {
    
    private UserAccount buyer;
    private Date dateOrdered;
    private String buyerAddressLine1;
    private String buyerAddressLine2;
    private int buyerZipcode;
    private long buyerContactInfo;
    private String buyerRemarks;
    private int orderQuantity;

    public UserAccount getBuyer() {
        return buyer;
    }

    public void setBuyer(UserAccount buyer) {
        this.buyer = buyer;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public String getBuyerAddressLine1() {
        return buyerAddressLine1;
    }

    public void setBuyerAddressLine1(String buyerAddressLine1) {
        this.buyerAddressLine1 = buyerAddressLine1;
    }

    public String getBuyerAddressLine2() {
        return buyerAddressLine2;
    }

    public void setBuyerAddressLine2(String buyerAddressLine2) {
        this.buyerAddressLine2 = buyerAddressLine2;
    }

    public int getBuyerZipcode() {
        return buyerZipcode;
    }

    public void setBuyerZipcode(int buyerZipcode) {
        this.buyerZipcode = buyerZipcode;
    }

    public long getBuyerContactInfo() {
        return buyerContactInfo;
    }

    public void setBuyerContactInfo(long buyerContactInfo) {
        this.buyerContactInfo = buyerContactInfo;
    }

    public String getBuyerRemarks() {
        return buyerRemarks;
    }

    public void setBuyerRemarks(String buyerRemarks) {
        this.buyerRemarks = buyerRemarks;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    @Override
    public String toString(){
       return this.getBuyer().getEmployee().getName();
    }
}
