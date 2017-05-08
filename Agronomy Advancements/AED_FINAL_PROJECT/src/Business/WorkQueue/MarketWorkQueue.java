/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author kkgarg
 */
public class MarketWorkQueue {
    
    private ArrayList<MarketWorkRequest> markerWorkRequestList;
    
    public MarketWorkQueue()
    {
        markerWorkRequestList = new ArrayList<MarketWorkRequest>();
    }

    public ArrayList<MarketWorkRequest> getMarkerWorkRequestList() {
        return markerWorkRequestList;
    }
    
    
}
