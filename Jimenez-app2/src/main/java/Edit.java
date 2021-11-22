import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class Edit implements Initializable {

    @FXML
    private TextField Item_Field;
    @FXML
    private TextField Cost_Field;
    @FXML
    private TextField SerialNum_Field;

    @FXML
    Item item;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

/*
    @FXML
    public void saveItem(){
       // Save each item into the list
            // it must match the requirements as:
            // have a name (2-256 characters)
            // Serial Number (start with a letter and follow up numbers)
            // Cost Value in dollar sign
        // If this requirements are not met display the error message
    }

    public String itemName(){
        // set up the requirement for the value, 2-256 characters
        // return for it
    }

    public String Valueget(){
        // set up the requirement for the value, start with $
        // return for it
    }


    public int SerialNumget(String SerialNum){
        // Set the requirements for the Serial Number
        // A(letter)-XXX-XXX-XXX
        // X= Numbers
    }


    private void ErrorMessage(String title, String message){

    }

*/



}
