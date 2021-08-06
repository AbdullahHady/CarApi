package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.model.Car;
import com.skillstorm.repo.CarDAO;

@WebServlet(urlPatterns="/api/car")
public class CarServlet extends HttpServlet {
	CarDAO cao= new CarDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("id") !=null)
		{
			int id= Integer.parseInt(req.getParameter("id"));
			try {
				Car car = cao.findByID(id);
				String json= new ObjectMapper().writeValueAsString(car); // converting Java object to JSON
				System.out.println(json);
				resp.getWriter().print(json);   // Writing (Printing) data to the response 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		else if(req.getParameter("make") !=null)
		{
			List<Car> cars;
			String make= req.getParameter("make");
			
			try {
				cars=cao.findByMake(make);
				String json=new ObjectMapper().writeValueAsString(cars);
				System.out.println(json);
				resp.getWriter().print(json);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			List<Car> cars;
			try {
				cars = cao.displayAll();
				String json=new ObjectMapper().writeValueAsString(cars);
				System.out.println(json);
				resp.getWriter().print(json);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		InputStream reqBody = req.getInputStream(); // Getting the input JSON object 
		Car car = new ObjectMapper().readValue(reqBody, Car.class); // Converting that json to java object
		System.out.println("Random print "+ car);
		try {
			Car carObj = cao.createCar(car);
			resp.getWriter().print(carObj); // Printing the Java obj in client side
			
			String json= new ObjectMapper().writeValueAsString(carObj); // Converting Java obj to JSON.
			resp.getWriter().print(json);
			
			// resp.setStatus(201); // To set customized Status
			//resp.setContentType("application/json"); // To set customized format
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().print(new Car()); // empty objct 
		}
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		InputStream reqBody = req.getInputStream(); // Getting the input JSON object 
		Car car = new ObjectMapper().readValue(reqBody, Car.class); // Converting that json to java object
		 
		try {
			  cao.updateCar(car);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		Car car= new Car(id);
		
		try {
			cao.delete(car);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

	


