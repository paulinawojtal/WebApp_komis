/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ObjectDAO;
import java.io.IOException;
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
@WebServlet(urlPatterns = "/deleteVehicleById")
public class DeleteVehicleByIdServlet extends HttpServlet{
    
    @Inject
    private ObjectDAO<Vehicle> dao;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        try{
            dao.deleteObjecttById(id);
            req.getRequestDispatcher("vehiclesList").forward(req, resp);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    
}
