/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ResearchParameters;

import Business.UserAccount.UserAccount;

/**
 *
 * @author kkgarg
 */
public class GeneralCropInfo {
    
    private String cropName;
    private String aboutCrop;
    private String climateRequirement;
    private String soil;
    private String fertilizerManagement;
    private String nurtientManagement;

    public String getAboutCrop() {
        return aboutCrop;
    }

    public void setAboutCrop(String aboutCrop) {
        this.aboutCrop = aboutCrop;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }


    public String getClimateRequirement() {
        return climateRequirement;
    }

    public void setClimateRequirement(String climateRequirement) {
        this.climateRequirement = climateRequirement;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getFertilizerManagement() {
        return fertilizerManagement;
    }

    public void setFertilizerManagement(String fertilizerManagement) {
        this.fertilizerManagement = fertilizerManagement;
    }

    public String getNurtientManagement() {
        return nurtientManagement;
    }

    public void setNurtientManagement(String nurtientManagement) {
        this.nurtientManagement = nurtientManagement;
    }
    
    
    
    
    @Override
    public String toString(){
        return this.cropName;
    }
    
    
    
}
