/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Farmer;

import Business.Employee.Employee;

/**
 *
 * @author kkgarg
 */
public class Farmer{
    
    private String farmerName;
    private int id;
    private static int count = 1;

    public Farmer() {
        id = count;
        count++;
    }
    
    public int getId() {
        return id;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    

    @Override
    public String toString() {
        return farmerName;
    }
}
