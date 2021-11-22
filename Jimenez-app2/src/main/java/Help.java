/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Antonia Jimenez
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Help implements Initializable {

    @FXML
    private TextArea HelpText;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        LoadHELP();
    }

    private void LoadHELP(){
        // String message variable
        String message = HELPContent();
        // Set the message to display into the window
        HelpText.setText(message);
    }

    private String HELPContent(){
        //declare a string to write on the message
            // Be as specific as possible
            // Give directions of how the application will work
        String message = " Welcome to your favorite Inventory list creator. To start using this interface, please follow the following guidelines\n" +
                "1.In order to start adding up the items into your Inventory list app, start by filling up the required fields as the Name of the Item, Cost Value and Serial Number\n"+
                "\t- An error message will be displayed if the user enters an invalid item name\n"+
                "\t- An error message will be displayed if the user enters an invalid item value \n"+
                "\t- An error message will be displayed if the user enters repeated Serial Number \n"+
                "\t- An error message will be displayed if the user adds more than 1024 inventory items\n"+
                "2.After filling up each required field, make sure to click the button 'Add' in order to add the item into the list\n" +
                "3.It's important for you to know that:\n"+
                "\t- A item must have a name, monetary value, and a serial number\n"+
                "\t- Now the name should be between 2-256 characters\n"+
                "\t- Each value should only have numeric values\n"+
                "\t- Each serial number, must be written with this format A-XXX-XXX-XXX. A must be a letter, and X can be either a number or a letter\n"+
                "4.In order to remove a single item by selecting the item row\n"+
                "5.In order clear the list, click on clear button\n"+
                "6.In order to edit and item's name, value, and the Serial number. For this to happen please fill in the fields that will be replaced and then click the button 'Edit'\n"+
                "\t- An error message will be displayed if the user enters an invalid item name\n"+
                "\t- An error message will be displayed if the user enters an invalid item value \n"+
                "\t- An error message will be displayed if the user enters repeated Serial Number \n"+
                "7. In order to look for an item name or Serial Number, please type it in the 'Item Search' text field\n"+
                "8. In order to sort your arrays, please make sure to click on the arrows that are displayed in every column of the table\n"+
                "9.To save the list, please click on the right corner 'File' button 'Save List' and select the file location and it will be downloaded. Please choose what format either JSON, VST, or HTML\n"+
                "10.To load the past list,please click on the right corner 'File' button 'Load List' and select the last file downloaded.Please choose what format either JSON, VST, or HTML\n "+
                "Enjoy your Inventory list!";

        //return for the string
        return message;
    }
}
