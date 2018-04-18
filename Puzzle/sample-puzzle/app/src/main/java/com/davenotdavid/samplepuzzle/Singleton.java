package com.davenotdavid.samplepuzzle;

import java.util.ArrayList;

/**
 * Created by Angelo on 08/04/2018.
 */

public class Singleton {
    private static Singleton singleton;
    private ArrayList<String> list;
    public static synchronized Singleton getInstance(){
        return singleton == null ? singleton = new Singleton() : singleton;
    }


    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
