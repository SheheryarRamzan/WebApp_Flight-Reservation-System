package businessPackage;

import dbpackage.DbPersistanceHandler;

public class Customer {

	private String customerName;
	private String customerId;
	private String customerPassword;
	private String customerPhone;

	public Customer(String n, String p, String pno){ 
		customerName = n;
		customerPassword = p;
		customerPhone = pno;
	}

	public Customer() {
		customerId="";
	}
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerPasswordDb(String name) {
		DbPersistanceHandler dh = DbPersistanceHandler.getInstance();
		String result = dh.runCustomQuery2("select * from customer where customerName='"+name+"'", "customerPassword");
    	return result;
	}
	public String getCustomerIdDb(String name) {
		DbPersistanceHandler dh = DbPersistanceHandler.getInstance();
		String result =  dh.runCustomQuery2("select * from customer where customerName='"+name+"'", "customerId");
    	return result;
	}
	public void saveCustomerDb() {
		DbPersistanceHandler dh = DbPersistanceHandler.getInstance();
    	dh.saveCustomer(customerName,customerPassword, customerPhone);
    	
	}
		
}
