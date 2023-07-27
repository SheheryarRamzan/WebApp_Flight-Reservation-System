package businessPackage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dbpackage.DbPersistanceHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightSchedule {
	private Vector<Flight> FlightArr= new Vector<Flight>();

	public void addFlight(Flight f) {
		FlightArr.add(f);
	}
	 public ObservableList<Flight> getFlightTableList() throws SQLException{
		 ObservableList<Flight> List = FXCollections.observableArrayList();
    	 DbPersistanceHandler dh = DbPersistanceHandler.getInstance();
	 
//    	 dh.saveFlight(250, "Pakistan","India", "15:10:00", "15:01:00", "Ontime",15200);
//    	 dh.saveFlight(250, "Islamabad","Lahore", "14:10:00", "17:01:00", "Ontime",15200);
//    	 dh.saveFlight(250, "London","America", "17:10:00", "19:01:00", "Ontime",15200);
//    	 dh.saveFlight(250, "Multan","Islamabad", "12:10:00", "19:01:00", "Ontime",15200);
//    	 dh.saveFlight(250, "Karachi","Multan", "16:10:00", "18:01:00", "Ontime",15200);
//    	 	 
    	 ResultSet rs = dh.getFlight();
    	 Flight row;
    	 
    	 while(rs.next()) {
    		 row = new Flight(rs.getString(1), rs.getInt(2), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getInt(9));
    		 List.add(row);
    	 }
    	 
    	 return List;

	 }
	 
	 public ObservableList<Flight> getSpecificFlightTableList(String bookedFlight) throws SQLException{
		 ObservableList<Flight> List = FXCollections.observableArrayList();
    	 DbPersistanceHandler dh = DbPersistanceHandler.getInstance();

    	 ResultSet rs = dh.getFlightById(bookedFlight);
    	 Flight row;
    	 
    	 while(rs.next()) {
    		 row = new Flight(rs.getString(1), rs.getInt(2), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getInt(9));
    		 List.add(row);
    	 }
    	 
    	 return List;

	 }
	 public ObservableList<Flight> getSpecificFlightTableList(String dep, String des) throws SQLException{
		 ObservableList<Flight> List = FXCollections.observableArrayList();
    	 DbPersistanceHandler dh = DbPersistanceHandler.getInstance();

    	 ResultSet rs = dh.runCustomQuery1("select * from flight where startingplace = '"+dep+"' and destination = '"+des+"'");
    			 
    	 Flight row;
    	 
    	 while(rs.next()) {
    		 row = new Flight(rs.getString(1), rs.getInt(2), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getInt(9));
    		 List.add(row);
    	 }
    	 
    	 return List;

	 }
}
