package application;

import java.io.IOException;

import businessPackage.Customer;
import dbpackage.DbPersistanceHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    public TextField usernametext;

    @FXML
    private PasswordField passwordtext;

    @FXML
    private Button loginbutton;

    @FXML
    private Button signupbutton;
    
    @FXML
    private CheckBox admincheckbox;

    @FXML
    void checkboxaction(ActionEvent event) {
    	
    }

    @FXML
    void loginaction(ActionEvent event) throws IOException {
    	String adminUser = "User";
    	String adminPassword = "11111";
    	DbPersistanceHandler dh = DbPersistanceHandler.getInstance();
    	
    	String un = usernametext.getText();
    	String pw = passwordtext.getText();
    	
    	
    	System.out.print("Username entered in textbox is: ");
    	System.out.println(un);
    	
    	System.out.print("Password entered in textbox is: ");
    	System.out.println(pw);
    	
    	if(usernametext.getText().isEmpty() || passwordtext.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setContentText( "Incorrect password or user" );
        	alert.show( );
    	}
    	else {
	    	if(admincheckbox.isSelected()) {
	    		
	    		if(un.equals(adminUser)  && pw.equals(adminPassword)) {
	    			Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
		        	Stage window = (Stage) loginbutton.getScene().getWindow();
		        	window.setScene(new Scene(root, 850, 650));
	    		}
	    		else {
	    			Alert alert = new Alert(AlertType.INFORMATION);
	            	alert.setContentText( "Incorrect password or user" );
	            	alert.show( );
	    		}
	    	}
	    	else {
	    		Customer c= new Customer();
	    		
	    		String result = c.getCustomerPasswordDb(un);
	    		if(result == null) {
	//    			System.out.print("\nIncorrect password or user"+result+"\n");
	    			Alert alert = new Alert(AlertType.INFORMATION);
	    	    	alert.setContentText( "Incorrect password or user" );
	    	    	alert.show( );
	    		}
	    		else {
	    			if(pw.equals(result)) {
	    		      	FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerHome.fxml"));
	    		    	Parent root = loader.load();
	    		    	CustomerHomeController ch = loader.getController();
	    		    	ch.setUserId(c.getCustomerIdDb(un));
	    		    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    		    	Scene scene = new Scene(root);
	    		    	stage.setScene(scene);
	    		    	stage.show();
					}
	    		}
	    	}
    	}

    	
//    	Stage window = (Stage) loginbutton.getScene().getWindow();
//    	window.setScene(new Scene(root, 850, 650));
    	
//    	if(un.equals("Farquleet") && pw.equals("12345"))
//    	{
//    		Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
//        	Stage window = (Stage) loginbutton.getScene().getWindow();
//        	window.setScene(new Scene(root, 850, 650));
//    	}
//    	else {
//    		Parent root1 = FXMLLoader.load(getClass().getResource("CustomerHome.fxml"));
//        	Stage window = (Stage) loginbutton.getScene().getWindow();
//        	window.setScene(new Scene(root1, 850, 650));
//    		
//    	}
  
    	
    }

    @FXML
    void signupaction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
    	Stage window = (Stage) signupbutton.getScene().getWindow();
    	window.setScene(new Scene(root, 850, 650));

    }

}