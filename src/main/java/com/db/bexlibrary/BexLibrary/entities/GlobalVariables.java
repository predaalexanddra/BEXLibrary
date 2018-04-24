package com.db.bexlibrary.BexLibrary.entities;

import jdk.nashorn.internal.objects.Global;

public class GlobalVariables {
    public String email;
    private static GlobalVariables globalVariables = null;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static GlobalVariables getInstance(){
        if(globalVariables!=null){
            return globalVariables;
        }else{
            globalVariables = new GlobalVariables();
        }
        return globalVariables;
    }
}
