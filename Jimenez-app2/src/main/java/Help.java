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
        // Set the message to display into the window
    }

    private String HELPContent(){
        //declare a string to write on the message
            // Be as specific as possible
            // Give directions of how the application will work
        //return for the string
    }
}
