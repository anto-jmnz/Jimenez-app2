/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Antonia Jimenez
 */

import javafx.scene.control.Button;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {
    private String Item_Name;
    private String Value;
    private String SerialNum;

    public Item(String item, String costValue, String serialNum) {
        this.Item_Name= item;
        this.Value = costValue;
        this.SerialNum = serialNum;
    }

    public Item(){

    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getSerialNum() {
        return SerialNum;
    }

    public void setSerialNum(String serialNum) {
        SerialNum = serialNum;
    }



}
