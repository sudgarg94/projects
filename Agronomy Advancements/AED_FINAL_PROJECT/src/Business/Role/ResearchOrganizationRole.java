/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ResearchOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.ResearchRole.ResearchWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author kkgarg
 */
public class ResearchOrganizationRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ResearchWorkAreaJPanel(userProcessContainer, account, (ResearchOrganization)organization, enterprise);
    }
    @Override
   public String toString(){
       return RoleType.ResearchAssistant.getValue();
   }
}
