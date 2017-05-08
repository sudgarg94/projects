/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author prash
 */
public class WorkRequest {
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    @Override
    public String toString(){
        return String.valueOf(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(requestDate));
    }
    
    
 //Soil Parameters:
    
    private String plannedCropType;
    private String farmerAddressLine1;
    private String farmerAddressLine2;
    private int farmerAddressZip;
    private float locationTemerature;
    private int locationGroundWaterLevel;
    private String[] farmerLatLongs;
    
    private String collectionCenterAddressLine1;
    private String collectionCenterAddressLine2;
    private int collectionCenterAddressZip;
    private String[] collectionCenterLatLongs;        
    
    private String actualSoilTexture;
    private float actualBulkDensity;
    private float actualSoilPH;
    private float actualNitrateLevel;
    private float actualWaterContent;
    private float actualElectricalConductivity;
    private float actualOrganicCarbon;
    private float actualCarbonNitrogenRatio;
    private float actualAluminiumSaturation;
    private float actualCalciumCarbonateContent;

    public String getPlannedCropType() {
        return plannedCropType;
    }

    public void setPlannedCropType(String plannedCropType) {
        this.plannedCropType = plannedCropType;
    }

    public String getFarmerAddressLine1() {
        return farmerAddressLine1;
    }

    public void setFarmerAddressLine1(String farmerAddressLine1) {
        this.farmerAddressLine1 = farmerAddressLine1;
    }

    public String getFarmerAddressLine2() {
        return farmerAddressLine2;
    }

    public void setFarmerAddressLine2(String farmerAddressLine2) {
        this.farmerAddressLine2 = farmerAddressLine2;
    }

    public int getFarmerAddressZip() {
        return farmerAddressZip;
    }

    public void setFarmerAddressZip(int farmerAddressZip) {
        this.farmerAddressZip = farmerAddressZip;
    }

    public float getLocationTemerature() {
        return locationTemerature;
    }

    public void setLocationTemerature(float locationTemerature) {
        this.locationTemerature = locationTemerature;
    }

    public int getLocationGroundWaterLevel() {
        return locationGroundWaterLevel;
    }

    public void setLocationGroundWaterLevel(int locationGroundWaterLevel) {
        this.locationGroundWaterLevel = locationGroundWaterLevel;
    }

    public String getActualSoilTexture() {
        return actualSoilTexture;
    }

    public void setActualSoilTexture(String actualSoilTexture) {
        this.actualSoilTexture = actualSoilTexture;
    }

    public float getActualBulkDensity() {
        return actualBulkDensity;
    }

    public void setActualBulkDensity(float actualBulkDensity) {
        this.actualBulkDensity = actualBulkDensity;
    }

    public float getActualSoilPH() {
        return actualSoilPH;
    }

    public void setActualSoilPH(float actualSoilPH) {
        this.actualSoilPH = actualSoilPH;
    }

    public float getActualNitrateLevel() {
        return actualNitrateLevel;
    }

    public void setActualNitrateLevel(float actualNitrateLevel) {
        this.actualNitrateLevel = actualNitrateLevel;
    }

    public float getActualWaterContent() {
        return actualWaterContent;
    }

    public void setActualWaterContent(float actualWaterContent) {
        this.actualWaterContent = actualWaterContent;
    }

    public float getActualElectricalConductivity() {
        return actualElectricalConductivity;
    }

    public void setActualElectricalConductivity(float actualElectricalConductivity) {
        this.actualElectricalConductivity = actualElectricalConductivity;
    }

    public float getActualOrganicCarbon() {
        return actualOrganicCarbon;
    }

    public void setActualOrganicCarbon(float actualOrganicCarbon) {
        this.actualOrganicCarbon = actualOrganicCarbon;
    }

    public float getActualCarbonNitrogenRatio() {
        return actualCarbonNitrogenRatio;
    }

    public void setActualCarbonNitrogenRatio(float actualCarbonNitrogenRatio) {
        this.actualCarbonNitrogenRatio = actualCarbonNitrogenRatio;
    }

    public float getActualAluminiumSaturation() {
        return actualAluminiumSaturation;
    }

    public void setActualAluminiumSaturation(float actualAluminiumSaturation) {
        this.actualAluminiumSaturation = actualAluminiumSaturation;
    }

    public float getActualCalciumCarbonateContent() {
        return actualCalciumCarbonateContent;
    }

    public void setActualCalciumCarbonateContent(float actualCalciumCarbonateContent) {
        this.actualCalciumCarbonateContent = actualCalciumCarbonateContent;
    }

    public String[] getFarmerLatLongs() {
        return farmerLatLongs;
    }

    public void setFarmerLatLongs(String[] farmerLatLongs) {
        this.farmerLatLongs = farmerLatLongs;
    }

    public String getCollectionCenterAddressLine1() {
        return collectionCenterAddressLine1;
    }

    public void setCollectionCenterAddressLine1(String collectionCenterAddressLine1) {
        this.collectionCenterAddressLine1 = collectionCenterAddressLine1;
    }

    public String getCollectionCenterAddressLine2() {
        return collectionCenterAddressLine2;
    }

    public void setCollectionCenterAddressLine2(String collectionCenterAddressLine2) {
        this.collectionCenterAddressLine2 = collectionCenterAddressLine2;
    }

    public int getCollectionCenterAddressZip() {
        return collectionCenterAddressZip;
    }

    public void setCollectionCenterAddressZip(int collectionCenterAddressZip) {
        this.collectionCenterAddressZip = collectionCenterAddressZip;
    }

    public String[] getCollectionCenterLatLongs() {
        return collectionCenterLatLongs;
    }

    public void setCollectionCenterLatLongs(String[] collectionCenterLatLongs) {
        this.collectionCenterLatLongs = collectionCenterLatLongs;
    }
    
    
    
    

    
    
    
}
