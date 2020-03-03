/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ObjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import model.Vehicle;

/**
 *
 * @author PaulinaMaciej
 */
@WebServlet(urlPatterns = "/updateVehicleById")
public class UpdateVehicleByIdFirst extends HttpServlet{
    
    @Inject
    private ObjectDAO<Vehicle> dao;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        String idString = req.getParameter("id");
        
        Vehicle vehicle = dao.findObjectById(Integer.parseInt(idString));
        
        if(!vehicle.equals(null)){
            req.setAttribute("vehicle", vehicle);
        
            req.getRequestDispatcher("vehicleForm.jsp").forward(req, res);
        }else{
            PrintWriter pw = res.getWriter();
            pw.println("<HTML><HEAD>");
            pw.println("<meta charset=\"UTF-8\">");
            pw.println("<TITLE>Errpr</TITLE>");
            pw.println("</HEAD><BODY>");
            pw.println("<H3>No Vehicle with specific ID in database</H3>");
            pw.println("<input type=\"button\" onclick=\"location.href='vehiclesList';\" value=\"Search vehicle\" /><br>");
            pw.println("<a href=\"start.jsp\">Back to menu</a>");
            pw.println("</BODY></HTML>");
        }
        
        
        
    }
    
    
    
}
