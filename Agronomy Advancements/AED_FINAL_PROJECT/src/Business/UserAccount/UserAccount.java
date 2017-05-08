/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Farmer.Farmer;
import Business.Role.Role;
import Business.WorkQueue.MarketWorkQueue;
import Business.WorkQueue.QueryWorkQueue;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Lenovo
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Farmer farmer;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private MarketWorkQueue marketWorkQueue;
    private QueryWorkQueue queryWorkQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
        marketWorkQueue = new MarketWorkQueue();
        queryWorkQueue = new QueryWorkQueue();
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public MarketWorkQueue getMarketWorkQueue() {
        return marketWorkQueue;
    }

    public QueryWorkQueue getQueryWorkQueue() {
        return queryWorkQueue;
    }

    
    
    
    
    
    @Override
    public String toString() {
        return username;
    }
    
}
