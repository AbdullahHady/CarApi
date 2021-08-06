package com.skillstorm.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skillstorm.model.Car;
import com.skillstorm.util.ConnectionFactory;

public class TestCarDAO {
	
	public Car createCar(Car car) throws ClassNotFoundException   // POST Method diye hobe
	{
		
				String sql= "insert into testCardb (id,vin,model,make,mileage) values(?,?,?,?,?)";
				try(Connection conn= ConnectionFactory.getConnection()) {
					
					
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1,car.getId());
					ps.setString(2, car.getVin());
					ps.setString(3, car.getModel());
					ps.setString(4, car.getMake());
					ps.setInt(5, car.getMileage());
				    ps.execute();
		
					
				}catch(NullPointerException e)
				{
					
					System.out.println("Username doesn't exist");
					
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return car;
		
	}
	
	
	
	public void delete(Car car) throws ClassNotFoundException, SQLException
	{
		
		String sql="Delete from testCardb where Id=(?)";
		try(Connection conn=ConnectionFactory.getConnection())
		{
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, car.getId());
			ps.execute();
		}catch(NullPointerException e)
		{
			
			System.out.println("Username doesn't exist");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Car updateCar(Car car) throws ClassNotFoundException  // PUT Method
	{
		String sql = "Update testCardb set  vin=(?),model=(?),make=(?),mileage=(?) where Id=(?)";
		
		try(Connection conn= ConnectionFactory.getConnection()) {
			
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, car.getVin());
			ps.setString(2, car.getModel());
			ps.setString(3, car.getMake());
			ps.setInt(4, car.getMileage());
			ps.setInt(5, car.getId());
			ps.execute();
			
		   // conn.close();

			
		}catch(NullPointerException e)
		{
			
			System.out.println("Username doesn't exist");
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
		
		
	}
	
	public Car retrieveCar(Car car) throws ClassNotFoundException
	{
        
		
		String sql= "SELECT * FROM testCardb WHERE Id= (?)";
		try(Connection conn= ConnectionFactory.getConnection()) {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,car.getId());
			
			ResultSet rs= ps.executeQuery();
			rs.next();
			return new Car(rs.getInt("id"),rs.getString("vin"),rs.getString("model"),rs.getString("make"),rs.getInt("mileage"));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
