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
public class SoilParameter {
    
    
    //Soil Parameters
    
    private String expectedSoilTexture;
    private String remarksSoilTexture;
    //
    private float expectedBulkDensity;
    private String remarksBulkDensity;
    //
    private float expectedSoilPH;
    private String remarksSoilPH;
    //
    private float expectedNitrateLevel;
    private String remarksNitrateLevel;
    //
    private float expectedWaterContent;
    private String remarksWaterContent;
    //
    private float expectedElectricalConductivity;
    private String remarksElectricalConductivity;
    //
    private float expectedOrganicCarbon;
    private String remarksOrganicCarbon;
    //
    private float expectedCarbonNitrogenRatio;
    private String remarksCarbonNitrogenRatio;
    //
    private float expectedAluminiumSaturation;
    private String remarksAluminiumSaturation;
    //
    private float expectedCalciumCarbonateContent;
    private String remarksCalciumCarbonateContent;
 
    
    
    
    //Getter setters
    public String getExpectedSoilTexture() {
        return expectedSoilTexture;
    }

    public void setExpectedSoilTexture(String expectedSoilTexture) {
        this.expectedSoilTexture = expectedSoilTexture;
    }

    public String getRemarksSoilTexture() {
        return remarksSoilTexture;
    }

    public void setRemarksSoilTexture(String remarksSoilTexture) {
        this.remarksSoilTexture = remarksSoilTexture;
    }

    public float getExpectedBulkDensity() {
        return expectedBulkDensity;
    }

    public void setExpectedBulkDensity(float expectedBulkDensity) {
        this.expectedBulkDensity = expectedBulkDensity;
    }

    public String getRemarksBulkDensity() {
        return remarksBulkDensity;
    }

    public void setRemarksBulkDensity(String remarksBulkDensity) {
        this.remarksBulkDensity = remarksBulkDensity;
    }

    public float getExpectedSoilPH() {
        return expectedSoilPH;
    }

    public void setExpectedSoilPH(float expectedSoilPH) {
        this.expectedSoilPH = expectedSoilPH;
    }

    public String getRemarksSoilPH() {
        return remarksSoilPH;
    }

    public void setRemarksSoilPH(String remarksSoilPH) {
        this.remarksSoilPH = remarksSoilPH;
    }

    public float getExpectedNitrateLevel() {
        return expectedNitrateLevel;
    }

    public void setExpectedNitrateLevel(float expectedNitrateLevel) {
        this.expectedNitrateLevel = expectedNitrateLevel;
    }

    public String getRemarksNitrateLevel() {
        return remarksNitrateLevel;
    }

    public void setRemarksNitrateLevel(String remarksNitrateLevel) {
        this.remarksNitrateLevel = remarksNitrateLevel;
    }

    public float getExpectedWaterContent() {
        return expectedWaterContent;
    }

    public void setExpectedWaterContent(float expectedWaterContent) {
        this.expectedWaterContent = expectedWaterContent;
    }

    public String getRemarksWaterContent() {
        return remarksWaterContent;
    }

    public void setRemarksWaterContent(String remarksWaterContent) {
        this.remarksWaterContent = remarksWaterContent;
    }

    public float getExpectedElectricalConductivity() {
        return expectedElectricalConductivity;
    }

    public void setExpectedElectricalConductivity(float expectedElectricalConductivity) {
        this.expectedElectricalConductivity = expectedElectricalConductivity;
    }

    public String getRemarksElectricalConductivity() {
        return remarksElectricalConductivity;
    }

    public void setRemarksElectricalConductivity(String remarksElectricalConductivity) {
        this.remarksElectricalConductivity = remarksElectricalConductivity;
    }

    public float getExpectedOrganicCarbon() {
        return expectedOrganicCarbon;
    }

    public void setExpectedOrganicCarbon(float expectedOrganicCarbon) {
        this.expectedOrganicCarbon = expectedOrganicCarbon;
    }

    public String getRemarksOrganicCarbon() {
        return remarksOrganicCarbon;
    }

    public void setRemarksOrganicCarbon(String remarksOrganicCarbon) {
        this.remarksOrganicCarbon = remarksOrganicCarbon;
    }

    public float getExpectedCarbonNitrogenRatio() {
        return expectedCarbonNitrogenRatio;
    }

    public void setExpectedCarbonNitrogenRatio(float expectedCarbonNitrogenRatio) {
        this.expectedCarbonNitrogenRatio = expectedCarbonNitrogenRatio;
    }

    public String getRemarksCarbonNitrogenRatio() {
        return remarksCarbonNitrogenRatio;
    }

    public void setRemarksCarbonNitrogenRatio(String remarksCarbonNitrogenRatio) {
        this.remarksCarbonNitrogenRatio = remarksCarbonNitrogenRatio;
    }

    public float getExpectedAluminiumSaturation() {
        return expectedAluminiumSaturation;
    }

    public void setExpectedAluminiumSaturation(float expectedAluminiumSaturation) {
        this.expectedAluminiumSaturation = expectedAluminiumSaturation;
    }

    public String getRemarksAluminiumSaturation() {
        return remarksAluminiumSaturation;
    }

    public void setRemarksAluminiumSaturation(String remarksAluminiumSaturation) {
        this.remarksAluminiumSaturation = remarksAluminiumSaturation;
    }

    public float getExpectedCalciumCarbonateContent() {
        return expectedCalciumCarbonateContent;
    }

    public void setExpectedCalciumCarbonateContent(float expectedCalciumCarbonateContent) {
        this.expectedCalciumCarbonateContent = expectedCalciumCarbonateContent;
    }

    public String getRemarksCalciumCarbonateContent() {
        return remarksCalciumCarbonateContent;
    }

    public void setRemarksCalciumCarbonateContent(String remarksCalciumCarbonateContent) {
        this.remarksCalciumCarbonateContent = remarksCalciumCarbonateContent;
    }
    
    //Business Logic
    public void businessLogicBulkDensity(float actualBulkDensity)
    {
        if(actualBulkDensity>expectedBulkDensity)
        {
            this.setRemarksBulkDensity("Use Worm Castings Fertilizer");
        }
        else if(actualBulkDensity<expectedBulkDensity)
        {
            this.setRemarksBulkDensity("Use Ammonium Nitrate rich Fertilizer");
        }
        else
        {
            this.setRemarksBulkDensity("Bulk Density is at an appropriate level");
        }
    }
    
    public void businessLogicSoilPH(float actualSoilPH)
    {
        if(actualSoilPH>expectedSoilPH)
        {
            this.setRemarksSoilPH("Use Acidifying Soluble rich Fertilizer");
        }
        else if(actualSoilPH<expectedSoilPH)
        {
            this.setRemarksSoilPH("Use Cottonseed Meal Fertilizer");
        }
        else
        {
            this.setRemarksSoilPH("pH is at an appropriate level");
        }
    }
    
    public void businessLogicNitrateLevel(float actualNitrateLevel)
    {
        if(actualNitrateLevel>expectedNitrateLevel)
        {
            this.setRemarksNitrateLevel("Use Greensand Fertilizer");
        }
        else if(actualNitrateLevel<expectedNitrateLevel)
        {
            this.setRemarksNitrateLevel("Use Milorganite Organic: Nitrogen Fertilizer");
        }
        else
        {
            this.setRemarksNitrateLevel("Nitrate Level is at an appropriate level");
        }
    }
    
    public void businessLogicElectricalConductivity(float actualElectricalConductivity)
    {
        if(actualElectricalConductivity>expectedElectricalConductivity)
        {
            this.setRemarksElectricalConductivity("Use leaching to reduce Salt Content");
        }
        else if(actualElectricalConductivity<expectedElectricalConductivity)
        {
            this.setRemarksElectricalConductivity("Use Potash rich Fertilizer");
        }
        else
        {
            this.setRemarksElectricalConductivity("Electrical Conductivity is at an appropriate level");
        }
    }
    
    public void businessLogicCarbonNitrogenRatio(float actualCarbonNitrogenRatio)
    {
        if(actualCarbonNitrogenRatio>expectedCarbonNitrogenRatio)
        {
            this.setRemarksCarbonNitrogenRatio("Use Ammonium Nitrate rich Fertilizer");
        }
        else if(actualCarbonNitrogenRatio<expectedCarbonNitrogenRatio)
        {
            this.setRemarksCarbonNitrogenRatio("Use Wood Ash Fertilizer");
        }
        else
        {
            this.setRemarksCarbonNitrogenRatio("C/N ratio is at an appropriate level");
        }
    }
    
    public void businessLogicOrganicCarbon(float actualOrganicCarbon)
    {
        if(actualOrganicCarbon>expectedOrganicCarbon)
        {
            this.setRemarksOrganicCarbon("Use Bloodmeal Fertilizer");
        }
        else if(actualOrganicCarbon<expectedOrganicCarbon)
        {
            this.setRemarksOrganicCarbon("Use  Limestone rich Fertilizer");
        }
        else
        {
            this.setRemarksOrganicCarbon("Organic Carbon is at an appropriate level");
        }
    }
    
    public void businessLogicAluminiumSaturation(float actualAluminiumSaturation)
    {
        if(actualAluminiumSaturation>expectedAluminiumSaturation)
        {
            this.setRemarksAluminiumSaturation("Use Azomite Fertilizer");
        }
        else if(actualAluminiumSaturation<expectedAluminiumSaturation)
        {
            this.setRemarksAluminiumSaturation("Use Ammonium Sulphate rich Fertilizer");
        }
        else
        {
            this.setRemarksAluminiumSaturation("Aluminium Saturation is at an appropriate level");
        }
    }
    
    public void businessLogicCalciumCarbonateContent(float actualCalciumCarbonateContent)
    {
        if(actualCalciumCarbonateContent>expectedCalciumCarbonateContent)
        {
            this.setRemarksCalciumCarbonateContent("Use AgriCal Fertilizer");
        }
        else if(actualCalciumCarbonateContent<expectedCalciumCarbonateContent)
        {
            this.setRemarksCalciumCarbonateContent("Use Calcium Ammonium Nitrate rich Fertilizer");
        }
        else
        {
            this.setRemarksCalciumCarbonateContent("Calcium Carbonate is at an appropriate level");
        }
    }  
    
    public void businessLogicWaterContent(float actualWaterContent)
    {
        if(actualWaterContent>expectedWaterContent)
        {
            this.setRemarksWaterContent("No Need to irrigate in excess");
        }
        else if(actualWaterContent<expectedWaterContent)
        {
            this.setRemarksWaterContent("Proper irrigation is required");
        }
        else
        {
            this.setRemarksWaterContent("Water Content is at an appropriate level");
        }
    }  
}
