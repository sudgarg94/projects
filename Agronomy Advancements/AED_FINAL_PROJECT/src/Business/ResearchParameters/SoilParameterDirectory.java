/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ResearchParameters;

import java.util.ArrayList;

/**
 *
 * @author kkgarg
 */
public class SoilParameterDirectory {
    
    private ArrayList<SoilParameter> soilParameterList;
    
    public SoilParameterDirectory()
    {
        this.soilParameterList = new ArrayList<>();
    }

    public ArrayList<SoilParameter> getSoilParameterList() {
        return soilParameterList;
    }
    
    public SoilParameter addResearchParameter()
    {
        SoilParameter researchParameter = new SoilParameter();
        soilParameterList.add(researchParameter);
        return  researchParameter;
    }
}
