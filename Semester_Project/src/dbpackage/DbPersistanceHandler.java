package dbpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbPersistanceHandler {
	private String user;
	private String password;
	private String connectionString;
	private static DbPersistanceHandler dh;
	private DbPersistanceHandler(){
		user ="system";
		password = "minime@123";
		connectionString = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Driver Loaded Successfully1!");
	
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
						connectionString,user,password); 
				
				System.out.println("Connection Established!1");
				
				String sql = "";
				Statement st ;
				
				sql =  "create table Admin(adminId varchar(25), "
						+ "password varchar(25))";
				st = con.createStatement();
				st.execute(sql);
				
				sql =  "create table Customer(customerId varchar(25), "
						+ "customerName varchar(25), "
						+ "customerPassword varchar(25), "
						+ "customerPhone varchar(11))";
				st = con.createStatement();
				st.execute(sql);
				
				sql =  "create table Flight(flightId varchar(25), "
						+ "totalSeat number, "
						+ "availableSeat number, "
						+ "destination varchar(25), "
						+ "startingPlace varchar(25), "
						+ "uptime varchar(25), "
						+ "downtime varchar(25), "
						+ "status varchar(25), "
						+ "price number)";
				st = con.createStatement();
				st.execute(sql);
						
				sql =  "create table Booking(bookingId varchar(25), "
						+ "customerId varchar(25), "
						+ "flightId varchar(25), "
						+ "noOfSeat varchar(25))";
				st = con.createStatement();
				st.execute(sql);
				
				sql =  "create table Payment(paymentId varchar(25), "
						+ "amount number, "
						+ "customerId varchar(25))";
				st = con.createStatement();
				st.execute(sql);
				
			
				
				con.close();
			
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		} catch (SQLException e) {
			//e.printStackTrace();
		}  
	}
	public static DbPersistanceHandler getInstance() {
		if(dh == null) {
			dh= new DbPersistanceHandler();
		}
		
		return dh;	
	}
	
	private String idAssigner(String table) throws SQLException {	
		
		Connection con=DriverManager.getConnection(  
				connectionString,user,password);
		int counter=0;
		
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery("select * from "+table+"");  
		while(rs.next()) {
			counter = Integer.parseInt(rs.getString(1));
			counter++;
		}
		
		
		return Integer.toString(counter);
	}
	
	 public void saveCustomer(String name, String pass, String phoneno) {
			try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				String sql ;
				Statement st ;
				 sql  = "INSERT INTO Customer VALUES ('"+idAssigner("Customer")+"','"+name+"','"+pass+"','"+phoneno+"')";
				 st = con.createStatement(); 
				 st.executeQuery(sql);
				 
				con.close();

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			

	}
	 public void saveFlight(int totalSeats, String des, String start, String uptime, String downtime, String status, int price) {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				String sql ;
				Statement st ;
				 sql  = "INSERT INTO Flight VALUES ('"+idAssigner("Flight")+"','"+totalSeats+"','"+totalSeats+"','"+des+"','"+start+"','"+uptime+"','"+downtime+"','"+status+"','"+price+"')";
				 st = con.createStatement(); 
				 st.executeQuery(sql);
				 
				con.close();

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	 }
	 public void saveAdmin(String id, String pass) {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				String sql ;
				Statement st ;
				 sql  = "INSERT INTO Admin VALUES ('"+id+"','"+pass+"')";
				 st = con.createStatement(); 
				 st.executeQuery(sql);
				 
				con.close();

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	 }
	 public void savePayment(int amount, String cusid) {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				String sql ;
				Statement st ;
				 sql  = "INSERT INTO Payment VALUES ('"+idAssigner("Payment")+"','"+amount+"','"+cusid+"')";
				 st = con.createStatement(); 
				 st.executeQuery(sql);
				 
				con.close();

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	 }
	 public void saveBooking( String custid, String fid, String seatNo) {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				String sql ;
				Statement st ;
				 sql  = "INSERT INTO Booking VALUES ('"+idAssigner("Booking")+"','"+custid+"','"+fid+"','"+seatNo+"')";
				 st = con.createStatement(); 
				 st.executeQuery(sql);
				 
				con.close();

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	 }
	 
	 public ResultSet getCustomer() {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from Customer");  
				return rs;
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null; 
			
	 }
	 
	 public ResultSet getBooking() {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
	
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from Booking ");  
				return rs;

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null; 
			
	 }
	 public ResultSet getBookingByCustomer(String id) {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
	
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from Booking where customerId = '"+id+"'");  
				return rs;

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null; 
			
	 }
	 public void deleteBooking(String id) {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				Statement st = con.createStatement();
				st.executeQuery("delete from booking where bookingId = '"+id+"'");  
				 System.out.print(st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			
	 }
	 public ResultSet getPayment() {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				
		
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from Payment");  
				return rs;

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null; 
			
	 }
	 public ResultSet getFlight() {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from Flight");  
				return rs;

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null; 
			
	 }
	 public ResultSet getFlightById(String fid) {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from Flight where flightId = '"+fid+"'");  
				return rs;

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null; 
			
	 }
	 public void deleteFlight(String id) {
		 try {
				Connection con=DriverManager.getConnection(  
						connectionString,user,password);
				
				Statement st = con.createStatement();
				st.executeQuery("delete from flight where flightId = '"+id+"'");  
				System.out.print(st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			
	 }
	
	 public String getCustomerPassword(String custname) {
		 try {
				Connection con=DriverManager.getConnection(connectionString,user,password);
				
				
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from Customer where customerName = '"+custname+"'");  
				rs.next();
				//System.out.print(rs.getString("customerId"));
				return rs.getString("customerPassword");

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null; 
	 }
	 
	 public ResultSet runCustomQuery1(String query) {
		 try {
				Connection con=DriverManager.getConnection(connectionString,user,password);
				
				
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery(query);  
				//System.out.print(rs.getString("customerId"));
				return rs;

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null; 
	 }
	 public String runCustomQuery2(String query, String attr) {
		 try {
				Connection con=DriverManager.getConnection(connectionString,user,password);
				
				
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery(query);  
				if(rs.next()) {
					System.out.print("\n"+rs.getString(attr)+"\n");
					
					//System.out.print(rs.getString("customerId"));
					return rs.getString(attr);
				}
				else {
					return null;
				}
				
			

				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null; 
	 }
}
