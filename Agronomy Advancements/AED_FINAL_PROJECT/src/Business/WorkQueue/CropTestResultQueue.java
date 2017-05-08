/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.ResearchParameters.Crop;

/**
 *
 * @author prash
 */
public class CropTestResultQueue extends WorkRequest{
    
    private String testResult;
    private Crop crop;
    
    public CropTestResultQueue()
    {
        this.crop = new Crop();
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
    
    
    
//   @Override
//    public String toString(){
//        return String.valueOf(this.getRequestDate());
//    }
    
}
