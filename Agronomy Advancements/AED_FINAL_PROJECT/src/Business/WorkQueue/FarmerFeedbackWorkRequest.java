/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class FarmerFeedbackWorkRequest {
    
    private String farmerName;
    private String remarks;
    private String researchSolutionHelped;
    private String siteUserFriendly;
    private String overallRating;
    private Date dateFiled;
    
    public FarmerFeedbackWorkRequest(){
        
        dateFiled = new Date();
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getResearchSolutionHelped() {
        return researchSolutionHelped;
    }

    public void setResearchSolutionHelped(String researchSolutionHelped) {
        this.researchSolutionHelped = researchSolutionHelped;
    }

    public String getSiteUserFriendly() {
        return siteUserFriendly;
    }

    public void setSiteUserFriendly(String siteUserFriendly) {
        this.siteUserFriendly = siteUserFriendly;
    }

    public String getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }

    public Date getDateFiled() {
        return dateFiled;
    }
    
    @Override
    public String toString(){
        return this.farmerName;
    }

}
