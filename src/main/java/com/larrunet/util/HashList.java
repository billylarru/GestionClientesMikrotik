

package com.larrunet.util;

import java.util.HashMap;
import java.util.Map;

public class HashList {
    private static HashList obj;
    private Map list;
    
    private HashList() {
        list=new HashMap();
    }
    
    private static void createInstance(){
        if(obj==null)obj=new HashList();
    }
    
    public static HashList getInstance(){
        if(obj==null)createInstance();
            return obj;
    }

    
    public Map getList() {
        return list;
    }
    
}
