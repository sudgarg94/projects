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
public class QueryWorkQueue {
    private ArrayList<QueryWorkRequest> queryWorkRequestList;
    
    public QueryWorkQueue()
    {
        queryWorkRequestList = new ArrayList<QueryWorkRequest>();
    }

    public ArrayList<QueryWorkRequest> getQueryWorkRequestList() {
        return queryWorkRequestList;
    }

    
}
