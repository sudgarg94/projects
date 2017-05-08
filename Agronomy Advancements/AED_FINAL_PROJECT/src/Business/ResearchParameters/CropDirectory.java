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
public class CropDirectory {
    
    private ArrayList<Crop> cropList;
    
    public CropDirectory()
    {
        this.cropList = new ArrayList<Crop>();
        
    }

    public ArrayList<Crop> getCropList() {
        return cropList;
    }
    
    
    public Crop addCrop()
    {
        Crop crop = new Crop();
        cropList.add(crop);
        return crop;
    }
    
}
