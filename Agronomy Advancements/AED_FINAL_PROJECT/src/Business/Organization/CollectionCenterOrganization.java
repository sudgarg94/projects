/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CollectionCenterRole;
import Business.Role.Role;
import java.util.ArrayList;


/**
 *
 * @author kkgarg
 */
public class CollectionCenterOrganization extends Organization{

    public CollectionCenterOrganization() {
        super(Type.CollectionCenter.getValue());
    }

    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CollectionCenterRole());
        return roles;
    }
    
}
