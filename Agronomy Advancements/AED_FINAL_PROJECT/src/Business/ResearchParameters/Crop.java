/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ResearchParameters;

/**
 *
 * @author kkgarg
 */
public class Crop {
    
    private String cropName;
    private String cropSeason;
    private SoilParameter soilParameter;
    
    public Crop()
    {
        this.soilParameter = new SoilParameter();
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropSeason() {
        return cropSeason;
    }

    public void setCropSeason(String cropSeason) {
        this.cropSeason = cropSeason;
    }

    public SoilParameter getSoilParameter() {
        return soilParameter;
    }

    

    
}
