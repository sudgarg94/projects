/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Farmer;

import java.util.ArrayList;

/**
 *
 * @author kkgarg
 */
public class FarmerDirectory {
    
    private ArrayList<Farmer> farmerList;
    
    public FarmerDirectory() {
        farmerList = new ArrayList();
    }

    public ArrayList<Farmer> getFarmerList() {
        return farmerList;
    }
    
    public Farmer createFarmer(String farmerName){
        Farmer farmer = new Farmer();
        farmer.setFarmerName(farmerName);
        farmerList.add(farmer);
        return farmer;
    }
}
