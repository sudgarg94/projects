/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class FarmerFeedbackWorkQueue {
    
    private ArrayList<FarmerFeedbackWorkRequest> farmerFeedbackList;
    
    public FarmerFeedbackWorkQueue(){
        
        farmerFeedbackList = new ArrayList<FarmerFeedbackWorkRequest>();
    }

    public ArrayList<FarmerFeedbackWorkRequest> getFarmerFeedbackList() {
        return farmerFeedbackList;
    }
    
    
    
}
