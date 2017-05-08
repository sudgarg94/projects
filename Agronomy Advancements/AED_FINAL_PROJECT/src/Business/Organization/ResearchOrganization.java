/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.ResearchParameters.CropDirectory;
import Business.ResearchParameters.GeneralCropInfoDirectory;
import Business.Role.ResearchOrganizationRole;
import Business.Role.Role;
import java.util.ArrayList;


/**
 *
 * @author Lenovo
 */
public class ResearchOrganization extends Organization{
    
    private CropDirectory cropDirectory;
    private GeneralCropInfoDirectory generalCropInfoDirectory;
    
    
    public ResearchOrganization() {
        super(Type.Research.getValue());
        this.cropDirectory = new CropDirectory();
        this.generalCropInfoDirectory = new GeneralCropInfoDirectory();
    }

    public CropDirectory getCropDirectory() {
        return cropDirectory;
    }

    public GeneralCropInfoDirectory getGeneralCropInfoDirectory() {
        return generalCropInfoDirectory;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ResearchOrganizationRole());
        return roles;
    }
    
    
}
