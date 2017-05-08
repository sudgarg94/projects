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
public class GeneralCropInfoDirectory {
    
    private ArrayList<GeneralCropInfo> generalCropInfoList;
    
    public GeneralCropInfoDirectory(){
        
        generalCropInfoList = new ArrayList<GeneralCropInfo>();
    }

    public ArrayList<GeneralCropInfo> getGeneralCropInfoList() {
        return generalCropInfoList;
    }

    public void setGeneralCropInfoList(ArrayList<GeneralCropInfo> generalCropInfoList) {
        this.generalCropInfoList = generalCropInfoList;
    }
    
    public GeneralCropInfo addGeneralCrop(){
        GeneralCropInfo generalCropInfo = new GeneralCropInfo();
        generalCropInfoList.add(generalCropInfo);
        return generalCropInfo;
    }
}
