import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button Add;

    @FXML
    private Button Clear;

    @FXML
    private TextField Cost_Field;

    @FXML
    private Button Edit;

    @FXML
    private MenuBar File;

    @FXML
    private Button Help;

    @FXML
    private Button Remove;

    @FXML
    private TableView<Item> Inventory;

    @FXML
    private TextField Item_Field;

    @FXML
    private TableColumn<Item, String> Item_Name;

    @FXML
    private TableColumn<Item, String> SerialNum;

    @FXML
    private TextField SerialNum_Field;

    @FXML
    private TableColumn<Item, String> Value;

    FileChooser fileChooser= new FileChooser();
    public ObservableList<Item> TodoList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Item_Name.setCellValueFactory(new PropertyValueFactory<Item, String>("item"));
        Value.setCellValueFactory(new PropertyValueFactory<Item, String>("Cost Value"));
        SerialNum.setCellValueFactory(new PropertyValueFactory<Item, String>("Serial Number"));
    }

    @FXML
    void Add1(ActionEvent event) {
    // declare for the sctrings that are mandatory
        // name has to be from 2-256 characters long
        // do If statements to see if either one is empty
        // Declare the requirements for the cost value $ and the serial number
            //Start with a letter, and follow up with numbers
        // Specify the maximum of items that can be on the list

    }
    //public ObservableList<Item> addHelper(String item, String Value,LocalDate SerialNum){
    // Declare a new item
        //called the new Observable list temp
        // add the item to the list
        //return temp;
    //}



    @FXML
    void Clear1(ActionEvent event) {
        // be able to clear of all of the items that make up the list
        // Clear the list

    }


    @FXML
    void Edit1(ActionEvent event) {
        // Function able to replace the old text with the new one once the selection is clicked
        //Display an error message once the user enters an existing serial number
        //Display an error message once the user enters an invalid item value
        //Display an error message once the user enters an invalid item name

    }



    @FXML
    void HelpButton(ActionEvent event) {
        //Function able to open the othe FXML file and display the instructions and a help guide for the user to follow
        //load FXML file

    }

    @FXML
    void Remove1(ActionEvent event) {
        // Be able to remove just the selected item from the list


    }

    //public ObservableList<Item> RemoveHelper(String item, String SerialNum, String Value){
        //function set up in order to be able to test the function
    //}

    @FXML
    void SaveButton(ActionEvent event) {
        // Function able to load the last saved file of the inventory
        // Window Stage
        // FileChooser for the title, initial File name, and extensions
        // File Reader
        // Buffer Reader
        // be able to print everything that is on the list into the file
    }

    @FXML
    void LoadButton(ActionEvent event) {
        // Function able to load the last saved file of the inventory
        // Window Stage
        // FileChooser for the title, initial File name, and extensions
        // File Reader
        // Buffer Reader
            // be able to print everything that is on the list into the file

    }

    @FXML
    private void ErrorMessage(String title, String message){
        // Print the error message that will be display every time one of the requisites are not met
    }
}
