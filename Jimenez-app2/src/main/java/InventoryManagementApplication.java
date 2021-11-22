import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;

public class InventoryManagementApplication extends javafx.application.Application{
    public static ArrayList<Item> myList;
    public static void main(String[]args){
        launch(args);
        }

@Override
public void start(Stage stage)throws Exception{
        URL url=getClass().getClassLoader().getResource("InventoryApp.fxml");
        Parent root=FXMLLoader.load(url);
        Scene scene=new Scene(root);

        stage.setTitle("Inventory App");
        stage.setScene(scene);
        stage.show();
        }
}