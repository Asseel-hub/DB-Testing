import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	
	//WebDriver driver = new ChromeDriver();
	Random rand1 = new Random();
	Random rand2=new Random();
	int randomNumber= rand1.nextInt(666);

	Connection con ;
	Statement stmt;
	ResultSet rs;
	

	@BeforeTest
	public void MySetUp() throws SQLException {
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Aa123456789");
	}
	
	
	@Test (priority = 3 )
	public void GetData() throws SQLException {
		stmt=con.createStatement();
		rs =stmt.executeQuery("SELECT * FROM customers where customerNumber="+randomNumber+";");
		
	      while(rs.next()){ // هل يوجد داتا من هذا الاستعلام ؟
	    	  
		        int customerNumberInDatabase= rs.getInt("customerNumber"  );
		        String customerNameInDatabase=rs.getString("customerName");
		        System.out.println(customerNumberInDatabase);
		        System.out.println(customerNameInDatabase);
		        
		        String fistName=rs.getString("contactFirstName");
		        String lastName=rs.getString("contactLastName"); }
	      
	      
		//driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		//WebElement firstname = driver.findElement(By.id("firstname"));
		//WebElement lastname = driver.findElement(By.id("lastname"));
		//firstname.sendKeys(fistName);
		//lastname.sendKeys(lastName);
		        
	      }
	
	@Test(priority = 1 ,invocationCount = 10)
	public void AddData() throws SQLException {
		int randomNumber= rand1.nextInt(666);

		System.out.println(randomNumber);
		//"+randomNumber+"
		 String query = "INSERT INTO customers ( customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit )"
		 		+ "		VALUES ("+randomNumber+", 'Corp', 'Sam', 'Jony', '555-1234', '123 Elm Street', 'Suite 4B', 'Springfield', 'IL', '62701', 'USA', 1370, 50000.00 );";
		 		
	        stmt=con.createStatement();
	        int rowInserted = stmt.executeUpdate(query);
		 	System.out.println("Rows inserted: " + rowInserted);	
		 				
		 		
	}
	
	@Test (priority = 2 ,enabled = false)
	public void UpdateData() throws SQLException {
		
		 String query = "update customers set contactFirstName ='soso' where customerNumber="+randomNumber;
			 		
		        stmt=con.createStatement();
		        int rowUpdated = stmt.executeUpdate(query);
			 	System.out.println("Rows updated: " + rowUpdated);	
			 				
		
		
	}
	
	
	@Test(priority = 4 , enabled = false)
	public void DeleteData() throws SQLException {
		
		 String query = "delete from customers where customerNumber = 2004";
		        stmt=con.createStatement();
		        int rowDeleted = stmt.executeUpdate(query);
			 	System.out.println("Rows deleted: " + rowDeleted);	
			 				
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}


