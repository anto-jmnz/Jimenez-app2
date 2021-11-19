import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class InventoryManagementApplication extends javafx.application.Application{
    public static void main(String[]args){
        launch(args);
        }

@Override
public void start(Stage stage)throws Exception{
        URL url=getClass().getClassLoader().getResource("ToDoApp.fxml");
        Parent root=FXMLLoader.load(url);
        Scene scene=new Scene(root);

        stage.setTitle("To Do App");
        stage.setScene(scene);
        stage.show();
        }
}