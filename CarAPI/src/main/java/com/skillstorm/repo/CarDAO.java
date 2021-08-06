package com.skillstorm.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skillstorm.model.Car;
import com.skillstorm.util.ConnectionFactory;

public class CarDAO {

	public Car createCar(Car car) throws ClassNotFoundException   // POST Method diye hobe
	{
		
				String sql= "insert into cardb (id,vin,model,make,mileage) values(?,?,?,?,?)";
				try(Connection conn= ConnectionFactory.getConnection()) {
					
					
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1,car.getId());
					ps.setString(2, car.getVin());
					ps.setString(3, car.getModel());
					ps.setString(4, car.getMake());
					ps.setInt(5, car.getMileage());
					//System.out.println("Check2");
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
	
	public void updateCar(Car car) throws ClassNotFoundException  // PUT Method
	{
		String sql = "Update cardb set  vin=(?),model=(?),make=(?),mileage=(?) where id=(?)";
		
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
		
		
	}
	public void delete(Car car) throws ClassNotFoundException, SQLException
	{
		
		String sql="Delete from cardb where id=(?)";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Car> displayAll() throws ClassNotFoundException
	{
		List<Car> result= new ArrayList<Car>();
		String sql= "Select * from cardb";
		try(Connection conn= ConnectionFactory.getConnection()) {
			
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String vin=rs.getString("vin");
				String model=rs.getString("model");
				String make=rs.getString("make");
				int mileage=rs.getInt("mileage");
				Car car= new Car(id,vin,model,make,mileage);
				result.add(car);
				
			}
			
		}catch(NullPointerException e)
		{
			
			System.out.println("Username doesn't exist");
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Car> findByMake(String make) throws ClassNotFoundException
	{
		List<Car> result= new ArrayList<Car>();
		String sql= "SELECT * FROM cardb WHERE make= (?)";
		try(Connection conn= ConnectionFactory.getConnection()) {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, make);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				int id=rs.getInt("id");
				String vin=rs.getString("vin");
				String model=rs.getString("model");
				String carMake=rs.getString("make");
				int mileage=rs.getInt("mileage");
				Car car= new Car(id,vin,model,carMake,mileage);
				result.add(car);
			}
			
		}catch(NullPointerException e)
		{
			
			System.out.println("Username doesn't exist");
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Car findByID(int id) throws ClassNotFoundException
	{
   
		String sql= "SELECT * FROM cardb WHERE id= (?)";
		try(Connection conn= ConnectionFactory.getConnection()) {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			
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
