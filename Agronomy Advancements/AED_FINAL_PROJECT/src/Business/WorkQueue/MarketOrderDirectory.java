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
public class MarketOrderDirectory {
    
    private ArrayList<MarketOrder> marketOrderList;
    
    public MarketOrderDirectory(){
        
        marketOrderList = new ArrayList<MarketOrder>();
    }

    public ArrayList<MarketOrder> getMarketOrderList() {
        return marketOrderList;
    }
    
    public MarketOrder addOrder(){
        
        MarketOrder order = new MarketOrder();
        marketOrderList.add(order);
        return order;
    }
    
}
