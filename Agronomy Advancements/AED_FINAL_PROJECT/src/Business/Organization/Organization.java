/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Farmer.FarmerDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import Business.Role.Role;
import Business.WorkQueue.FarmerFeedbackWorkQueue;
import Business.WorkQueue.MarketWorkQueue;
import Business.WorkQueue.QueryWorkQueue;


/**
 *
 * @author kkgarg
 */
public abstract class Organization {
    
    private String name;
    //WORK QUEUE
    private WorkQueue workQueue;
    private MarketWorkQueue marketWorkQueue;
    private QueryWorkQueue queryWorkQueue;
    private FarmerFeedbackWorkQueue feedbackWorkQueue;
    //
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private FarmerDirectory farmerDirectory;
    private int organizationID;
    private static int counter;
    Enterprise.EnterpriseType type;
    
    public enum Type{
        Admin("Admin Organization"), CollectionCenter("CollectionCenter Organization"), Farmer("Farmer Organization"),
        Lab("Lab Organization"),Research("Research Organization"),
        Marketing("Marketing Organization");
        
        
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        
    }
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        marketWorkQueue = new MarketWorkQueue();
        feedbackWorkQueue = new FarmerFeedbackWorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        farmerDirectory = new FarmerDirectory();
        queryWorkQueue = new QueryWorkQueue();
        organizationID = counter;
        ++counter;
        
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    
    public FarmerFeedbackWorkQueue getFeedbackWorkQueue() {
        return feedbackWorkQueue;
    }
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public MarketWorkQueue getMarketWorkQueue() {
        return marketWorkQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public FarmerDirectory getFarmerDirectory() {
        return farmerDirectory;
    }

    public void setFarmerDirectory(FarmerDirectory farmerDirectory) {
        this.farmerDirectory = farmerDirectory;
    }

    public QueryWorkQueue getQueryWorkQueue() {
        return queryWorkQueue;
    }
    
    
    

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
