/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CollectionCenterOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CollectionCenterRole.CollectionCenterWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author kkgarg
 */
public class CollectionCenterRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CollectionCenterWorkAreaJPanel(userProcessContainer, account, (CollectionCenterOrganization)organization, enterprise);
    }
    @Override
   public String toString(){
       return RoleType.CollectionCenter.getValue();
   }
}
