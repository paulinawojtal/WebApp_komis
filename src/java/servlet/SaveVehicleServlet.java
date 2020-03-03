/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ObjectDAO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vehicle;

/**
 *
 * @author PaulinaMaciej
 */

@WebServlet(urlPatterns = "/saveVehicle")
public class SaveVehicleServlet extends HttpServlet{

    @Inject
    private ObjectDAO<Vehicle> dao;
    
    private Vehicle formToVehicle(HttpServletRequest req){
        Vehicle vehicle = new Vehicle();
        
        vehicle.setBrand(req.getParameter("brand"));
        vehicle.setType(req.getParameter("type"));
        vehicle.setYear(Integer.parseInt(req.getParameter("year")));
        vehicle.setMileage(Integer.parseInt(req.getParameter("mileage")));
        vehicle.setRegNumber(req.getParameter("regNumber").toUpperCase());
        vehicle.setVin(req.getParameter("vinNumber").toUpperCase());
        String date = req.getParameter("regDate");
        vehicle.setRegDate(convertToDate(date));
        System.out.println("Data: " + vehicle.getRegDate());
        
        System.out.println(vehicle.toString());
        return vehicle;
    }
    
    private Date convertToDate(String date){
        Date date1 = null;
        //java.sql.Date sqlDate = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            date1 = dateFormat.parse(date);
            //sqlDate = new java.sql.Date(date1.getTime());
            
        } catch(ParseException exception){
            exception.printStackTrace();
        }
        //System.out.println("Data po konwersji: " + sqlDate);
        //return sqlDate;
        return date1;
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vehicle vehicle = formToVehicle(req);
        
        try{    
            dao.saveObject(vehicle);
            
            req.getRequestDispatcher("vehicleSaved.html").forward(req, resp);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
