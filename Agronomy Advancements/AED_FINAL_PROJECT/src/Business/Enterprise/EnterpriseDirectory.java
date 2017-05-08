/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author prash
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType enterpriseType){
        Enterprise enterprise = null;
        if(enterpriseType == Enterprise.EnterpriseType.Agriculture){
            enterprise = new AgricultureEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        else if(enterpriseType == Enterprise.EnterpriseType.Market){
            enterprise = new MarketEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
