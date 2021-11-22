/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Antonia Jimenez
 */
import com.google.gson.JsonObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import netscape.javascript.JSObject;

import java.io.*;
import java.net.URL;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.google.gson.Gson;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Controller implements Initializable {

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

    @FXML
    private AnchorPane InventoryView;

    @FXML
    private TextField Item_Search;

    @FXML
    private RadioButton Radio_btn;

    FileChooser fileChooser= new FileChooser();
    public ObservableList<Item> InventoryList = FXCollections.observableArrayList();
    public ObservableList<Item> Search_Item = FXCollections.observableArrayList();
                                        //A-123-123-123
    Pattern pattern = Pattern.compile("[a-zA-Z]-[a-zA-Z0-9]{3}-[a-zA-Z0-9]{3}-[a-zA-Z0-9]{3}");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TSV", "*.txt"), new FileChooser.ExtensionFilter("HTML","*.html"), new FileChooser.ExtensionFilter("JSON","*.json"));
        Item_Name.setCellValueFactory(new PropertyValueFactory<Item, String>("Item_Name"));
        Value.setCellValueFactory(new PropertyValueFactory<Item, String>("Value"));
        SerialNum.setCellValueFactory(new PropertyValueFactory<Item, String>("SerialNum"));
        Inventory.setItems(InventoryList);
        Inventory.refresh();


    }


    @FXML
    public void Add1() {
    // declare for the strings that are mandatory
        // name has to be from 2-256 characters long
        // do If statements to see if either one is empty
        // Declare the requirements for the cost value $ and the serial number
            //Start with a letter, and follow up with numbers
        // Specify the maximum of items that can be on the list
        String name= Item_Field.getText();
        String cost= Cost_Field.getText();
        String Serial= SerialNum_Field.getText();
        Matcher matcher = pattern.matcher(Serial);

        if(name.isEmpty()) {
            ErrorMessage("Error", "Please enter a name for the item");
        }else if (name.length()< 2 ||  name.length() > 256) {
            ErrorMessage("Error", "Please enter a name from 2 to 256 characters.");
            return;
        }else if (cost.isEmpty()) {
            ErrorMessage("Error", "Please enter a value");
            return;
        }
        else if(cost.matches("[^0-9]")){
            ErrorMessage("Error", "Please do not enter letters.");
            return;
        }else if(Integer.parseInt(cost) < 0){
            ErrorMessage("Error", "The value should be bigger than zero.");
            return;
        }else if (Serial.isEmpty()) {
            ErrorMessage("Error", "Please enter a valid Serial Number ");
            return;
            //Has to be the lenght of 13 A-XXX-xxx-XXX
        }else if(Serial.length() < 13){{
            ErrorMessage("Error", "Please enter a valid Serial Number; The Serial Number should match the format A-XXX-XXX-XXX");
            return;
        }
            //Check for errors
        }else if(!matcher.find()) {
            ErrorMessage("Error", "The Serial Number should match the format A-XXX-XXX-XXX");
            return;

            //Working
       }else if(!RepetitionChecker(Serial)){
            ErrorMessage("Error", "The Serial Number already exists");
            return;

        } else {
            Item x = new Item(name,"$" + cost,Serial);
            System.out.println(x);
            InventoryList.add(x);
            Inventory.setItems(InventoryList);
            Inventory.refresh();

            Item_Field.clear();
            Cost_Field.clear();
            SerialNum_Field.clear();

        }

        if(Inventory.getItems().size() >=1024){
            ErrorMessage("Error","Maximum capacity reached. You cannot add any more items");
            return;
        }

    }


    @FXML
    void Clear1(ActionEvent event) {
        // be able to clear of all of the items that make up the list
        InventoryList.clear();
        // Clear the list
    }


    @FXML
    void Edit1(ActionEvent actionEvent) {
        // Function able to replace the old text with the new one once the selection is clicked
        //Display an error message once the user enters an existing serial number
        //Display an error message once the user enters an invalid item value
        //Display an error message once the user enters an invalid item name

        int index= Inventory.getSelectionModel().getSelectedIndex();
        System.out.println(index);

        String modifiedName= Item_Field.getText();
        String modifiedCost = Cost_Field.getText();
        String modifiedSerial = SerialNum_Field.getText();

        Matcher matcher = pattern.matcher(modifiedSerial);

        if(Inventory.getSelectionModel().getSelectedItem()==null){
            ErrorMessage("Error", "Please select an item to modify");
        }
        else if(!RepetitionChecker(modifiedSerial) && !modifiedSerial.isEmpty()) {
            ErrorMessage("Error", "This serial number already exists.");
        }

        else {
            if (modifiedName != InventoryList.get(index).getItem_Name() && !modifiedName.isEmpty()) {
                InventoryList.get(index).setItem_Name(modifiedName);
            }

            if (modifiedCost != InventoryList.get(index).getValue()  && !modifiedCost.isEmpty()){
                InventoryList.get(index).setValue("$" + modifiedCost);


            }

            if (modifiedSerial != InventoryList.get(index).getSerialNum() && !modifiedSerial.isEmpty()) {
                InventoryList.get(index).setSerialNum(modifiedSerial);
            }
            }

            Inventory.refresh();

            Item_Field.clear();
            Cost_Field.clear();
            SerialNum_Field.clear();

            Inventory.getSelectionModel().clearSelection();
            return;
        }





    @FXML
    public void HelpButton(javafx.event.ActionEvent actionEvent) throws IOException {
        //Function able to open the othe FXML file and display the instructions and a help guide for the user to follow
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Help.fxml"));
        Parent root1 = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Help");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
        //load FXML file

    }

    @FXML
    void Remove1(ActionEvent event) {
        // Be able to remove just the selected item from the list
        Item selectedItem = Inventory.getSelectionModel().getSelectedItem();
        Inventory.getItems().remove(selectedItem);
    }

    public ObservableList<Item> RemoveHelper(String item, String Value, String SerialNum){
        //function set up in order to be able to test the function
        Item new_task = new Item(item,Value, SerialNum);
        ObservableList<Item> temp= InventoryList;
        temp.remove(new_task);

        return temp;
    }

    @FXML
    public void SaveButton(javafx.event.ActionEvent actionEvent) {
        Window stage = InventoryView.getScene().getWindow();
        fileChooser.setTitle("Save Inventory List");
        fileChooser.setInitialFileName("InventoryList");
        try {
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());

            if (fileChooser.getSelectedExtensionFilter().getDescription().equals("TSV")) {
                FileWriter W = new FileWriter(file); //Here we are going to write
                W.write("Item Name:          Cost Value:        Serial Number:         ");
                for (int i = 0; i < InventoryList.size(); i++) {
                    W.write("\n" + InventoryList.get(i).getItem_Name() + "\t\t" + InventoryList.get(i).getValue() + "\t\t" + InventoryList.get(i).getSerialNum());
                }
                W.close();
            }//Working

            else if (fileChooser.getSelectedExtensionFilter().getDescription().equals("HTML")) {

                PrintWriter BW = new PrintWriter(file);

                BW.printf("<html>");
                BW.printf("<body>");
                BW.printf("<h1 align = center> Inventory List </h1>");
                BW.printf("<table align = center border = 1 style = background-color:#ffc0cb cellpadding = 5 cellspacing = 5>");


                BW.printf("<tr><th><font size = 5 >Price</th><th><font size = 5 >Serial Number</th><th><font size = 5 >Name</th><tr>");
                for (int i = 0; i < InventoryList.size(); i++) {

                    BW.printf("<tr><td><font size = 4>" + InventoryList.get(i).getValue() + "</td><td><font size = 4>" + InventoryList.get(i).getSerialNum() + "</td><td><font size = 4>" + InventoryList.get(i).getItem_Name() + "</td></tr>");

                }
                BW.printf("</table>");
                BW.printf("</body>");
                BW.printf("</html>");

                BW.close();
            } else if(fileChooser.getSelectedExtensionFilter().getDescription().equals("JSON")){
                    FileWriter A = new FileWriter(file);

                    //We create the JSON Object
                    JSONObject obj = new JSONObject();
                    //We add the list of inventory to the object
                    obj.put("Inventory",InventoryList); //Here we are adding the List object which contains al the items with their information
                    //System.out.println(obj);
                    A.write(obj.toString()); //Writing the object
                    A.close(); //Close writer
                }

            }catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    @FXML
    void LoadButton(ActionEvent event) throws IOException {
        // Function able to load the last saved file of the inventory
        // Window Stage
        // FileChooser for the title, initial File name, and extensions
        // File Reader
        // Buffer Reader
            // be able to print everything that is on the list into the file
        Window stage = InventoryView.getScene().getWindow();
        fileChooser.setTitle("Load InventoryList");

        File file= fileChooser.showOpenDialog(stage);
        fileChooser.setInitialDirectory(file.getParentFile());
        FileReader reader= new FileReader(file);

        if(fileChooser.getSelectedExtensionFilter().getDescription().equals("TSV")) {
            String name = "";
            BufferedReader bs = new BufferedReader(reader);
            String line = bs.readLine();
            InventoryList.clear();

            while ((line = bs.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                String item = tokenizer.nextToken();
                String CostValue = tokenizer.nextToken();
                String SerialNum = tokenizer.nextToken();
                InventoryList.add(new Item(item, CostValue, SerialNum));
            }
        }

        else if(fileChooser.getSelectedExtensionFilter().getDescription().equals("HTML")){
            InventoryList.clear();
            Inventory.refresh();

            Document htmlDoc = null;
            htmlDoc = Jsoup.parse(new File(file.getPath()), "ISO-8859-1");

            org.jsoup.nodes.Element table = htmlDoc.select("table").get(0);
            org.jsoup.select.Elements rows = table.select("tr");

            for(int i = 2; i < rows.size(); i++){
                Element row = rows.get(i);
                Elements cols = row.select("td");
                Item x = new Item("","","");

                x.setItem_Name(cols.get(2).text()); //Loading Name
                x.setValue(cols.get(1).text()); //Loading Value
                x.setSerialNum(cols.get(0).text()); //Loading Serial

                InventoryList.add(x); //Adding to the list
            }

        }
        //tra
        else if(fileChooser.getSelectedExtensionFilter().getDescription().equals("JSON")){
            InventoryList.clear();
            Gson gson = new Gson();
            Helper parse = gson.fromJson(reader,Helper.class);
            System.out.println(parse.getDescriptor().size());

        }//Working

        Inventory.setItems(InventoryList);
        Inventory.refresh();

    }

    @FXML
    private void ErrorMessage(String title, String message){
        // Print the error message that will be display every time one of the requisites are not met
            Alert box= new Alert((Alert.AlertType.ERROR));
            box.setTitle(title);
            box.setContentText(message);
            box.showAndWait();
    }

    public Boolean RepetitionChecker(String item){
        for( int i =0; i<InventoryList.size(); i++){
            if(InventoryList.get(i).getSerialNum().equals(item))
                return false;
        }
        return true;
    }


    //Working - Completed.
    public void Search(ActionEvent actionEvent) {
        Search_Item.clear();

        if(Item_Search.getText().isEmpty() && Radio_btn.isSelected()){
            ErrorMessage("Error","Please enter a serial number or name");
            Radio_btn.setSelected(false);
            return;
        }
        if(!Radio_btn.isSelected()){
            Inventory.setItems(InventoryList);
            Inventory.refresh();
        }
        else {
            for (int i = 0; i < InventoryList.size(); i++) {
                if (InventoryList.get(i).getItem_Name().equals(Item_Search.getText()) || InventoryList.get(i).getSerialNum().equals(Item_Search.getText())) {
                    Search_Item.add(InventoryList.get(i));
                }
            }
            if(Search_Item.isEmpty()){
                ErrorMessage("Error","There aren't any item with that name or serial number");
                Radio_btn.setSelected(false);
            }
            else {
                Inventory.setItems(Search_Item);
                Inventory.refresh();
            }
        }
        Item_Search.clear();
        return;

    }



}


