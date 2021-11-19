import javafx.scene.control.Button;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {
    String Item_Name;
    private String Value;
    private String SerialNum;

    public Item(String item, String serialNum, String costValue) {
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

    @Override
    public String toString() {
        // Convert everything to a string for printing purposes
    }

}
