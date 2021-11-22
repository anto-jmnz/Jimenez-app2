
/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Antonia Jimenez
 */

import java.util.ArrayList;

public class Helper {
    private ArrayList<Item> parse;


    public void Helper(){
        parse = null;
    }
    public ArrayList<Item> getDescriptor() {
        return parse;
    }


    public void setDescriptor(ArrayList<Item> Inventory) {
        this.parse = Inventory;
    }
}
