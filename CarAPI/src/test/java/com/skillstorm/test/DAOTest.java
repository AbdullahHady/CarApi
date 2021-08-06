package com.skillstorm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skillstorm.model.Car;



public class DAOTest {
	
	private final static String url = "jdbc:mysql://localhost:3306/testdb";
	private final static String username = "root";
	private final static String password = "root";

	TestCarDAO dao= new TestCarDAO();
	

   
	@Test
	public void InsertTest() 
	{
		
		try 
		{
			String sql = "select count(*) from testCardb";
			Connection conn = DriverManager.getConnection(url, username, password); 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			int rowsBefore = rs.getInt(1);
			//System.out.println("before row num"+rowsBefore);
			 
			dao.createCar(new Car(1,"1256WY78UO98", "Solara","Toyota",6070)); // creating a car object 
			
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql);
			rs2.next();
			int rowsAfter = rs2.getInt(1);
			//System.out.println("After row num"+rowsAfter);
			Thread.sleep(20_000);
			
			assertEquals(rowsAfter, ++rowsBefore);
			
			
		} catch (Exception e) 
		{
			fail();
		}
		
	
		
	}
	
	@Test
	public void deleteTest()
	{
		try 
		{
			dao.createCar(new Car(1,"1256WY78UO98", "Solara","Toyota",6070)); // Creating a car object 
			String sql = "select count(*) from testCardb";                    // counting no. of rows before deletion 
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			int rowsBefore = rs.getInt(1);
			//System.out.println("before row num in delete "+rowsBefore);
			Thread.sleep(20_000);
			 
			dao.delete(new Car(1,"1256WY78UO98", "Solara","Toyota",6070)); //Deleting car object
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql);
			rs2.next();
			int rowsAfter = rs2.getInt(1);     // counting no. of rows after deletion 
			//System.out.println("After row num in delete "+rowsAfter);
			
	        assertEquals(rowsAfter+1, rowsBefore);
			//Thread.sleep(30_000);
			
		} catch (Exception e) 
		{
			fail();
		}
		
	}
	
	@Test
	public void updateTest()
	{
		try 
		{
			
			
			dao.createCar(new Car(1,"1256WY78UO98", "Solara","Toyota",6070)); // Creating a car object 
			
	        Car car1= dao.updateCar(new Car(1,"8726AY794Y9T", "Sedona","Jaguar",8974)); // Updating the same car object
			
			Car car2=dao.retrieveCar(car1); // Retrieving that updated object
			
			
			assertEquals(car1.getVin(), car2.getVin()); // Checking if all fields are same updated
			assertEquals(car1.getModel(), car2.getModel());
			assertEquals(car1.getMake(), car2.getMake());
			assertEquals(car1.getMileage(), car2.getMileage());
		
		} catch (Exception e) 
		{
			fail();
		}
		
	}
	
	@Before
	public void beforeTest() 
	{
		
		System.out.println("hello");
		try 
		{
			String ddl = "CREATE TABLE `testdb`.`testCardb` (`id` INT NOT NULL , `vin` VARCHAR(45) NOT NULL,`model` VARCHAR(45) NOT NULL,`make` VARCHAR(45) NOT NULL,`mileage` INT NOT NULL, PRIMARY KEY (`id`));";
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(ddl); 
			System.out.println("Test table created");
			conn.close();
		} 
		catch (Exception e) 
		{
			fail();
		}
	}
    
	@After
	public void afterTest() 
	{
		try 
		{
			String sql="drop table testCardb";
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql); 
			System.out.println("Test table dropped");
			conn.close();
		} 
		catch (Exception e) 
		{
			fail();
		}
	}
	

}
