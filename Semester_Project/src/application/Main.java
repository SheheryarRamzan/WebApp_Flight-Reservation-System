package application;
	
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbpackage.DbPersistanceHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
	
public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login Form");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
      
		
	}
	
	public static void main(String[] args) throws SQLException {
		launch(args);
	
		
		
	}
}
/*
 * handle if no results of query in dbhandler
 * paymentcontroller table to be minimize, enter more columns, remove amount box
 * remove back button from delete, view booking
 * back button is admin not required
 */